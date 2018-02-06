package com.fangda.skylot.mathine.scheduler.springtask;

import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.model.customer.OftbSyncLog;
import com.fangda.skylot.mathine.model.customer.OftbSyncLogCriteria;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.ErrorCodeObj;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.SocketService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.MarqueeUtil;
import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.socket.WSThreadMgt;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

@Component
@Data
public class MainThreadUtil {
    @Autowired
    public Map<String, IBaseService> serviceMap;
    @Autowired
    private Map<String, IBaseDao> daoMap;
    @Autowired
    private WSThreadMgt wsThreadMgt;
    private TstbFtpCarInformation tstbFtpCarInformation;
    @Autowired
    private SyncService syncServiceImpl;
    private Logger loggerParking = Logger.getLogger("Parking");
    private Map errorMap = Maps.newHashMap();
    private List errorList = Lists.newArrayList();
    private boolean peopleDoor = false;
    private boolean carDoor = false;
    private boolean highException = false;
    private boolean highError = false;
    @Autowired
    private SocketService socketService;
    @Autowired
    private ErrorCode code;
    @Autowired
    private MarqueeUtil marqueeUtil;

    /**
     * 将待停车对象,改完停车对象为停车确认状态
     *
     * @return 是, 否
     * @throws SkyLotException skylot exception
     */
    protected boolean confirmCar(TstbFtpCarInformation... carInformation) throws Exception {
        try {
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.createCriteria().andTfcIdEqualTo(this.getTstbFtpCarInformation().getTfcId());
            code.setErrorList(Lists.newArrayList());
            if (carInformation != null && carInformation.length > 0) {
                //增加判断车牌不一致的情况下,提交的车牌是不是可以授权的车牌
                if (!StringUtils.equals(this.getTstbFtpCarInformation().getTfcCarCode(), carInformation[0].getTfcCarInCode())) {
                    if (syncServiceImpl.checkCarFromDB(carInformation[0].getTfcCarInCode()) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//检查车辆是否授权
                        if (syncServiceImpl.getParkingPhysicalCode(carInformation[0].getTfcCarInCode()) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//检查车辆是否已经停车
                            this.getTstbFtpCarInformation().setTfcCarCode(carInformation[0].getTfcCarInCode());
                            this.getTstbFtpCarInformation().setTfcStatus(NumberUtils.toInt(SCHEDULEACTION_MODULEID_MACHINEITEM));//等待用户确认状态
                            serviceMap.get("ftpcarService").update(this.getTstbFtpCarInformation(), carInformationCriteria);
                        }
                    } else {
                        Map maps = Maps.newHashMap();
                        Map valueAppendMap = Maps.newHashMap();
                        maps.put(16, "1");
                        valueAppendMap.put("valueAppendMap", maps);
                        code.setErrorList(analyzingError(valueAppendMap, "p"));
                        updateStatus("3", "1", "2", carInformation[0].getTfcCarInCode(), this.getTstbFtpCarInformation().getTfcCarCode(), "0", code.getTargetLot());
                        this.getTstbFtpCarInformation().setTfcCarCode(carInformation[0].getTfcCarInCode());
                        this.getTstbFtpCarInformation().setTfcCarInCode(carInformation[0].getTfcCarInCode());
                        serviceMap.get("ftpcarService").update(this.getTstbFtpCarInformation(), carInformationCriteria);
                    }
                } else {//车牌一样
                    this.getTstbFtpCarInformation().setTfcCarCode(carInformation[0].getTfcCarInCode());
                    this.getTstbFtpCarInformation().setTfcStatus(NumberUtils.toInt(SCHEDULEACTION_MODULEID_MACHINEITEM));
                    serviceMap.get("ftpcarService").update(this.getTstbFtpCarInformation(), carInformationCriteria);
                }
            } else {
                this.getTstbFtpCarInformation().setTfcStatus(NumberUtils.toInt(SCHEDULEACTION_MODULEID_ITEMCUSTOMER));//等待用户确认状态
                serviceMap.get("ftpcarService").update(this.getTstbFtpCarInformation(), carInformationCriteria);
            }
            return true;
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
    }

    /**
     * 用户界面确认停车
     *
     * @return 是, 否
     * @throws SkyLotException skylot exception
     */
    public boolean userconfirmCar(TstbFtpCarInformation carInformation) throws SkyLotException {
        try {
            return confirmCar(carInformation);
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
    }

    /**
     * 检查是否有任务需要执行
     *
     * @return 是, 否
     */
    public boolean hasTasktodo() throws SkyLotException {
        try {
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.setOrderByClause("tfc_id asc");
            List dataList = serviceMap.get("ftpcarService").queryForAll(carInformationCriteria);
            if (CollectionUtils.isNotEmpty(dataList)) {
                tstbFtpCarInformation = (TstbFtpCarInformation) dataList.get(0);
                return true;
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return false;
    }

    /**
     * 当前工控机是否已经完成同步
     *
     * @return true:是,false:否
     */
    protected boolean isSyncedIMA() throws Exception {
        OftbSyncLogCriteria oftbSyncLogCriteria = new OftbSyncLogCriteria();
        oftbSyncLogCriteria.setOrderByClause("  osl_id desc");
        List oftbSyncLogDao = this.daoMap.get("oftbSyncLogDao").ReadAll(oftbSyncLogCriteria);
        if (CollectionUtils.isNotEmpty(oftbSyncLogDao)) {
            OftbSyncLog errorList = (OftbSyncLog) oftbSyncLogDao.get(0);
            if (errorList != null) {
                if (errorList.getOslType().equals("0")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查是否执行了取消命令
     *
     * @return 是, 否
     */
    public boolean checkCanceled() throws SkyLotException {
        try {
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.setOrderByClause("tfc_id asc");
            List dataList = serviceMap.get("ftpcarService").queryForAll(carInformationCriteria);
            if (CollectionUtils.isNotEmpty(dataList)) {
                tstbFtpCarInformation = (TstbFtpCarInformation) dataList.get(0);
                if (StringUtils.equals(tstbFtpCarInformation.getTfcIsCanceled(), FN_RETURN_STATUS_SUCCESS)) {
                    //取消取车之前检查是否满足
                    return true;
                }
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return false;
    }

    /**
     * 等待取消指令确认
     *
     * @return 是, 否
     * @throws SkyLotException
     */
    public boolean userCancel(boolean... abort) throws SkyLotException {
        try {
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.setOrderByClause("tfc_id asc");
            List dataList = serviceMap.get("ftpcarService").queryForAll(carInformationCriteria);
            if (CollectionUtils.isNotEmpty(dataList)) {
                tstbFtpCarInformation = (TstbFtpCarInformation) dataList.get(0);
                tstbFtpCarInformation.setTfcIsCanceled("0");
                if (abort.length > 0) {
                    tstbFtpCarInformation.setTfcIsCanceled("1");
                }
                serviceMap.get("ftpcarService").update(tstbFtpCarInformation);
                return true;
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return false;
    }

    /**
     * 更新PLC心跳数据
     *
     * @param pType   运行类型,1:无,2:取车,3:存车,4:预约取车,5:配载
     * @param pStatus
     * @throws Exception skylot exception
     */
    public void heartBeatPLC(String pType, String pStatus) throws Exception {
        Map scheduleMap = new HashMap();
        scheduleMap.put(SCHEDULEACTION_TYPE_HEARTBEAT, SCHEDULEACTION_TYPE_HEARTBEAT_PLC);
        scheduleMap.put(SCHEDULEACTION_TYPE_ITEM, 1 + "");
        Map statusMap = socketService.getAllStatus();
        scheduleMap.put(SCHEDULEACTION_MESSAGE, SingletonObjectMapper.getInstance().writeValueAsString(statusMap));
        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
        iftbMachineAction.setImaStatus(MapUtils.getString(scheduleMap, "operationStatus"));
        String mStatus = "2";
        if (StringUtils.equals(pType, SYSTEM_WORKING_MODEL_NORMAL)) {
            mStatus = "1";
        }
        if (StringUtils.equals(FN_RETURN_STATUS_HANDLE, iftbMachineAction.getImaStatus())) {
            highException = true;
            mStatus = "9";
        }
        hasTasktodo();
        if (tstbFtpCarInformation == null) {
            tstbFtpCarInformation.setTfcCarCode("");
            tstbFtpCarInformation.setTfcCarInCode("");
        }
        updateStatus(pType, mStatus, pStatus, tstbFtpCarInformation.getTfcCarCode(), tstbFtpCarInformation.getTfcCarInCode(), MapUtils.getString(scheduleMap, "operationStatus"), code.getTargetLot());
        syncServiceImpl.updateSchedule(scheduleMap);
    }

    /**
     * 检查人行门是否有开关
     */
    protected void peopleDoorhadOpen() throws SkyLotException {
        if (socketService.confirmStatus(5, true) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            peopleDoor = true;
        }
    }

    /**
     * 检查车库门是否有开
     */
    protected void carDoorhadOpen() throws SkyLotException {
        if (socketService.confirmStatus(3, true) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            carDoor = true;
        }
    }

    /**
     * 检查车库门是否有关
     */
    protected void carDoorhadClose() throws SkyLotException {
        if (socketService.confirmStatus(4, true) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            carDoor = true;
        }
    }

    /**
     * 检查是否有严重故障
     */
    protected void highErrorExist() throws SkyLotException {
        if (socketService.confirmStatus(9, true) == NumberUtils.toInt(FN_RETURN_STATUS_HANDLE)) {
            highError = true;
        }
    }

    /**
     * 检查1005,故障是否依然存在
     *
     * @return true:1005故障已清除,false:1005故障依然存在
     * @throws SkyLotException
     */
    protected boolean parkingError() throws SkyLotException {
        Map valuesMap = getSocketService().getIndexError();
        analyzingError(valuesMap, "p");
        if (MapUtils.isEmpty(MapUtils.getMap(valuesMap, "valueMap")) && MapUtils.isEmpty(MapUtils.getMap(valuesMap, "valueAppendMap"))) {
            return true;
        }
        return false;
    }

    /**
     * 检查1007,故障是否依然存在
     *
     * @return true:1007故障已清除,false:1005故障依然存在
     * @throws SkyLotException
     */
    protected boolean extractError() throws SkyLotException {
        Map valuesMap = getSocketService().pullIndexError();
        analyzingError(valuesMap, "e");
        if (MapUtils.isEmpty(MapUtils.getMap(valuesMap, "valueMap")) && MapUtils.isEmpty(MapUtils.getMap(valuesMap, "valueAppendMap"))) {
            return true;
        }
        return false;
    }

    /**
     * 检查取消指令是否可以执行
     *
     * @param actionType 操作的类型,0:取消存车,1:取消取车
     * @throws SkyLotException
     */
    private boolean checkCancelAction(String actionType) throws SkyLotException {
        if (StringUtils.equals(CMD_STR_CANCEL_PARK, actionType)) {//取消存车
            Map valuesMap = getSocketService().getIndexError();
            List errors = analyzingError(valuesMap, "p");
            boolean checkError = false;
            if (CollectionUtils.isNotEmpty(errors)) {
                for (int i = 0; i < errors.size(); i++) {
                    Map o = (Map) errors.get(i);
                    ErrorCodeObj errorCodeObj = (ErrorCodeObj) o.get("ErrorCodeObj");
                    if (StringUtils.containsAny(errorCodeObj.getErrorCode(), "request.user.parking.platform", "request.user.parking.cardoor", "request.user.parking.scanner", "request.user.parking.peopledoor", "request.user.parking.cancel.exist.car")) {//查找错误信息
                        checkError = true;
                        break;
                    }
                }
            }
            if (checkError) {
                return false;
            }
        } else {
            Map valuesMap = getSocketService().pullIndexError();
            List errors = analyzingError(valuesMap, "e");
            boolean checkError = false;
            if (CollectionUtils.isNotEmpty(errors)) {
                for (int i = 0; i < errors.size(); i++) {
                    Map o = (Map) errors.get(i);
                    ErrorCodeObj errorCodeObj = (ErrorCodeObj) o.get("ErrorCodeObj");
                    if (StringUtils.containsAny(errorCodeObj.getErrorCode(), "request.user.extract.scanner", "request.user.extract.cardoor", "request.user.extract.peopledoor", "request.user.extract.cancel.emptyCar.car", "request.user.extract.platform")) {//查找错误信息
                        checkError = true;
                        break;
                    }
                }
            }
            if (checkError) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分析错误Map,配置具体错误信息
     *
     * @param errorMaps   停车错误对象Map
     * @param errorAction 对应操作的类型,p:停车,e:取车
     */
    public List analyzingError(Map errorMaps, String errorAction) {
        List result = Lists.newArrayList();
        errorList = Lists.newArrayList();
        if (MapUtils.isNotEmpty(errorMaps)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (MapUtils.isNotEmpty(MapUtils.getMap(errorMaps, "valueMap", Maps.newHashMap()))) {
                Iterator<Map.Entry<Integer, String>> it = MapUtils.getMap(errorMaps, "valueMap", Maps.newHashMap()).entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> pair = it.next();
                    stringBuilder.append(errorAction).append(pair.getKey()).append(",");
                }

            }
            if (MapUtils.isNotEmpty(MapUtils.getMap(errorMaps, "valueAppendMap", Maps.newHashMap()))) {
                Iterator<Map.Entry<Integer, String>> it = MapUtils.getMap(errorMaps, "valueAppendMap", Maps.newHashMap()).entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> pair = it.next();
                    stringBuilder.append(errorAction).append(errorAction).append(pair.getKey()).append(",");
                }

            }
            if (StringUtils.isNotEmpty(stringBuilder)) {
                String str = StringUtils.chop(stringBuilder.toString());
                String[] array = str.split(",");
                for (int i = 0; i < array.length; i++) {
                    String s = array[i];
                    Map map = Maps.newHashMap();
                    ErrorCodeObj errorCodeObj = ErrorCodeObj.builder().build();
                    errorCodeObj.setErrorCode(code.getCodePLC().get(s).toString());
                    errorCodeObj.setErrorMsg(code.getCodeMap().get(code.getCodePLC().get(s).toString()).toString());
                    map.put("ErrorCodeObj", errorCodeObj);
                    errorList.add(map);
                }
                result = errorList;
            }
        }
        return result;
    }


    /**
     * 更新IMA对象的状态
     *
     * @param operationType   运行类型
     * @param machineStatus   机器状态
     * @param operationStatus 运行状态
     * @param tfcCarCode      车牌
     * @param tfcCarInCode    内部车牌
     * @param iStatus         ima状态
     * @param targetLot       目标车台
     * @throws Exception
     */
    public void updateStatus(String operationType, String machineStatus, String operationStatus, String tfcCarCode, String tfcCarInCode, String iStatus, String targetLot) throws Exception {
        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
        JsonDataResult dataResult = JsonDataResult.builder().build();
        JsonResult jsonResult = JsonResult.builder().build();
        dataResult.setMachineStatus(machineStatus);
        dataResult.setOperationStatus(operationStatus);
        dataResult.setOperatingType(operationType);
        dataResult.setTargetLot(targetLot);
        if (StringUtils.isNotEmpty(tfcCarCode)) {
            dataResult.setCarCode(tfcCarCode);
            List<Map<String, String>> datalist = Lists.newArrayList();
            Map dataMap = Maps.newHashMap();
            dataMap.put(MAP_QRCODE_CARCODE, tfcCarCode);
            datalist.add(dataMap);
            if (StringUtils.isNotEmpty(tfcCarInCode)) {
                dataMap = Maps.newHashMap();
                dataMap.put(MAP_QRCODE_CARCODE, tfcCarInCode);
                datalist.add(dataMap);
            }
            dataResult.setCarCodes(datalist);
        }

        jsonResult.setData(SkylotUtils.removeNullValue(SkylotUtils.beanToHashMap(dataResult)));
        if (CollectionUtils.isNotEmpty(code.getErrorList())) {
            jsonResult.setError(code.getErrorList());
        } else {
            jsonResult.setError(errorList);
        }

        jsonResult.setResultType(true);
        if (checkCanceled()) {
            jsonResult.setResultType(CollectionUtils.isNotEmpty(jsonResult.getError()) ? false : true);
        }

        IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
        criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
        List mList = serviceMap.get("machineActionService").queryForAll(criteria);
        if (CollectionUtils.isNotEmpty(mList)) {
            IftbMachineAction machineAction = (IftbMachineAction) mList.get(0);
            jsonResult.setServiceType(machineAction.getImaCode());
        }
        iftbMachineAction.setImaErrorJson(SingletonObjectMapper.getInstance().writeValueAsString(jsonResult));
        iftbMachineAction.setImaPhysicalStatus(iStatus);
        serviceMap.get("machineActionService").update(iftbMachineAction, criteria);
    }

    /**
     * 取消存取车操作
     *
     * @param actionType 0:存车,1:取车
     * @return
     */
    protected boolean cancelAction(String actionType) throws Exception {
        boolean result = false;
        String errorAction = "e";
        String errorCode = "request.user.extract.carexist";
        String opt = "2";
        String mt = "2";
        String os = "2";
        Map valuesMap = getSocketService().pullIndexError();
        try {
//            while (waitForCancel()) {//等待用户确认取消
//
//            }
            //取消取车执行条件判断
            if (StringUtils.equals(actionType, "0")) {
                errorAction = "p";
                errorCode = "request.user.parking.cancel.exist.car";
                valuesMap = getSocketService().getIndexError();
                opt = "3";
            }

            List errors = analyzingError(valuesMap, errorAction);
            boolean checkError = false;
            if (CollectionUtils.isNotEmpty(errors)) {
                for (int i = 0; i < errors.size(); i++) {
                    Map o = (Map) errors.get(i);
                    ErrorCodeObj errorCodeObj = (ErrorCodeObj) o.get("ErrorCodeObj");
                    if (StringUtils.containsAny(errorCodeObj.getErrorCode(), errorCode)) {//查找错误信息
                        checkError = true;
                        break;
                    }
                }
            } else {
                Map maps = Maps.newHashMap();
                Map valueAppendMap = Maps.newHashMap();
                maps.put(7, "1");
                valueAppendMap.put("valueMap", maps);
                code.setErrorList(analyzingError(valueAppendMap, errorAction));
                updateStatus(opt, mt, os, this.getTstbFtpCarInformation().getTfcCarCode(), this.getTstbFtpCarInformation().getTfcCarInCode(), "0", code.getTargetLot());
            }

            if (!checkError) {//待取车辆,已经开走
                userCancel(true);
                return false;
            }
            code.setErrorList(Lists.newArrayList());
            updateStatus(opt, mt, os, this.getTstbFtpCarInformation().getTfcCarCode(), this.getTstbFtpCarInformation().getTfcCarInCode(), "0", code.getTargetLot());
            marqueeUtil.sendText(actionType.equals("0") ? "存车中" : "取车中", this.getTstbFtpCarInformation().getTfcCarCode() + ",接收到取消指令,正在执行取消操作,请稍后", true);
            //检查是否可以进行取消操作
            int status = socketService.cancelAction(actionType);
            int count = 0;
            while (!checkCancelAction(actionType)) {
                loggerParking.warn("正在检查取消指令是否可以执行!");
                heartBeatPLC(actionType.equals("0") ? "3" : "2", "2");
                Thread.sleep(1000);
                count++;
                if (count > 300) {
//// TODO: 29/01/2018 超时300秒,记录异常
                }
            }
            loggerParking.warn("安全监测完成,执行车库门关闭!");
            //跳出循环,发送关车门的指令
            socketService.carDoor(FN_RETURN_STATUS_ERROR);
            socketService.confirmStatus(4);//等待车库门关闭
            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
            carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
            serviceMap.get("ftpcarService").delete(carInformationCriteria);
            getMarqueeUtil().sendText("Skylot", "欢迎停车!", true, "思该唠特");
            //更新IMA状态
            updateStatus("1", "1", "3", this.getTstbFtpCarInformation().getTfcCarCode(), this.getTstbFtpCarInformation().getTfcCarInCode(), "0", code.getTargetLot());
            return true;
        } catch (SkyLotException e) {
            throw new SkyLotException(e);
        }
    }

    /**
     * 取消取车失败操作
     */
    protected void cancelError() throws Exception {
        TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
        carInformationCriteria.createCriteria().andTfcCarCodeEqualTo(this.getTstbFtpCarInformation().getTfcCarCode());
        this.getTstbFtpCarInformation().setTfcIsCanceled("1");
        serviceMap.get("ftpcarService").update(this.getTstbFtpCarInformation(), carInformationCriteria);
        Map valuesMap = getSocketService().pullIndexError();
        analyzingError(valuesMap, "e");
        heartBeatPLC("2", "2");
    }
}
