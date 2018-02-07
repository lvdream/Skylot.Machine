package com.fangda.skylot.mathine.service.impl;

import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingDAO;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadMgt;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadUtil;
import com.fangda.skylot.mathine.service.SocketService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.math.ParkingLogic;
import com.fangda.skylot.mathine.utils.socket.BaseCommander;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static com.fangda.skylot.mathine.utils.SkylotUtils.opeartionTimeout;
import static com.fangda.skylot.mathine.utils.constant.Constant.*;

/**
 * Created by Saul on 08/06/2017.
 */
@SuppressWarnings("ALL")
@Repository
@Data
@Slf4j
public class SocketServiceImpl extends BaseCommandUtils implements SocketService {
    @Autowired
    private MainThreadMgt mainThreadMgt;
    @Autowired
    private ErrorCode code;
    @Autowired
    private MainThreadUtil mainThreadUtil;
    @Autowired
    private SyncService syncService;
    @Autowired
    private Map<String, IBaseDao> daoMap;
    private Socket client = null;
    private String ip = "";
    private String tempCSVbasenum = "";//临时测试用,保存最下方车位编号用
    private int port = 0;
    private OutputStream out_data = null;
    private PrintStream printStream = null;
    private InputStream inputStream;
    private String baseNum;

    private boolean displayDetail = Boolean.parseBoolean(GetProperties.getProperties("system.properties", "console.detail.status.layout"));

    /**
     * 停车
     * 空闲,
     * 发送停车指令>>停车中,运行中,运行完成,空闲
     * 5     13     14     10
     * 发送车牌写指令>>空闲,完成
     * 发送荷载指令>>空闲,运行中,运行完成
     * <p>
     * 取车
     * 空闲,
     * 发送取车指令>>取车中,运行中,运行完成,取车完成,空闲
     * 发送荷载指令>>空闲,运行中,运行完成
     */
    private int statusCheck;//状态信息判定
    private long timeCounter;//实际停取车总耗时
    private long finishParkingTime;//实际停取车完成耗时
    private long directionAfterTime;//实际停取车后,荷载旋转耗时
    private long parkdirectionAfterTime;//实际停车之前,旋转耗时
    private long directionBeforeTime;//实际停取车前,旋转耗时
    private long parkdirectionBeforeTime;//实际停车之前,旋转耗时
    private float directionEnergy;//旋转耗电量变量
    private byte[] buffer = null;
    @Autowired
    private BaseCommander baseCommander;
    private Logger loggerParking = Logger.getLogger("Parking");


