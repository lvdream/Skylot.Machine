package com.fangda.skylot.mathine.scheduler.springtask;

import com.fangda.skylot.mathine.model.customer.OftbReserveTakingCriteria;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.service.parking.ParkingService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.math.ParkingLogic;
import com.fangda.skylot.mathine.utils.socket.WSThreadMgt;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

/**
 * 主线程控制器
 */
@Component
public class MainThreadMgt extends MainThreadUtil {
    /**
     * 严重故障标示位
     */

    @Autowired
    private ErrorCode code;
    @Autowired
    private WSThreadMgt wsThreadMgt;

    /**
     * 主线程控制类
     *
     * @throws SkyLotException
     */
    public void go() throws SkyLotException, InterruptedException {
        try {
            if (wsThreadMgt.checkCommander() == 0) {
                Map map = Maps.newHashMap();
                map.put("name", "Thread");
                wsThreadMgt.putCommander(map);
                code.setErrorList(Lists.newArrayList());
                if (hasTasktodo()) {
                    boolean actionBoolean = isSyncedIMA();
                    if (StringUtils.equals(PARKING_PULLING_STATUS_FINISH, this.getTstbFtpCarInformation().getTfcCarAction())) {//当前状态是0,停车逻辑
                        if (!actionBoolean) {//当前工控机无法进行停车操作,工控机没有完成和SaaS的同步
                            throw new SkyLotException(EX_PARKING_USER_AUTH_OUT_SERVICE);
                        } else {
                            doParkingLogic();
                        }
                    } else if (StringUtils.equals(PARKING_PULLING_STATUS_PROGRESS, this.getTstbFtpCarInformation().getTfcCarAction())) {//当前状态是1,取车逻辑
                        doExtractLogic();
                    } else if (StringUtils.equals(SCHEDULEACTION_MODULEID_ITEMCUSTOMER, this.getTstbFtpCarInformation().getTfcCarAction())) {//当前状态是2,预约取车逻辑
                        doBookExtractLogic();
                    }
                }
                wsThreadMgt.getCommands();
            }
        } catch (Exception e) {
            if (StringUtils.contains(e.getMessage(), EX_PARKING_MATHINE_EXCEPTION)) {

            } else if (StringUtils.contains(e.getMessage(), EX_PARKING_USER_AUTH_OUT_SERVICE)) {
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],设备同步异常,不能完成停车操作!");
                getMarqueeUtil().sendText("SkyLot", "设备故障无法进行同步", true);
            }
            wsThreadMgt.getCommands();
            throw new SkyLotException(e);
        }
    }


    /**
     * 处理停车逻辑
     *
     * @return true, false
     */
    private boolean doParkingLogic() throws Exception {
        Map parkingMap = Maps.newHashMap();
        this.setErrorMap(Maps.newHashMap());
        Map valueMap = Maps.newHashMap();
        Map resultMap = Maps.newHashMap();
        int result = this.getSyncServiceImpl().checkPLC(2);
        try {
            if (result == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
                Map parkingsMap = getSocketService().getParkingStatus(0);
                if (MapUtils.isNotEmpty(parkingsMap) && parkingsMap.keySet().size() == 12) {
                    throw new SkyLotException(EX_PARKING_MATHINE_NOT_AVIABLE);
                }
                this.getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备可用,准备停车!");
                getMarqueeUtil().sendText("存车中", this.getTstbFtpCarInformation().getTfcCarCode() + "准备停车,等待设备旋转到位并打开车库门", true);
                //首先,旋转到位,打开车库门
                int s = 1;
                this.setHighError(false);
                this.setPeopleDoor(false);
                this.setCarDoor(false);
                while (s == 1) {//旋转,开门
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    parkingMap = getSocketService().doParking(this.getTstbFtpCarInformation().getTfcCarCode(), true);
                    heartBeatPLC("3", "1");
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],旋转车台,打开车库门");
                    getMarqueeUtil().sendText("存车中", this.getTstbFtpCarInformation().getTfcCarCode() + "车库门已开,请驶入停车位", true);
                    s = MapUtils.getIntValue(parkingMap, MAP_PARKING_STATUS);
                    resultMap = parkingMap;
                    if (s == 0) {
                        break;
                    } else if (s == NumberUtils.toInt(FN_RETURN_STATUS_HANDLE)) {//急停处理
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }

                }
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                        return false;
                    }
                }
                //其次,判断内部摄像头是否已经识别到车辆车牌,30秒延迟判断
                int a = 0;
                while (StringUtils.isEmpty(this.getTstbFtpCarInformation().getTfcCarInCode())) {
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "请正确驶入停车位,内部摄像头正在识别您的车牌!", true);
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                            return false;
                        }
                    }


                    //获取到1005状态信息,都是正常也是可以跳出循环
                    if (parkingError()) {
                        break;
                    }
                    Thread.sleep(1000);
                    heartBeatPLC("3", "2");
                    hasTasktodo();
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],读取内部摄像头数据");
                    a++;
                    if (a > NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.machine.operation.timeout"))) {//内部识别时间大于30秒,跳出循环,以外部识别到车牌为准
                        break;
                    }
                }
                a = 0;
                //最后判断,人行门开关一次
                while (!this.isPeopleDoor()) {
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "请按照地面指示,离开停车位,打开行人门!", true);
                    }
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],读取人行门开关数据");
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    peopleDoorhadOpen();
                    getSocketService().getIndexError();
                    valueMap = getSocketService().getAllStatus(true);
                    analyzingError(valueMap, "p");
                    heartBeatPLC("3", "2");

                    Thread.sleep(1000);
                    a++;
                }
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                        return false;
                    }
                }
                a = 0;
                s = 1;
                //判断1005的状态
                while (s == 1) {
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "系统正在进行安全检查", true);
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],读取1005数据");
                    Thread.sleep(300);
                    if (parkingError()) {
                        s = 0;
                    }
                    heartBeatPLC("3", "2");
                    Thread.sleep(1000);
                    a++;
                }
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                        return false;
                    }
                }
                //全部执行完成之后,将当前停车车辆的状态置为停车确认状态
                confirmCar();
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                        return false;
                    }
                }
                a = 0;
                //继续等待,等待用户发送确认指令,用户发送停车确认指令,状态置为3
                while (StringUtils.equals(SCHEDULEACTION_MODULEID_ITEMCUSTOMER, this.getTstbFtpCarInformation().getTfcStatus() + "")) {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],判断是否人为确认停车");
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "请在屏幕上确认停车", true);
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    hasTasktodo();
                    if (parkingError() && CollectionUtils.isEmpty(code.getErrorList())) {
                        heartBeatPLC("3", "3");
                    } else {
                        heartBeatPLC("3", "2");
                        if (checkCanceled()) {
                            if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                                return false;
                            }
                        }
                        this.getTstbFtpCarInformation().setTfcStatus(NumberUtils.toInt(SCHEDULEACTION_MODULEID_ITEMCUSTOMER));
                    }
                    Thread.sleep(1000);
                    a++;
                }
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                        return false;
                    }
                }
                //关车库门
                a = 0;
                this.setPeopleDoor(false);
                this.setCarDoor(false);


                getSocketService().carDoor(FN_RETURN_STATUS_ERROR);//执行关车门
                while (!isCarDoor()) {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],获取车库门关闭状态");
                    parkingError();
                    heartBeatPLC("3", "3");
                    carDoorhadClose();
                    getSocketService().writeCarcode(this.getTstbFtpCarInformation().getTfcCarCode());
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "停车完成!", true);
                    }
                    Thread.sleep(1000);
                    a++;
                }

                getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "丝该老特");
                getSyncServiceImpl().createParkinglog(this.getTstbFtpCarInformation().getTfcCarCode(), resultMap, 0);
                TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                heartBeatPLC("1", "3");
                serviceMap.get("ftpcarService").delete(carInformationCriteria);
                //处理配载

                return true;
            } else {
                if (result == 2) {//没有可用车位可以停车
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备已经没有可用停车位置,本次停车失败!");
                } else {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备故障,本次停车失败!");
                }
                return false;
            }
        } catch (Exception e) {
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
            serviceMap.get("ftpcarService").delete(carInformationCriteria);
            getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "丝该老特");
            //更新IMA状态
            updateStatus("3", "9", "1", this.getTstbFtpCarInformation().getTfcCarCode(), this.getTstbFtpCarInformation().getTfcCarInCode(), "3", null);
            if (StringUtils.contains(e.getMessage(), EX_PARKING_MATHINE_EXCEPTION)) {//急停处理
                //删除待处理的任务
            }
            if (StringUtils.contains(e.getMessage(), EX_PARKING_MATHINE_NOT_AVIABLE)) {//停车位置已满
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备已经没有可用停车位置,本次停车失败!");
                getMarqueeUtil().sendText("Skylot", "PLC设备已经没有可用停车位置,本次停车失败!", true, "PLC设备已经没有可用停车位置,本次停车失败!");
                Thread.sleep(2000);
                getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "丝该老特");

            }
            return false;
        }
    }

    /**
     * 处理取车逻辑
     *
     * @return true, false
     */
    private boolean doExtractLogic() throws Exception {
        Map extractMap = Maps.newHashMap();
        Map valueMap = Maps.newHashMap();
        Map resultMap = Maps.newHashMap();
        int result = getSyncServiceImpl().checkPLC(2);
        if (result == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备可用,准备取车!");
            getMarqueeUtil().sendText("取车中", "当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备可用,准备取车!", true);
            //首先,旋转到位
            int s = 1;
            int a = 0;
            TstbMathineParkingCriteria criteria = new TstbMathineParkingCriteria();
            criteria.createCriteria().andTmpCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
            TstbMathineParking tstbMathineParking = ((ParkingService) serviceMap.get("parkingService")).query(criteria);
            if (tstbMathineParking != null) {
                while (s == 1) {//旋转
                    code.setTargetLot(tstbMathineParking.getTmpPhysicalCode());
                    heartBeatPLC("2", "1");
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],旋转车台是[" + tstbMathineParking.getTmpPhysicalCode() + "]");
                    getMarqueeUtil().sendText("取车中", "设备旋转中,待旋转车台是[" + tstbMathineParking.getTmpPhysicalCode() + "]", true);
                    extractMap = getSocketService().doPulling(tstbMathineParking.getTmpPhysicalCode(), true);
                    s = MapUtils.getIntValue(extractMap, MAP_PARKING_STATUS);
                    resultMap = extractMap;
                    if (s == 0) {
                        break;
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                }
                if (checkCanceled()) {
                    if (cancelAction(FN_RETURN_STATUS_ERROR)) {
                        return false;
                    } else {
                        cancelError();
                    }
                }
                confirmCar();
                setPeopleDoor(false);
                //判断,人行门开关一次
                while (!isPeopleDoor()) {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],读取人行门开关数据");
                    if (a == 0) {
                        getMarqueeUtil().sendText("取车中", "等待行人门打开!", true);
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    heartBeatPLC("2", "2");
                    peopleDoorhadOpen();
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_ERROR)) {
                            return false;
                        } else {
                            cancelError();
                        }
                    }
                    a++;
                    Thread.sleep(1000);
                }
                if (isPeopleDoor()) {
                    heartBeatPLC("2", "2");
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],准备打开车门");
                    getMarqueeUtil().sendText("取车中", "准备打开车门!", true);
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_ERROR)) {
                            return false;
                        } else {
                            cancelError();
                        }
                    }
                    getSocketService().carDoor(FN_RETURN_STATUS_SUCCESS);//车库门开门指令发送成功
                }
                //判断,车库门打开
                while (!isCarDoor()) {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],获取车库门打开状态");
                    heartBeatPLC("2", "2");
                    carDoorhadOpen();
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_ERROR)) {
                            return false;
                        } else {
                            cancelError();
                        }
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    Thread.sleep(1000);
                }
                setCarDoor(false);
                s = 1;
                a = 0;
                //判断1007的状态


                while (s == 1) {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],读取1007数据");
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_ERROR)) {
                            return false;
                        } else {
                            cancelError();
                        }
                    }
                    if (a == 0) {
                        getMarqueeUtil().sendText("取车中", "系统正在进行安全检查", true);
                    }
                    if (extractError()) {
                        s = 0;
                    }
                    highErrorExist();
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    heartBeatPLC("2", "2");
                    a++;
                    Thread.sleep(1000);
                }
                //判断,车库门关闭
                a = 0;
                while (!isCarDoor()) {
                    if (a == 0) {
                        getMarqueeUtil().sendText("取车中", "等待车库门关闭", true);
                    }
                    getSocketService().carDoor(FN_RETURN_STATUS_ERROR);//车库门关门指令发送成功
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],获取车库门关闭状态");
                    if (!extractError()) {
                        heartBeatPLC("2", "3");
                    }
                    carDoorhadClose();
                    Thread.sleep(1000);
                    a++;
                }
                getMarqueeUtil().sendText("取车中", "取车完成!", true);
                getSyncServiceImpl().createParkinglog(this.getTstbFtpCarInformation().getTfcCarCode(), resultMap, 1);
                TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                serviceMap.get("ftpcarService").delete(carInformationCriteria);
                heartBeatPLC("1", "3");
                getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "思该唠特");
                return true;
            } else {
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备上没有要取车的车辆!");
                return false;
            }


        } else {
            if (result == 2) {//没有可用车位可以停车
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备已经没有可用停车位置,本次取车失败!");
            } else {
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备故障,本次取车失败!");
            }
            return false;
        }
    }

    /**
     * 处理预约取车逻辑,间或处理荷载的操作
     *
     * @return true, false
     */
    private boolean doBookExtractLogic(ParkingLogic... parkingLogics) throws Exception {
        TstbMathineParking tstbMathineParking = TstbMathineParking.builder().build();
        int result = getSyncServiceImpl().checkPLC(2);
        try {
            if (result == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
                if (parkingLogics.length == 0) {//预约取车
                    getMarqueeUtil().sendText("预约取车", this.getTstbFtpCarInformation().getTfcCarCode() + "正在进行预约取车", false);
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备可用,准备取车!");
                } else {//荷载
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[荷载],PLC设备可用,准备旋转!");
                }
                //首先,旋转到位
                int s = 1;
                TstbMathineParkingCriteria criteria = new TstbMathineParkingCriteria();
                criteria.createCriteria().andTmpCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                tstbMathineParking = ((ParkingService) serviceMap.get("parkingService")).query(criteria);
                if (tstbMathineParking != null) {
                    code.setTargetLot(tstbMathineParking.getTmpPhysicalCode());
                    while (s == 1) {//旋转
                        heartBeatPLC("4", "1");
                        getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],旋转车台是[" + tstbMathineParking.getTmpPhysicalCode() + "]");
                        s = getSocketService().doDirection(NumberUtils.toInt(tstbMathineParking.getTmpPhysicalCode()), new ParkingLogic());
                        if (s == 0) {
                            break;
                        }
                    }
                    int a = 1;
                    while (a != 0) {
                        a = getSyncServiceImpl().checkPLC(2, true);
                        getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],旋转中");
                        if (a == -1) {
                            throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                        }
                        Thread.sleep(1000);
                    }
                    heartBeatPLC("4", "3");
                    TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                    carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                    serviceMap.get("ftpcarService").delete(carInformationCriteria);
                    heartBeatPLC("1", "3");

                    return true;
                } else {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备上没有要取车的车辆!");
                    return false;
                }
            } else {
                if (result == 2) {//没有可用车位可以停车
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备已经没有可用停车位置,本次取车失败!");
                } else {
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备故障,本次取车失败!");
                }
                return false;
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        } finally {
            OftbReserveTakingCriteria oftbReserveTakingCriteria = new OftbReserveTakingCriteria();
            oftbReserveTakingCriteria.createCriteria().andOrtPhysicalCodeEqualTo(tstbMathineParking.getTmpPhysicalCode());
            serviceMap.get("reserveTakingService").delete(oftbReserveTakingCriteria);
            getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "思该唠特");
        }
    }
}
