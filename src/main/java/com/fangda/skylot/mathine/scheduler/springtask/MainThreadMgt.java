package com.fangda.skylot.mathine.scheduler.springtask;

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
import com.google.common.collect.Maps;
import lombok.Data;
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
@Data
public class MainThreadMgt extends MainThreadUtil {
    /**
     * 严重故障标示位
     */
    private boolean highError = false;
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
                wsThreadMgt.putCommander(Maps.newHashMap());
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
//                        doExtractLogic();
                    }

                }
            }
        } catch (Exception e) {
            if (StringUtils.contains(e.getMessage(), EX_PARKING_MATHINE_EXCEPTION)) {

            } else if (StringUtils.contains(e.getMessage(), EX_PARKING_USER_AUTH_OUT_SERVICE)) {
                getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],设备同步异常,不能完成停车操作!");
                getMarqueeUtil().sendText("SkyLot", "设备故障无法进行同步", true);
            }

            throw new SkyLotException(e);
        } finally {
            wsThreadMgt.getCommands();
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
        int result = this.getSyncServiceImpl().checkPLC(3);
        try {
            if (result == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
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
                    } else {

                    }
                }
                //其次,判断内部摄像头是否已经识别到车辆车牌,30秒延迟判断
                int a = 0;
                while (StringUtils.isEmpty(this.getTstbFtpCarInformation().getTfcCarInCode())) {
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "请正确驶入停车位,内部摄像头正在识别您的车牌!", true);
                    }
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    if (checkCanceled()) {
                        if (cancelAction(FN_RETURN_STATUS_SUCCESS)) {
                            return false;
                        }
                    }
                    Thread.sleep(1000);
                    heartBeatPLC("3", "2");
                    hasTasktodo();
                    //获取到1005状态信息,都是正常也是可以跳出循环
                    if (parkingError()) {
                        break;
                    }
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
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],读取1005数据");
                    heartBeatPLC("3", "2");
                    if (parkingError()) {
                        s = 0;
                    }
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
                    if (isHighError()) {
                        throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
                    }
                    hasTasktodo();
                    if (parkingError()) {
                        heartBeatPLC("3", "3");
                    } else {
                        if (!this.getErrorList().isEmpty()) {
                            heartBeatPLC("3", "3");
                        } else {
                            heartBeatPLC("3", "2");
                        }

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
                    heartBeatPLC("3", "2");
                    carDoorhadClose();
                    getSocketService().writeCarcode(this.getTstbFtpCarInformation().getTfcCarCode());
                    if (a == 0) {
                        getMarqueeUtil().sendText("存车中", "停车完成!", true);
                    }
                    Thread.sleep(1000);
                    a++;
                }
                getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "丝杆老特");
                getSyncServiceImpl().createParkinglog(this.getTstbFtpCarInformation().getTfcCarCode(), resultMap, 0);
                TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                heartBeatPLC("1", "3");
                serviceMap.get("ftpcarService").delete(carInformationCriteria);
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
            if (StringUtils.contains(e.getMessage(), EX_PARKING_MATHINE_EXCEPTION)) {//急停处理
                //删除待处理的任务
                TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
                serviceMap.get("ftpcarService").delete(carInformationCriteria);
                getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "丝杆老特");
                //更新IMA状态
                updateStatus("3", "9", "1", this.getTstbFtpCarInformation().getTfcCarCode(), this.getTstbFtpCarInformation().getTfcCarInCode(), "3", null);
                throw new SkyLotException(EX_PARKING_MATHINE_EXCEPTION);
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
        int result = getSyncServiceImpl().checkPLC(3);
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
                        heartBeatPLC("2", "2");
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
     * 处理预约取车逻辑
     *
     * @return true, false
     */
    private boolean doBookExtractLogic() throws Exception {
        Map extractMap = Maps.newHashMap();
        Map valueMap = Maps.newHashMap();
        Map resultMap = Maps.newHashMap();
        int result = getSyncServiceImpl().checkPLC(3);
        if (result == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],当前车辆是[" + this.getTstbFtpCarInformation().getTfcCarCode() + "],PLC设备可用,准备取车!");
            //首先,旋转到位
            int s = 1;
            TstbMathineParkingCriteria criteria = new TstbMathineParkingCriteria();
            criteria.createCriteria().andTmpCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
            TstbMathineParking tstbMathineParking = ((ParkingService) serviceMap.get("parkingService")).query(criteria);
            if (tstbMathineParking != null) {
                while (s == 1) {//旋转
                    heartBeatPLC("3", "1");
                    getLoggerParking().warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[预约取车],旋转车台是[" + tstbMathineParking.getTmpPhysicalCode() + "]");
                    s = getSocketService().doDirection(NumberUtils.toInt(tstbMathineParking.getTmpPhysicalCode()), new ParkingLogic());
                    if (s == 0) {
                        break;
                    }
                }
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
    }
}