    /**
     * 取消存取车,操作
     *
     * @param actionType 0,存车;1:取车
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public int cancelAction(String actionType) throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820C8300000100");
            if (StringUtils.equals(actionType, "0")) {
                stringBuilder.append("01");
            } else {
                stringBuilder.append("02");
            }
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_CANCEL_ACTION, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return returnint;
    }


    /**
     * 车库门,操作
     *
     * @param actionType 0,开门,1,关门
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public int carDoor(String actionType) throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820C8100000100");
            if (StringUtils.equals(actionType, "0")) {
                stringBuilder.append("01");
            } else {
                stringBuilder.append("02");
            }
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_CAR_DOOR, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return returnint;
    }

    /**
     * 获取告警信息之和1005位置
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public Map getIndexError() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("000001018203ED000002");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_ALL_INDEX_STATUS, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        Map map = Maps.newHashMap();
        map.put("valueMap", this.valueMap);
        map.put("valueAppendMap", this.valueMapAppend);
        return map;
    }

    /**
     * 获取告警信息之和1007位置
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public Map pullIndexError() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("000001018203EF000002");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_ALL_INDEX_STATUS, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        Map map = Maps.newHashMap();
        map.put("valueMap", this.valueMap);
        map.put("valueAppendMap", this.valueMapAppend);
        return map;
    }

    /**
     * 行人门,操作
     *
     * @param actionType 0,开门,1,关门
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public int peopleDoor(String actionType) throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820C8200000100");
            if (StringUtils.equals(actionType, "0")) {
                stringBuilder.append("01");
            } else {
                stringBuilder.append("02");
            }
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PEOPLE_DOOR, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return returnint;
    }

    /**
     * 工作模式改变
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int chageWorkType() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820C800000010001");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_MODEL_CHANGE, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return returnint;
    }

    /**
     * 获取故障代码--一般
     */
    public Map getNormalErrorStatus() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //一般
            stringBuilder.append("000001018203EC000001");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_ERROR_NORMAL_STATUS, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {

            log.error(e.getMessage());
        }
        Map map = Maps.newHashMap();
        map.put("valueMap", this.valueMap);
        return map;
    }

    /**
     * 长命令测试
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int longCommandR() throws SkyLotException {
        int returnint = -1;
        try {

            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("000001018200000000FA");
            returnint = CommandExectue("46494E530000001A000000020000000080000200010000", stringBuilder2.toString());
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 长命令测试
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int longCommandW() throws SkyLotException {
        int returnint = -1;
        try {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820FA00000");
            stringBuilder.append("FE");
            int a = Integer.parseInt("FE", 16);
            for (int i = 0; i < a; i++) {
                stringBuilder.append("0001");
            }
            returnint = CommandExectue("46494E5300000216000000020000000080000200010000", stringBuilder.toString());
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 获取故障代码--严重
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int getHighErrorStatus() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //整体故障
            stringBuilder.append("000001018203EA000002");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_ERROR_STATUS, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 写车牌
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public int writeCarcode(String carCode) throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820BBB00000A");
            stringBuilder.append(StringUtils.rightPad(encode(carCode), 40, "0"));
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_CAR_CODE, stringBuilder.toString(), null);
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 获取整体状态
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    private int getStatusPrivate() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //整体状态
            stringBuilder.append("000001018203E8000002");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_STATUS, stringBuilder.toString());
            convertArraytoCalc(stringBuilderto.toString());
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;

    }

    /**
     * 获取电量消耗
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public int getEnergy() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000101820442000002");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PARKING_STATUS, stringBuilder.toString());
            setDirectionEnergy(convert16bit(stringBuilderto.toString()));
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 进行旋转,考虑荷载问题
     *
     * @param Number       待旋转位置
     * @param parkingLogic 停车逻辑对象
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int doDirection(int number, ParkingLogic parkingLogic) {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //旋转
            getBaseNumber();//获取最下方停车板编号
            getParkingStatus(1);//获取停车状态
            parkingLogic.setBaseNum(getBaseNum());
            parkingLogic.setMachineTotalItmes(MACHINEPARKING_QUANTITY);
            parkingLogic.setParkingStatusMap(this.getValueMap());
            parkingLogic.getStoreNum(1);
            stringBuilder.append("00000102820C1C000003");
            stringBuilder.append("0001");
            stringBuilder.append(StringUtils.leftPad(Integer.toHexString(number), 4, "0"));
            stringBuilder.append(StringUtils.leftPad(parkingLogic.getActionDirect() + "", 4, "0"));
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_DIRECTION, stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnint;
    }

    /**
     * 获取最下方车板编号
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int getBaseNumber() throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //查询最下方车板
            stringBuilder.append("000001018203F1000001");
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_BASE_NUMBER, stringBuilder.toString());
            tempCSVbasenum = "获取最下方车位编号是" + Integer.parseInt(StringUtils.split(stringBuilderto.toString(), " ")[31], 16) + "" + "获取最下方车位编号是(原始):" + stringBuilderto.toString();
            setBaseNum(Integer.parseInt(StringUtils.split(stringBuilderto.toString(), " ")[31], 16) + "");
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return returnint;
    }

    /**
     * 获取停车状态列表
     *
     * @param Type 0:获取数据来自停车数据库,1:获取数据来自PLC
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    public Map getParkingStatus(int Type) throws SkyLotException {
        Map dataMap = Maps.newHashMap();
        int returnint = -1;
        try {
            if (Type == 1) {
                StringBuilder stringBuilder = new StringBuilder();
                //查询车位停车状态
                stringBuilder.append("000001018203F2000001");
                returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PARKING_STATUS, stringBuilder.toString());
                convertArraytoCalc(stringBuilderto.toString());
                dataMap = valueMap;
            } else if (Type == 0) {
                List dataList = ((TstbMathineParkingDAO) this.daoMap.get("tstbMathineParkingDao")).ReadAll(new TstbMathineParkingCriteria());
                for (int i = 0; i < dataList.size(); i++) {
                    TstbMathineParking o = (TstbMathineParking) dataList.get(i);
                    dataMap.put(NumberUtils.toInt(o.getTmpPhysicalCode()), "1");
                }
                valueMap = (HashMap) dataMap;
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }

        return dataMap;
    }

    /**
     * 停车主方法, 开车库门,内置摄像头拍摄,写车牌
     *
     * @param Number       实体车板编号
     * @param carCode      车牌信息
     * @param parkingLogic 停车算法对象
     * @return 0, 存成成功,-1存车失败,-2,操作超时
     */
    public int ParkingCar(int Number, String carCode, ParkingLogic parkingLogic) throws SkyLotException {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820BB8000003");
            stringBuilder.append("0001");
            stringBuilder.append(StringUtils.leftPad(Integer.toHexString(Number), 4, "0"));
            stringBuilder.append(StringUtils.leftPad(parkingLogic.getActionDirect() + "", 4, "0"));//正反转参数
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PARKING, stringBuilder.toString(), null);//旋转车台
            if (returnint == 0) {//存车
                int status = confirmStatus(0);
                if (status == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//设备旋转完成
                    log.warn("设备旋转完成");
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],设备旋转完成");
//                    getEnergy();//获取旋转电量
                    //旋转车台结束,进行计时
                    if (getDirectionBeforeTime() == 0) {
                        setDirectionBeforeTime(0);
                    } else {
                        setDirectionBeforeTime(System.currentTimeMillis() - getDirectionBeforeTime());//旋转计时结束
                    }
                    //打开车库门
                    if (carDoor(FN_RETURN_STATUS_SUCCESS) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//车库门开门指令发送成功
                        log.warn("车库门打开指令已发,等待车库门打开");
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],车库门打开指令已发,等待车库门打开");
                        //等待车库门已开
                        status = confirmStatus(3);
                        if (status == 0) {//车库门已经打开
                            log.warn("车库门打开完成");
                            loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],车库门打开完成!");
                            return returnint;
                        } else {
                            if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                                return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                            }
                        }
                    } else {
                        return returnint;
                    }
                } else {
                    if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                        return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                    }
                }
            } else {
                return returnint;
            }
        } catch (Exception e) {
            return -1;

        }
        return returnint;
    }

    /**
     * 停车确认,验证PLC状态,关闭车库门
     *
     * @param Number
     * @param carCode
     * @param parkingLogic
     * @return -1.故障信息,0,可以继续停车
     */
    public int ParkingCarConfirm(String carCode) {
        int returnint = -1;
        try {
            getHighErrorStatus();//查询是否有故障码
            if (MapUtils.isNotEmpty(valueMapAppend) || MapUtils.isNotEmpty(valueMap)) {//有故障码
                return returnint;
            }
            int status = confirmStatus(3);
            if (status == 0) {//车库门打开状态
                //获取当前设备是否有主要故障信息
                if (carDoor(FN_RETURN_STATUS_ERROR) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//车库门关门指令发送成功
                    //等待车库门已关
                    status = confirmStatus(3);
                    if (status == 0) {//车库门已经关闭
                        //写车牌
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("00000102820BBB00000A");
                        stringBuilder.append(StringUtils.rightPad(encode(carCode), 40, "0"));
                        returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_CAR_CODE, stringBuilder.toString(), null);
                        status = confirmStatus(2);
                        if (status == 0) {//PLC是否空闲
                            return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                        } else {
                            if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                                return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                            }
                            return returnint;
                        }
                    } else {
                        if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                            return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                        }
                    }
                } else {
                    return returnint;
                }
            } else {
                if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                    return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                }
                return returnint;
            }
        } catch (Exception e) {
            return -1;

        }
        return returnint;
    }

    /**
     * 取车主方法
     *
     * @param Number       实体车板编号
     * @param parkingLogic 停车逻辑对象
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int PullCar(int Number, ParkingLogic parkingLogic) {
        int returnint = -1;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("00000102820BB8000003");
            stringBuilder.append("0002");
            stringBuilder.append(StringUtils.leftPad(Integer.toHexString(Number), 4, "0").toUpperCase());
            stringBuilder.append(StringUtils.leftPad(parkingLogic.getActionDirect() + "", 4, "0"));
            returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PARKING, stringBuilder.toString());//取车
            if (returnint == 0) {//取车
                if (confirmStatus(1) == 0) {//取车操作完成
                    getEnergy();//获取用电量
                    if (getDirectionBeforeTime() == 0) {
                        setDirectionBeforeTime(0);
                    } else {
                        setDirectionBeforeTime(System.currentTimeMillis() - getDirectionBeforeTime());//旋转计时结束
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("0000010182");
                    stringBuilder.append(StringUtils.leftPad(Integer.toHexString(Number * 10 + 1190), 4, "0").toUpperCase());
                    stringBuilder.append("00000A");
                    returnint = CommandExectue(PLC_COMMUNACAITON_HEAD_PULLING, stringBuilder.toString());//取车牌
                    StringBuilder stringBuilder1 = new StringBuilder();
                    for (int i = 0; i < StringUtils.split(getStringBuilderto().toString(), " ").length; i++) {
                        if (i > 29 && !StringUtils.equals("0", StringUtils.split(getStringBuilderto().toString(), " ")[i])) {
                            stringBuilder1.append(StringUtils.split(getStringBuilderto().toString(), " ")[i]);
                        }
                    }
                }
            }

        } catch (Exception e) {
            return returnint;
        }
        return returnint;
    }

    /**
     * 取车从方法,开人行门和车库门,之后等待PLC各个位置的状态是否正常
     *
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     */
    public int PullCarComfirm() {
        int returnint = -1;
        try {
            getHighErrorStatus();//查询是否有故障码
            if (MapUtils.isNotEmpty(valueMapAppend) || MapUtils.isNotEmpty(valueMap)) {//有故障码
                return returnint;
            }
            //打开车库门
            if (carDoor(FN_RETURN_STATUS_SUCCESS) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//车库门开门指令发送成功
                //等待车库门已开
                if (confirmStatus(4) == 0) {//车库门已经开
                    getHighErrorStatus();//查询是否有故障码
                    if (MapUtils.isEmpty(valueMapAppend) && MapUtils.isEmpty(valueMap)) {//没故障码
                        //尝试关闭车库门
                        //关闭车库门
                        if (carDoor(FN_RETURN_STATUS_ERROR) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//车库门关门指令发送成功
                            //等待车库门已关
                            if (confirmStatus(4) == 0) {//车库门已经关闭
                                return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                            } else {
                                return returnint;
                            }
                        } else {
                            return returnint;
                        }
                    }
                } else {
                    return returnint;
                }
            } else {
                return returnint;
            }

        } catch (Exception e) {
            return returnint;
        }
        return returnint;
    }


    private int getStatus(int bType) throws SkyLotException {
        getStatusPrivate();
        if (displayDetail) {
            log.warn(valueMap.toString());
        }
        if (MapUtils.isNotEmpty(this.valueMap)) {
            if (!valueMap.keySet().contains(2) || valueMap.keySet().contains(11)) {//手动模式或者严重故障
                return NumberUtils.toInt(FN_RETURN_STATUS_EXCEPTION);
            }
            if (valueMap.keySet().contains(12)) {//一般故障
                return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
            }
            for (Object o : valueMap.keySet()) {
                int pNum = (Integer) o;
                //增加急停,严重错误判断
                if (pNum == 11) {
                    return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                }
                if (bType == 9) {
                    return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                }
                if (bType == 0) {//存车
                    if (pNum == 14) {//运行完成状态
//                        if (this.getStatusCheck() == 0) {//验证运行中状态存在
//                            setDirectionBeforeTime(System.currentTimeMillis() - getFinishParkingTime());//停车前,旋转计时结束
//                            // TODO: 14/08/2017 需要增加存车完成之后,最下方车位不是所需车位,告知PLC告警
//                            this.setStatusCheck(1);//继续侦测运行空闲状态
//                            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
//                        } else if (this.getStatusCheck() == -1) {//当前最下方已经是待旋转车位
//                            setDirectionBeforeTime(0);//设置旋转计时为0
//                            // TODO: 14/08/2017 需要增加存车完成之后,最下方车位不是所需车位,告知PLC告警
//                            this.setStatusCheck(1);//继续侦测空闲状态
//                            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
//                        } else if (this.getStatusCheck() == 1) {//验证运行完成状态存在
//                            this.setStatusCheck(-1);//完成停车操作
//                            try {
//                                Thread.sleep(1000);//停车完成时,等待空闲,附加延迟1秒
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    } else if (pNum == 10) {//停车完成状态
                        if (this.getStatusCheck() == 1) {//验证运行完成状态存在
                            this.setStatusCheck(-1);//完成停车操作
                            try {
                                Thread.sleep(1000);//停车完成时,等待空闲,附加延迟1秒
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                        }
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                } else if (bType == 1) {//取车
                    if (pNum == 13) {//运行中状态
                        setDirectionBeforeTime(System.currentTimeMillis());//取车前,旋转计时开始
                        this.setStatusCheck(0);//运行中状态
                        return 1;
                    } else if (pNum == 14) {//运行完成状态
//                        if (this.getStatusCheck() == 0) {//验证运行中状态存在
//                            setDirectionBeforeTime(System.currentTimeMillis() - getFinishParkingTime());//停车前,旋转计时结束
//                            // TODO: 14/08/2017 需要增加取车完成之后,最下方车位不是所需车位,告知PLC告警
//                            this.setStatusCheck(1);//继续侦测运行完成状态
//                            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
//                        } else if (this.getStatusCheck() == -1) {//当前最下方已经是待旋转车位
//                            setDirectionBeforeTime(0);//设置旋转计时为0
//                            // TODO: 14/08/2017 需要增加存车完成之后,最下方车位不是所需车位,告知PLC告警
//                            this.setStatusCheck(1);//继续侦测空闲状态
//                            try {
//                                Thread.sleep(1000);//停车完成时,等待空闲,附加延迟1秒
//                            } catch (InterruptedException e) {
//                                throw new SkyLotException(e);
//                            }
//                            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
//                        }
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    } else if (pNum == 10) {//停车完成状态
                        if (this.getStatusCheck() == 1) {//验证运行完成状态存在
                            this.setStatusCheck(-1);//完成停车操作
                            return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                        }
                    }
                } else if (bType == 2) {//查询PLC状态
                    if (pNum == 10) {//空闲
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                } else if (bType == 3) {//车库门打开状态
                    if (pNum == 7) {//车库门打开
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                } else if (bType == 4) {//车库门关闭
                    if (pNum == 8) {//车库门关闭
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                } else if (bType == 5) {//人行门开
                    if (pNum == 9) {//人行门开
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                }

            }
            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
        } else {
            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
        }
    }

    /**
     * 判断当前设备是否是可以停车状态
     *
     * @return 1:停车设备已经满,不能再次停车,0:可以停车
     * @throws SkyLotException
     */
    @Override
    public int enableParking() throws SkyLotException {
        getParkingStatus(1);
        if (MapUtils.isNotEmpty(this.valueMap)) {
            if (this.valueMap.keySet().size() == NumberUtils.toInt(MACHINEPARKING_QUANTITY)) {
                return 1;
            }
            return 0;
        } else {//当前设备空置,可以停车
            return 0;
        }
    }


    /**
     * @param carNumber 车牌
     * @return iStatus:0, 停车成功, 1, 停车失败;iParkingLocation:停车位置;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     * @throws SkyLotException
     */
    @Override
    public Map doParking(String carNumber, boolean firstPark) throws SkyLotException {
        Logger loggerParking = Logger.getLogger("Parking");
        Map returnMap = new HashMap();
        setTimeCounter(0);
        setDirectionBeforeTime(0);
        setDirectionAfterTime(0);
        setFinishParkingTime(0);
        try {

            ParkingLogic parkingLogic = new ParkingLogic();
            int parkingNumber = 0;
            if (firstPark) {
                //首先检查,PLC状态是否可以停车
                if (confirmStatus(2) > 0) {
                    returnMap.put(MAP_PARKING_STATUS, 1);
                    return returnMap;
                }
                //判断系统是否可以进行存取车
                getBaseNumber();//获取最下方停车板编号
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],当前最下方车位:[" + getBaseNum() + "]");
                log.warn("当前最下方车位:" + getBaseNum());
                getParkingStatus(0);//获取停车状态
                returnMap.put(MAP_PARKING_BASENUMBER, getBaseNum());
                returnMap.put("basenumber_save", tempCSVbasenum);
                parkingLogic.setBaseNum(getBaseNum());
                parkingLogic.setMachineTotalItmes(MACHINEPARKING_QUANTITY);
                returnMap.put(MAP_PARKING_CAR_PARKING_STATUS, SingletonObjectMapper.getInstance().writeValueAsString(this.getValueMap()));
                parkingLogic.setParkingStatusMap(this.getValueMap());
                parkingNumber = parkingLogic.getStoreNum(0);
                code.setTargetLot(parkingNumber + "");
                try {
                    mainThreadUtil.heartBeatPLC("3", "1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.warn("准备停车位置:" + parkingNumber);
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],准备停车位置:[" + parkingNumber + "]");
                log.warn(parkingLogic.getActionDirect() + "旋转方向:" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向"));
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],准备旋转方向:[" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向") + "]");
                setTimeCounter(System.currentTimeMillis());//停车耗时计时器
                returnMap.put(MAP_PARKING_LOCATION, parkingNumber);
                int status = ParkingCar(parkingNumber, carNumber, parkingLogic);
                if (status == 0) {
                    setParkdirectionAfterTime(System.currentTimeMillis() - getTimeCounter());//停车之前,旋转耗时
                    returnMap.put(MAP_PARKING_STATUS, 0);
                    returnMap.put(MAP_ENERGY, getDirectionEnergy());
                    setFinishParkingTime(System.currentTimeMillis() - getTimeCounter() - getDirectionBeforeTime());//实际完成停车耗时,等于当前时间减去旋转车台耗时,再减去开始计时的时间点
                    returnMap.put(MAP_PARKING_DIRECTION, parkingLogic.getFinalPostionNumer());
                    returnMap.put("parkingLogic", parkingLogic);
                } else {
                    if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                        returnMap.put(MAP_PARKING_STATUS, NumberUtils.toInt(FN_RETURN_STATUS_HANDLE));
                    }
                }
            } else {
                //停车确认
                int status = ParkingCarConfirm(carNumber);
                if (status == 0) {
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],存车操作完成!");
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],存车耗费电量:[" + getDirectionEnergy() + "]");
                    if (parkingLogic.getFinalPostionNumer() != parkingNumber && NumberUtils.toInt(parkingLogic.getFinalPostionNumer() + "", 0) != 0) {//判断是否需要再次旋转
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],准备荷载位置:[" + parkingLogic.getFinalPostionNumer() + "]");
                        log.warn("准备荷载位置:" + parkingLogic.getFinalPostionNumer());
                        parkingLogic.setActionDirect(parkingLogic.getActionDirectwithFinalPosition());//荷载旋转方向赋值
                        log.warn("准备荷载转向:" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向"));
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],准备荷载转向方向:[" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向") + "]");
                        doDirection(parkingLogic.getFinalPostionNumer(), parkingLogic);//需要再次旋转
                        setDirectionAfterTime(System.currentTimeMillis() - getTimeCounter() - getFinishParkingTime());//实际完成荷载耗时,等于当前时间减去实际停车耗时,再减去开始计时的时间点
                        returnMap.put(MAP_ENERGY_DIRECTION, getDirectionEnergy());
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],荷载耗费电量:[" + getDirectionEnergy() + "]");
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],荷载操作完成!");
                    } else {
                        setDirectionAfterTime(0);//没有荷载,停车之后的时间是0
                    }
                    returnMap.put(MAP_TIME_SPEND_ALL, (getDirectionBeforeTime() + getFinishParkingTime() + getDirectionAfterTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_DIRECTION, (getDirectionBeforeTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_DOING, (getFinishParkingTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_WEIGHT, (getDirectionAfterTime()) / 1000);
                } else {
                    if (NumberUtils.toInt(FN_RETURN_STATUS_HANDLE) == status) {//系统急停,严重错误
                        returnMap.put(MAP_PARKING_STATUS, NumberUtils.toInt(FN_RETURN_STATUS_HANDLE));
                    }
                }
            }

        } catch (SkyLotException e) {
            returnMap.put(MAP_PARKING_STATUS, -1);
        } catch (JsonProcessingException e) {
            throw new SkyLotException(e);
        }
        return returnMap;
    }

    /**
     * @param positionNumber 取车位置
     * @return iStatus:0, 取车成功, 1, 取车失败;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     * @throws SkyLotException
     */
    @Override
    public Map doPulling(String positionNumber, boolean firstPull) throws SkyLotException {
        Map returnMap = new HashMap();
        Logger loggerParking = Logger.getLogger("Parking");
        setTimeCounter(0);
        setDirectionBeforeTime(0);
        setDirectionAfterTime(0);
        setFinishParkingTime(0);
        try {
            ParkingLogic parkingLogic = new ParkingLogic();
            if (confirmStatus(2) > 0) {
                returnMap.put(MAP_PARKING_STATUS, -1);
            }
            setTimeCounter(System.currentTimeMillis());//取车耗时计时器
            if (firstPull) {
                getBaseNumber();
                List positionList = ListUtils.sum(parkingLogic.getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 0), parkingLogic.getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 2));//依次查找,下方和左侧;上方和左侧
                if (ArrayUtils.contains(positionList.toArray(), NumberUtils.toInt(positionNumber))) {
                    parkingLogic.setActionDirect(2);
                } else {
                    parkingLogic.setActionDirect(1);
                }
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前最下方车位:[" + getBaseNum() + "]");
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],准备取车位置:[" + positionNumber + "]");
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],旋转方向:[" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向") + "]");
                log.warn("当前最下方车位:" + getBaseNum());
                log.warn("准备取车位置:" + positionNumber);
                log.warn("旋转方向:" + (parkingLogic.getActionDirect() == 2 ? "反向" : "正向"));
                returnMap.put(MACHINEACTION_DIRECTION_CODE_CLOCKWISE, (parkingLogic.getActionDirect() == 2 ? MACHINEACTION_DIRECTION_CODE_ANTICLOCKWISE : MACHINEACTION_DIRECTION_CODE_CLOCKWISE));
                if (PullCar(NumberUtils.toInt(positionNumber), parkingLogic) == 0) {
                    returnMap.put(MAP_PARKING_STATUS, 0);
                    getBaseNumber();//获取最下方停车板编号
                    getParkingStatus(1);//获取停车状态
                    returnMap.put(MAP_PARKING_BASENUMBER, getBaseNum());
                    returnMap.put(MAP_PARKING_LOCATION, positionNumber);
                }
            } else {
                if (PullCarComfirm() == 0) {
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],取车操作完成!");
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],取车耗费电量:[" + getDirectionEnergy() + "]");
                    returnMap.put(MAP_ENERGY, getDirectionEnergy());
                    setFinishParkingTime(System.currentTimeMillis() - getTimeCounter() - getDirectionBeforeTime());//实际完成停车耗时,等于当前时间减去旋转车台耗时,再减去开始计时的时间点
                    returnMap.put(MAP_PARKING_STATUS, 0);
                    getBaseNumber();//获取最下方停车板编号
                    getParkingStatus(1);//获取停车状态
                    returnMap.put(MAP_PARKING_BASENUMBER, getBaseNum());
                    returnMap.put(MAP_PARKING_LOCATION, positionNumber);
                    parkingLogic.setBaseNum(getBaseNum());
                    parkingLogic.setMachineTotalItmes(MACHINEPARKING_QUANTITY);
                    returnMap.put(MAP_PARKING_CAR_PARKING_STATUS, SingletonObjectMapper.getInstance().writeValueAsString(this.getValueMap()));
                    parkingLogic.setParkingStatusMap(this.getValueMap());
                    parkingLogic.getStoreNum(1);
                    returnMap.put(MAP_TIME_SPEND_ALL, (getDirectionBeforeTime() + getFinishParkingTime() + getDirectionAfterTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_DIRECTION, (getDirectionBeforeTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_DOING, (getFinishParkingTime()) / 1000);
                    returnMap.put(MAP_TIME_SPEND_WEIGHT, (getDirectionAfterTime()) / 1000);
                }

            }

        } catch (Exception e) {
            returnMap.put(MAP_PARKING_STATUS, -1);
            throw new SkyLotException(e);
        }
        return returnMap;
    }


    /**
     * 确认是否可以
     *
     * @param type 状态查询:2,查询停车:0,查询取车:1,车库门打开:3,车库门关闭:4,人行门打开:5,获取整体状态:6,心跳查询:9
     * @return
     * @throws SkyLotException
     */
    public int confirmStatus(int type, boolean... followLoop) throws SkyLotException {
        int a = 1;
        int looptimes = 0;
        setStatusCheck(-1);
        //check status
        try {
            while (a != 0) {//验证状态过程
                if (type != 6) {
                    a = getStatus(type);
                }
                if (a == NumberUtils.toInt(FN_RETURN_STATUS_HANDLE)) {//严重错误,急停
                    return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);
                }
                if (a == NumberUtils.toInt(FN_RETURN_STATUS_EXCEPTION)) {//手动模式
                    return NumberUtils.toInt(FN_RETURN_STATUS_EXCEPTION);
                }
                if (a == NumberUtils.toInt(FN_RETURN_STATUS_ERROR)) {//一般故障
                    return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new SkyLotException(e);
                }
                if (followLoop != null && followLoop.length > 0) {
                    break;
                }
                looptimes++;
            }
            if (looptimes > NumberUtils.toInt(opeartionTimeout)) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return a;
    }

    /**
     * 获取当前PLC设备的全部状态
     *
     * @return operationStatus:{0,空闲;1:运作中;2:异常故障},businessStatus:{0,停车中;1:取车中;2:荷载中}
     * @throws SkyLotException
     */
    @Override
    public Map getAllStatus(boolean... getDirection) throws SkyLotException {
        String operationStatus = "0";
        String businessStatus = "0";
        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
        try {
            if (getDirection.length == 0) {
                getStatusPrivate();
                //获取当前PLC运行状态
                if (null == MapUtils.getString(this.valueMap, 10)) {//空闲状态丢失
                    if (null != MapUtils.getString(this.valueMap, 11) || null != MapUtils.getString(this.valueMap, 12)) {
                        operationStatus = FN_RETURN_STATUS_HANDLE;
                    } else if (null != MapUtils.getString(this.valueMap, 13)) {
                        operationStatus = FN_RETURN_STATUS_ERROR;
                    }
                }
                iftbMachineAction.setImaStatus(operationStatus);
            } else {
                IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
                criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
                iftbMachineAction = (IftbMachineAction) daoMap.get("iftbMachineActionDao").ReadSingle(criteria);
            }
        } catch (Exception e) {
        }
        Map resultMap = new HashMap();
        Map returnMap = Maps.newHashMap();
        if (iftbMachineAction == null) {
            iftbMachineAction = IftbMachineAction.builder().build();
        }
        iftbMachineAction.setImaAddress(GetProperties.getProperties("system.properties", "skylot.machine.address"));
        iftbMachineAction.setImaId(SkylotUtils.imaId);
        iftbMachineAction.setImaPort(GetProperties.getProperties("system.properties", "skylot.machine.port"));
        try {
            iftbMachineAction.setImaPhysicalStatus("0");
            //查询是否有上一次同步失败的数据
            boolean haserror = syncService.hasSyncError("1", true);
            if (haserror) {
                iftbMachineAction.setImaPhysicalStatus("1");
            }
            iftbMachineAction.setImaUpdatetime(SkylotUtils.getStrDate());
            returnMap = SkylotUtils.beanToMap(iftbMachineAction);
            returnMap.put("valueMap", this.valueMap);
            returnMap.put("valueAppendMap", this.valueMapAppend);
            resultMap.put("operationStatus", operationStatus);
            resultMap.put("businessStatus", businessStatus);
            SkylotUtils.removeNullValue(returnMap);
        } catch (Exception e) {
            throw new SkyLotException(e);
        }

        return returnMap;
    }

    /**
     * 定义执行命令管理器,可以超时退出,预定义超时时间
     *
     * @param HeadCommand    头命令
     * @param append_Command 附加命令
     * @param needClose      是否需要关闭连接
     * @param verifyCode     验证返回值,可选
     * @return 成功失败, 0成功,-1失败,-2操作超时
     */
    private int CommandExectue(final String HeadCommand, final String append_Command, final String... verifyCode) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Integer[] result = {-1};
        FutureTask<Integer> future =
                new FutureTask<Integer>(new Callable<Integer>() {//使用Callable接口作为构造参数
                    public Integer call() throws IOException {
                        baseCommander.buildFirstConnection();//握手
                        result[0] = baseCommander.baseCommand(HeadCommand, append_Command, verifyCode);//执行操作命令
                        setStringBuilder(baseCommander.getStringBuilder());
                        setStringBuilderto(baseCommander.getStringBuilderto());
                        return result[0];
                    }
                });
        executor.execute(future);
        try {
            result[0] = future.get(NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.plc.operation.timeout")), TimeUnit.SECONDS); //取得结果，同时设置超时执行时间为系统预定义时间。
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            future.cancel(true);
        } catch (TimeoutException e) {
            log.warn("超时了!!!" + HeadCommand);
            // TODO: 08/08/2017 发生命令超时控制,日后要增加上一次指令的修正 
            baseCommander.closeConnection();
            future.cancel(true);
            return -2;
        } finally {
            executor.shutdown();
            return result[0];
        }
    }


}
