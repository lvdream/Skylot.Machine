package com.fangda.skylot.mathine.service.impl.sync;


import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.dao.customer.IftbItemCustomerDAO;
import com.fangda.skylot.mathine.dao.customer.MstbCustomerDAO;
import com.fangda.skylot.mathine.dao.customer.OftbCustomerCarDAO;
import com.fangda.skylot.mathine.dao.parking.IftbMachineActionDAO;
import com.fangda.skylot.mathine.dao.parking.OftbMathineItemDAO;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingDAO;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingLogDAO;
import com.fangda.skylot.mathine.model.customer.*;
import com.fangda.skylot.mathine.model.parking.*;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.model.utils.IftbScheduleActionCriteria;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadUtil;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.SocketService;
import com.fangda.skylot.mathine.service.parking.ParkingLogService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.service.utils.ScheduleService;
import com.fangda.skylot.mathine.utils.*;
import com.fangda.skylot.mathine.utils.constant.Constant;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.socket.WSThreadMgtSend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.*;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

/**
 * Created by Saul on 16/06/2017.
 */
@SuppressWarnings("ALL")
@Component
@Data
@Slf4j
public class SyncServiceImpl implements SyncService {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private Map<String, IBaseDao> daoMap;
    @Autowired
    private SocketService socketService;
    @Autowired
    private WSThreadMgtSend wsThreadMgtSend;
    private TstbMathineParkingLog tmpl;
    private String maId;
    private MstbCustomer mstbCustomer;
    private Client client;
    @Autowired
    private MainThreadUtil mainThreadUtil;
    @Autowired
    private ErrorCode code;

    /**
     * @return
     * @throws Exception
     */
    @Override
    public int heartbeatSyncServer() throws Exception {
        try {
            //抽取信息,来着服务器
            //同步物业设备信息
//            getUpdateActionItems();
//            //同步用户信息
//            getUpdateCustomers();
//            //同步用户车牌信息
//            getUpdateCustomersCar();
//            //同步实体车位数据
//            getUpdateMathineItem();
//            //同步用户车牌绑定设备信息
//            getUpdateCustomersItem();
            //推送同步信息到服务器
            itemStatus();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
        }
        return 0;
    }

    @Override
    public int heartbeatSyncPLC() throws Exception {
        int plcStatus = 0;
        //check the indenty type
        int iType = NumberUtils.toInt(GetProperties.getProperties("system.properties", "identify.type"));
        if (iType == NumberUtils.toInt(Constant.SYSTEM_WORKING_MODEL_TEST)) {
            String localpath = GetProperties.getProperties("system.properties", "download.file.path");//本地路径
            File f = new File(localpath + "/" + "test.csv");
            if (f.exists()) {
                return 2;
            }
        }
        if (hasSyncError("1")) {//PLC通信失败,先同步数据
            comparePLC2Local();
        } else {
            addSyncError("0");//新增正常数据
        }
        int a = 0;
        int r = checkPLC(9, true);
        while (r != 0) {
            r = checkPLC(9, true);
            Thread.sleep(1000);
            if (a > 10) {//PLC连接超时
                addSyncError("1");
                break;
            }
            if (r == 1 || r == -1) {
                addSyncError("1");
                break;
            }
            a++;
        }
        plcStatus = 1;
        if (r == 0) {
            addSyncError("0");//新增正常数据
        } else {
            plcStatus = 9;
        }

        try {
            mainThreadUtil.updateStatus("1", "" + plcStatus, "3", null, null, r == 0 ? "0" : "1", code.getTargetLot());
            Map scheduleMap = new HashMap();
            scheduleMap.put(SCHEDULEACTION_TYPE_HEARTBEAT, SCHEDULEACTION_TYPE_HEARTBEAT_PLC);
            scheduleMap.put(SCHEDULEACTION_TYPE_ITEM, plcStatus + "");
            scheduleMap.put(SCHEDULEACTION_MESSAGE, SingletonObjectMapper.getInstance().writeValueAsString(socketService.getAllStatus(true)));
            updateSchedule(scheduleMap);
            return 0;
        } catch (JsonProcessingException e) {
            throw new SkyLotException(e);
        } finally {
            return 1;
        }

    }

    @Override
    public Map parkCar(String carNumber, boolean firstPark) throws Exception {
        Map parkingMap = new HashMap();
        Logger loggerParking = Logger.getLogger("Parking");
        try {
            if (checkCarFromDB(carNumber) == 0) {//车牌授权成功,可以进行停车
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],车牌授权成功,准备查询PLC设备!");
                int parkingStatus = checkPLC(1);
                if (parkingStatus == 0) {//PLC是否准备好停车
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],PLC设备可用,准备停车!");
                    if (getParkingPhysicalCode(carNumber) == 0) {//车牌已经停车,不能再存
                        parkingMap = socketService.doParking(carNumber, firstPark);
                        if (MapUtils.getIntValue(parkingMap, MAP_PARKING_STATUS) == 0) {
                            if (createParkinglog(carNumber, parkingMap, 0) == 0) {
                                ((TstbMathineParkingLogDAO) this.daoMap.get("tstbMathineParkingLogDao")).save(this.getTmpl());
                                try {
                                    CommandSchedule();
                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                                return parkingMap;
                            } else {
                                throw new Exception(EX_PARKING_MATHINE_EXCEPTION);
                            }
                        }
                    } else {
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],车牌已经停车,不能重复停车!");
                        throw new Exception(EX_PARKING_CAR_EXIST);
                    }

                } else {
                    if (parkingStatus == 2) {//没有可用车位可以停车
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],PLC设备已经没有可用停车位置,本次停车失败!");
                        throw new Exception(EX_PARKING_MATHINE_NOT_AVIABLE);
                    } else {
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],PLC设备故障,本次停车失败!");
                        throw new Exception(EX_PARKING_MATHINE_EXCEPTION);
                    }
                }
            } else {
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + carNumber + "],车牌授权失败,停车失败!");
                throw new Exception(EX_PARKING_USER_AUTH_IN_MATHINE);
            }
        } catch (Exception e) {
            if (e.getMessage().equals(EX_PARKING_USER_AUTH_IN_MATHINE)) {
                parkingMap.put(MAP_PARKING_STATUS, 1);
            } else if (e.getMessage().equals(EX_PARKING_MATHINE_EXCEPTION)) {
                parkingMap.put(MAP_PARKING_STATUS, 2);
            } else if (e.getMessage().equals(EX_PARKING_CAR_EXIST)) {
                parkingMap.put(MAP_PARKING_STATUS, 3);
            } else if (e.getMessage().equals(EX_PARKING_MATHINE_NOT_AVIABLE)) {
                parkingMap.put(MAP_PARKING_STATUS, 4);
            }
        }
        return parkingMap;
    }

    @Override
    public Map pullCar(String carNumber) throws Exception {
        Map parkingMap = new HashMap();
        Logger loggerParking = Logger.getLogger("Parking");
        try {
            if (checkCarFromDB(carNumber) == 0) {//车牌授权成功,可以进行操作
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + carNumber + "],车牌授权成功,准备查询PLC设备!");
                if (checkPLC(0) == 0) {//PLC是否准备好取车
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + carNumber + "],PLC设备可用,准备取车!");
                    int positionNumber = getParkingPhysicalCode(carNumber);
                    if (positionNumber > 0) {
                        parkingMap = socketService.doPulling(positionNumber + "", true);
                        if (MapUtils.getIntValue(parkingMap, MAP_PARKING_STATUS) == 0) {
                            parkingMap.put(MAP_PARKING_LOCATION, positionNumber);
                            if (createParkinglog(carNumber, parkingMap, 1) == 0) {
                                ((TstbMathineParkingLogDAO) this.daoMap.get("tstbMathineParkingLogDao")).save(this.getTmpl());
                                try {
                                    CommandSchedule();
                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                                return parkingMap;
                            }
                        }
                    } else {
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + carNumber + "],没有在当前设备上查询到待取车辆,取车失败!");
                        throw new Exception(EX_PULLING_NO_CAR_IN_SEARCH);
                    }
                } else {
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + carNumber + "],PLC设备故障,本次停车失败!");
                    throw new Exception(EX_PARKING_MATHINE_EXCEPTION);
                }
            } else {
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + carNumber + "],车牌授权失败,取车失败!");
                throw new Exception(EX_PARKING_USER_AUTH_IN_MATHINE);
            }
        } catch (Exception e) {
            if (e.getMessage().equals(EX_PARKING_USER_AUTH_IN_MATHINE)) {
                parkingMap.put(MAP_PARKING_STATUS, 1);
            }
            if (e.getMessage().equals(EX_PARKING_MATHINE_EXCEPTION)) {
                parkingMap.put(MAP_PARKING_STATUS, 2);
            }
            if (e.getMessage().equals(EX_PULLING_NO_CAR_IN_SEARCH)) {
                parkingMap.put(MAP_PARKING_STATUS, 3);
            }
        }
        return parkingMap;
    }

    /**
     * 检查车牌是否合法
     *
     * @param carNumber 车牌
     * @return 0, 已授权, 1, 未授权,其中临停设备,可以直接停车
     */
    public int checkCarFromDB(String carNumber) throws Exception {
        try {
            //增加临时车牌停车逻辑,验证当前设备是否是临停设备
            IftbMachineActionCriteria iftbMachineActionCriteria = new IftbMachineActionCriteria();
            iftbMachineActionCriteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
            IftbMachineAction iftbMachineAction = ((IftbMachineActionDAO) this.daoMap.get("iftbMachineActionDao")).ReadSingle(iftbMachineActionCriteria);
            if (iftbMachineAction != null) {
                if (StringUtils.equals(iftbMachineAction.getImaCode(), MACHINEPARKING_TYPE_TEMPLATE)) {//临停判断
                    return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                }
            }
            OftbCustomerCarCriteria customerCarCriteria = new OftbCustomerCarCriteria();
            customerCarCriteria.createCriteria().andOccCodeEqualTo(carNumber);
            OftbCustomerCar customerCar = ((OftbCustomerCarDAO) this.daoMap.get("customerCarDao")).ReadSingle(customerCarCriteria);
            if (customerCar != null) {//车牌是否存在
                MstbCustomerCriteria customerCriteria = new MstbCustomerCriteria();
                customerCriteria.createCriteria().andMcIdEqualTo(customerCar.getMcId());
                MstbCustomer customer = ((MstbCustomerDAO) this.daoMap.get("mstbCustomerDao")).ReadSingle(customerCriteria);
                setMstbCustomer(customer);
                if (customer != null) {//客户是否存在
                    if (checkCarBelongToCurrentMachine(customer.getMcId().intValue(), carNumber) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
        }
        return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
    }

    /**
     * 检查当前车牌是否绑定当前设备
     *
     * @param cusId 客户序号
     * @return 0, 车牌可以授权, 1车牌无法授权
     */
    private int checkCarBelongToCurrentMachine(int cusId, String carNumber) throws Exception {
        String machineId = GetProperties.getProperties("system.properties", "skylot.machine.id");//设备ID
        IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
        criteria.createCriteria().andImaIdEqualTo(machineId);
        IftbMachineAction iftbMachineAction = ((IftbMachineActionDAO) this.daoMap.get("iftbMachineActionDao")).ReadSingle(criteria);
        if (iftbMachineAction != null) {//当前设备是否存在
            OftbMathineItemCriteria oftbMathineItemCriteria = new OftbMathineItemCriteria();
            oftbMathineItemCriteria.createCriteria().andImaIdEqualTo(iftbMachineAction.getImaId());
            setMaId(iftbMachineAction.getImaId());
            List oftbMathineItems = ((OftbMathineItemDAO) this.daoMap.get("oftbMathineItemDao")).ReadAll(oftbMathineItemCriteria);
            if (CollectionUtils.isNotEmpty(oftbMathineItems)) {//设备上是否有停车位
                IftbItemCustomerCriteria customerCriteria = new IftbItemCustomerCriteria();
                List<Integer> ids = new ArrayList<Integer>();
                for (Iterator<OftbMathineItem> oftbMathineItemIterator = oftbMathineItems.iterator(); oftbMathineItemIterator.hasNext(); ) {
                    OftbMathineItem next = oftbMathineItemIterator.next();
                    ids.add(next.getOmiId());
                }
                customerCriteria.createCriteria().andMcIdEqualTo(cusId).andOmiIdIn(ids).andIccCarCodeEqualTo(carNumber);
                List iftbItemCustomers = ((IftbItemCustomerDAO) this.daoMap.get("iftbItemCustomerDao")).ReadAll(customerCriteria);
                if (CollectionUtils.isNotEmpty(iftbItemCustomers)) {//用户在当前设备已经绑定车牌
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * 获取待取车的停车位置
     *
     * @param carNumber 车牌
     * @return 0, 没有位置, 其他就是位置信息
     */
    public int getParkingPhysicalCode(String carNumber) throws Exception {
        try {
            TstbMathineParkingCriteria criteria = new TstbMathineParkingCriteria();
            criteria.createCriteria().andTmpCarCodeEqualTo(carNumber).andImaIdEqualTo(SkylotUtils.imaId);
            TstbMathineParking tstbMathineParking = ((TstbMathineParkingDAO) this.daoMap.get("tstbMathineParkingDao")).ReadSingle(criteria);
            if (tstbMathineParking == null) {
                return 0;
            }
            return NumberUtils.toInt(StringUtils.defaultString(tstbMathineParking.getTmpPhysicalCode(), "0"), 0);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception("Get parking car error");
        }

    }

    /**
     * 检查PLC的状态
     *
     * @param checkType 检查类型,0,状态检查,1,状态和空闲车位检查,9:心跳检查
     * @return 0, 检查成功, 1, 检查失败,2,没有空位可以停车
     * @throws Exception
     */
    public int checkPLC(int checkType, boolean... check) throws Exception {
        if (checkType == 3 || checkType == 9) {
            int r = socketService.confirmStatus(9, check);
            return r;
        } else {
            if (socketService.confirmStatus(2, check) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//设备状态是否正常
                if (checkType == 1) {//是否有可用车位可以进行停车
                    if (socketService.enableParking() == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
                        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
                    } else {
                        return 2;
                    }
                }
                return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
            }
        }
        return 1;
    }

    /**
     * 创建停车流水
     *
     * @param carNumber     车牌信息
     * @param parkingNumber
     * @param isParking
     * @return 0, 成功, 1, 失败
     */
    public int createParkinglog(String carNumber, Map parkingMap, int isParking) {
        try {
            TstbMathineParkingLog tstbMathineParkingLog = TstbMathineParkingLog.builder().build();
            tstbMathineParkingLog.setImaId(getMaId() != null ? getMaId() : SkylotUtils.imaId);
            tstbMathineParkingLog.setTmplCreatedate(DateUtil.getNowDate());
            tstbMathineParkingLog.setTmplCar(carNumber);
            tstbMathineParkingLog.setTmplPhysicalCode(MapUtils.getIntValue(parkingMap, MAP_PARKING_LOCATION) == 0 ? "" : MapUtils.getIntValue(parkingMap, MAP_PARKING_LOCATION) + "");
            tstbMathineParkingLog.setTmplCustomer("");
            tstbMathineParkingLog.setTmplType(isParking == 0 ? MACHINEPARKING_TYPE_PARK : MACHINEPARKING_TYPE_TAKE);
            tstbMathineParkingLog.setTmplStatus(PARKING_PULLING_STATUS_FINISH);
            tstbMathineParkingLog.setTmplDiectionCode(MapUtils.getString(parkingMap, MACHINEACTION_DIRECTION_CODE));
            tstbMathineParkingLog.setTmplOperationDuriationTotal(MapUtils.getString(parkingMap, MAP_TIME_SPEND_ALL));
            tstbMathineParkingLog.setTmplOperationDuriationRouting(MapUtils.getString(parkingMap, MAP_TIME_SPEND_DIRECTION));
            tstbMathineParkingLog.setTmplOperationDuriationManually(MapUtils.getString(parkingMap, MAP_TIME_SPEND_DOING));
            tstbMathineParkingLog.setTmplOperationDuriationWeighting(MapUtils.getString(parkingMap, MAP_TIME_SPEND_WEIGHT));
            tstbMathineParkingLog.setTmplOperationEnergyCost(MapUtils.getString(parkingMap, MAP_ENERGY));
            this.setTmpl(tstbMathineParkingLog);
            ((TstbMathineParkingLogDAO) this.daoMap.get("tstbMathineParkingLogDao")).save(this.getTmpl());
            CommandSchedule();

            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * 更新心跳同步日程,如无,插入待更新数据,如有则更新数据中的更新时间和状态
     *
     * @param scheduleMap 同步日程Map对象
     * @throws JsonProcessingException
     */
    public void updateSchedule(Map scheduleMap) throws JsonProcessingException, Exception {
        ScheduleService scheduleService = (ScheduleService) serviceMap.get("scheduleService");
        //01.删除已经同步完成的对象

        IftbScheduleActionCriteria iftbScheduleActionCriteria = new IftbScheduleActionCriteria();
        iftbScheduleActionCriteria.createCriteria().andIsaStatusEqualTo(SCHEDULEACTION_STATUS_FINISH);
        scheduleService.delete(iftbScheduleActionCriteria);

        //02.更新心跳
        IftbScheduleAction iftbScheduleAction = IftbScheduleAction.builder().build();
        iftbScheduleAction.setIsaUpdatedate(SkylotUtils.getStrDate());
        iftbScheduleAction.setIsaCreatedate(SkylotUtils.getStrDate());
        iftbScheduleAction.setIsaStatus(SCHEDULEACTION_TYPE_ADD);
        iftbScheduleAction.setIsaModuleId(SkylotUtils.imaId);
        iftbScheduleAction.setIsaScheduleDate(SkylotUtils.getStrDate());
        iftbScheduleAction.setIsaScheduleType(MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_HEARTBEAT, ""));
        iftbScheduleAction.setIsaItemId(MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_ITEM));
        iftbScheduleAction.setIsaBusinessObj(SCHEDULEACTION_BUSINESSOBJ_MACHINE);
        iftbScheduleAction.setIsaScheduleMessage(MapUtils.getString(scheduleMap, SCHEDULEACTION_MESSAGE));
        if (MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_HEARTBEAT, "").equals(SCHEDULEACTION_TYPE_HEARTBEAT_PLC)) {
            iftbScheduleActionCriteria.clear();
            iftbScheduleActionCriteria.createCriteria().andIsaScheduleTypeEqualTo(SCHEDULEACTION_TYPE_HEARTBEAT_PLC).andIsaUpdatedateLessThan(SkylotUtils.getStrDate());
            IftbScheduleAction fromdb = scheduleService.query(iftbScheduleActionCriteria);
            if (fromdb == null) {
                scheduleService.add(iftbScheduleAction);
            } else {
                iftbScheduleAction.setIsaId(fromdb.getIsaId());
                iftbScheduleAction.setIsaScheduleMessage(MapUtils.getString(scheduleMap, SCHEDULEACTION_MESSAGE));
                iftbScheduleAction.setIsaCreatedate(null);
                scheduleService.update(iftbScheduleAction, iftbScheduleActionCriteria);
            }
        } else {
            iftbScheduleAction.setIsaBusinessObj(SCHEDULEACTION_BUSINESSOBJ_CUSTOMER);
            scheduleService.add(iftbScheduleAction);
        }


    }

    /**
     * 停取车日志同步
     *
     * @throws JsonProcessingException
     */
    private void CommandSchedule() throws JsonProcessingException, Exception {
        ParkingLogService parkingLogService = (ParkingLogService) serviceMap.get("parkinglogService");
        TstbMathineParkingLogCriteria criteria = new TstbMathineParkingLogCriteria();
        criteria.createCriteria().andTmplCreatedateGreaterThanOrEqualTo(DateFormatUtils.format(DateUtils.addMinutes(new Date(), -1), DATE_FORMAT_STANDARD)).andTmplCreatedateLessThanOrEqualTo(SkylotUtils.getStrDate());//// TODO: 2017/6/25 默认抓取PLC同步时间是当前时间减去一分钟之内的时间区间
        List quaryList = parkingLogService.queryForAll(criteria);
        if (CollectionUtils.isNotEmpty(quaryList)) {
            Map scheduleMap = new HashMap();
            scheduleMap.put(SCHEDULEACTION_TYPE_HEARTBEAT, SCHEDULEACTION_TYPE_HEARTBEAT_SERVER);
            scheduleMap.put(SCHEDULEACTION_TYPE_ITEM, "0");
            scheduleMap.put(SCHEDULEACTION_MESSAGE, SingletonObjectMapper.getInstance().writeValueAsString(quaryList));
            updateSchedule(scheduleMap);
        }
    }

//    /**
//     * 获取服务器端的物业设备信息,增量更新
//     */
//    private void getUpdateActionItems() throws Exception {
//        Object[] resultArr = client.invoke("toReturnMachineAction", GetProperties.getProperties("system.properties", "skylot.machine.id"), SkylotUtils.getStrDate());
//        if (resultArr != null) {
//            if (resultArr[0] != null) {
//                String items = resultArr[0].toString();
//                Map itemList = SingletonObjectMapper.getInstance().readValue(items, Map.class);
//                if (MapUtils.isNotEmpty(itemList)) {
//                    List<String> ids = new ArrayList<String>();
//                    List objs = (List) MapUtils.getObject(itemList, "update");//只需要更新update对象
//                    if (CollectionUtils.isNotEmpty(objs)) {//有需要更新的物业设备信息
//                        Map next = (Map) objs.get(0);
//                        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
//                        BeanUtils.populate(iftbMachineAction, next);
//                        IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
//                        criteria.or().andImaIdEqualTo(iftbMachineAction.getImaId());
//                        daoMap.get("iftbMachineActionDao").updatewithoutNull(iftbMachineAction, criteria);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取服务器端的用户信息
//     */
//    private void getUpdateCustomers() throws Exception {
//        Object[] resultArr = client.invoke("toReturnCustomer", SkylotUtils.getStrDate());
//        if (resultArr != null) {
//            if (resultArr[0] != null) {
//                String items = resultArr[0].toString();
//                Map itemList = SingletonObjectMapper.getInstance().readValue(items, Map.class);
//                if (MapUtils.isNotEmpty(itemList)) {
//                    List<Integer> ids = new ArrayList<Integer>();
//                    List addList = (List) MapUtils.getObject(itemList, "add");
//                    List updateList = (List) MapUtils.getObject(itemList, "update");
//                    if (CollectionUtils.isNotEmpty(addList)) {//新增数据
//                        for (int i = 0; i < addList.size(); i++) {
//                            Map o = (Map) addList.get(i);
//                            MstbCustomer next = MstbCustomer.builder().build();
//                            BeanUtils.populate(next, o);
//                            daoMap.get("mstbCustomerDao").save(next);
//                        }
//                    }
//                    if (CollectionUtils.isNotEmpty(updateList)) {//更新数据
//                        for (int i = 0; i < updateList.size(); i++) {
//                            Map o = (Map) updateList.get(i);
//                            MstbCustomer next = MstbCustomer.builder().build();
//                            BeanUtils.populate(next, o);
//                            MstbCustomerCriteria customerCriteria = new MstbCustomerCriteria();
//                            customerCriteria.createCriteria().andMcIdEqualTo(next.getMcId());
//                            daoMap.get("mstbCustomerDao").updatewithoutNull(next, customerCriteria);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取服务器端的用户车牌信息
//     */
//    private void getUpdateCustomersCar() throws Exception {
//        Object[] resultArr = client.invoke("toReturnCustomerCar", SkylotUtils.getStrDate());
//        if (resultArr != null) {
//            if (resultArr[0] != null) {
//                String items = resultArr[0].toString();
//                Map itemList = SingletonObjectMapper.getInstance().readValue(items, Map.class);
//                if (MapUtils.isNotEmpty(itemList)) {
//                    List<Integer> ids = new ArrayList<Integer>();
//                    List addList = (List) MapUtils.getObject(itemList, "add");
//                    List updateList = (List) MapUtils.getObject(itemList, "update");
//                    if (CollectionUtils.isNotEmpty(addList)) {//新增数据
//                        for (int i = 0; i < addList.size(); i++) {
//                            Map o = (Map) addList.get(i);
//                            OftbCustomerCar oftbCustomerCar = OftbCustomerCar.builder().build();
//                            BeanUtils.populate(oftbCustomerCar, o);
//                            daoMap.get("oftbCustomerCarDao").save(oftbCustomerCar);
//                        }
//                    }
//                    if (CollectionUtils.isNotEmpty(updateList)) {//更新数据
//                        for (int i = 0; i < updateList.size(); i++) {
//                            Map o = (Map) updateList.get(i);
//                            OftbCustomerCar oftbCustomerCar = OftbCustomerCar.builder().build();
//                            BeanUtils.populate(oftbCustomerCar, o);
//                            OftbCustomerCarCriteria customerCriteria = new OftbCustomerCarCriteria();
//                            customerCriteria.createCriteria().andOccIdEqualTo(oftbCustomerCar.getOccId());
//                            daoMap.get("oftbCustomerCarDao").updatewithoutNull(oftbCustomerCar, customerCriteria);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取服务器端的实体车位数据
//     */
//    private void getUpdateMathineItem() throws Exception {
//        Object[] resultArr = client.invoke("toReturnMathineItem", GetProperties.getProperties("system.properties", "skylot.machine.id"), SkylotUtils.getStrDate());
//        if (resultArr != null) {
//            if (resultArr[0] != null) {
//                String items = resultArr[0].toString();
//                Map itemList = SingletonObjectMapper.getInstance().readValue(items, Map.class);
//                if (MapUtils.isNotEmpty(itemList)) {
//                    List<Integer> ids = new ArrayList<Integer>();
//                    List addList = (List) MapUtils.getObject(itemList, "add");
//                    List updateList = (List) MapUtils.getObject(itemList, "update");
//                    if (CollectionUtils.isNotEmpty(addList)) {//新增数据
//                        for (int i = 0; i < addList.size(); i++) {
//                            Map o = (Map) addList.get(i);
//                            OftbMathineItem oftbMathineItem = OftbMathineItem.builder().build();
//                            BeanUtils.populate(oftbMathineItem, o);
//                            daoMap.get("oftbMathineItemDao").save(oftbMathineItem);
//                        }
//                    }
//                    if (CollectionUtils.isNotEmpty(updateList)) {//更新数据
//                        for (int i = 0; i < updateList.size(); i++) {
//                            Map o = (Map) updateList.get(i);
//                            OftbMathineItem oftbMathineItem = OftbMathineItem.builder().build();
//                            BeanUtils.populate(oftbMathineItem, o);
//                            OftbMathineItemCriteria criteria = new OftbMathineItemCriteria();
//                            criteria.createCriteria().andOmiIdEqualTo(oftbMathineItem.getOmiId());
//                            daoMap.get("oftbMathineItemDao").updatewithoutNull(oftbMathineItem, criteria);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取服务器端的用户车牌绑定信息
//     */
//    private void getUpdateCustomersItem() throws Exception {
//        Object[] resultArr = client.invoke("toReturnItemCustomer", GetProperties.getProperties("system.properties", "skylot.machine.id"), SkylotUtils.getStrDate());
//        if (resultArr != null) {
//            if (resultArr[0] != null) {
//                String items = resultArr[0].toString();
//                Map itemList = SingletonObjectMapper.getInstance().readValue(items, Map.class);
//                if (MapUtils.isNotEmpty(itemList)) {
//                    List<Integer> ids = new ArrayList<Integer>();
//                    List addList = (List) MapUtils.getObject(itemList, "add");
//                    List updateList = (List) MapUtils.getObject(itemList, "update");
//                    if (CollectionUtils.isNotEmpty(addList)) {//新增数据
//                        for (int i = 0; i < addList.size(); i++) {
//                            Map o = (Map) addList.get(i);
//                            IftbItemCustomer iftbItemCustomer = IftbItemCustomer.builder().build();
//                            BeanUtils.populate(iftbItemCustomer, o);
//                            daoMap.get("iftbItemCustomerDao").save(iftbItemCustomer);
//                        }
//                    }
//                    if (CollectionUtils.isNotEmpty(updateList)) {//更新数据
//                        for (int i = 0; i < updateList.size(); i++) {
//                            Map o = (Map) updateList.get(i);
//                            IftbItemCustomer iftbItemCustomer = IftbItemCustomer.builder().build();
//                            BeanUtils.populate(iftbItemCustomer, o);
//                            IftbItemCustomerCriteria criteria = new IftbItemCustomerCriteria();
//                            criteria.createCriteria().andIicIdEqualTo(iftbItemCustomer.getIicId());
//                            daoMap.get("oftbCustomerCarDao").updatewithoutNull(iftbItemCustomer, criteria);
//                        }
//                    }
//                }
//            }
//        }
//    }

    /**
     * 同步当前设备状态信息到后台
     */
    private void itemStatus() throws Exception {
        ScheduleService scheduleService = (ScheduleService) serviceMap.get("scheduleService");
        IftbScheduleActionCriteria iftbScheduleActionCriteria = new IftbScheduleActionCriteria();
        iftbScheduleActionCriteria.createCriteria().andIsaStatusEqualTo(SCHEDULEACTION_STATUS_PLAN);
        List<IftbScheduleAction> iftbScheduleActions = scheduleService.queryForAll(iftbScheduleActionCriteria);
        List<IftbScheduleAction> list = iftbScheduleActions;
        IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
        criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Iterator<IftbScheduleAction> iterator = list.iterator(); iterator.hasNext(); ) {
                IftbScheduleAction next = iterator.next();
                if (StringUtils.isEmpty(next.getIsaScheduleMessage())) {
                    continue;
                }
                try {
                    wsThreadMgtSend.putCommander(next);
                    String data = sendSync(next);
                    if (StringUtils.equals(data, FN_RETURN_STATUS_SUCCESS)) {
                        iftbMachineAction.setImaStatus(FN_RETURN_STATUS_SUCCESS);
                        iftbScheduleActionCriteria.createCriteria().andIsaIdEqualTo(next.getIsaId());
                        next.setIsaStatus(SCHEDULEACTION_STATUS_FINISH);
                        ((ScheduleService) serviceMap.get("scheduleService")).update(next, iftbScheduleActionCriteria);
                        OftbSyncLogCriteria oftbSyncLogCriteria = new OftbSyncLogCriteria();
                        oftbSyncLogCriteria.createCriteria().andOslTypeEqualTo("0");
//                        if (hasSyncError("0", false)) {
//                            //comparePLC2Local();//上一次有同步失败记录
//                            hasSyncError("0", true);
//                        }
                        iftbMachineAction.setImaPhysicalStatus(FN_RETURN_STATUS_SUCCESS);
                        addSyncError("0");
                    } else {//和SaaS同步失败,放置一条失败的信息
                        addSyncError("2");
                        iftbMachineAction.setImaPhysicalStatus(FN_RETURN_STATUS_ERROR);
                    }
                    if (StringUtils.equals(SCHEDULEACTION_BUSINESSOBJ_MACHINE, next.getIsaBusinessObj())) {//如果是IMA对象的同步
                        serviceMap.get("machineActionService").update(iftbMachineAction, criteria);
                    }

                } catch (Exception e) {//已有队列正在运行e
                    throw new SkyLotException(e);
                } finally {
                    wsThreadMgtSend.getCommands();
                }
            }
        }
    }

    /**
     * 发送请求到SaaS
     *
     * @param iftbScheduleAction
     * @return
     */
    private String sendSync(final IftbScheduleAction iftbScheduleAction) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Integer[] result = {-1};
        FutureTask<Integer> future =
                new FutureTask<Integer>(new Callable<Integer>() {//使用Callable接口作为构造参数
                    public Integer call() throws SkyLotException, IOException, InvocationTargetException, IllegalAccessException {
                        Map maps = new HashMap();
                        maps = SkylotUtils.jsonToMap(iftbScheduleAction.getIsaScheduleMessage());
                        String url = GetProperties.getProperties("system.properties", "skylot.webservice.parking");
                        if (StringUtils.equals(iftbScheduleAction.getIsaBusinessObj(), SCHEDULEACTION_BUSINESSOBJ_MACHINE)) {

                            url = GetProperties.getProperties("system.properties", "skylot.webservice.heartbeat");
                        }
                        result[0] = NumberUtils.toInt(HttpClientUtil.getInstance()
                                .sendHttpPost(url, maps));
                        return result[0];
                    }
                });
        executor.execute(future);
        try {
            result[0] = future.get(NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.machine.operation.timeout")), TimeUnit.SECONDS); //取得结果，同时设置超时执行时间为系统预定义时间。
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            future.cancel(true);
        } catch (TimeoutException e) {
            log.warn("超时了!!!" + iftbScheduleAction.toString());
            future.cancel(true);
            wsThreadMgtSend.getCommands();
            return FN_RETURN_STATUS_HANDLE;
        } finally {
            executor.shutdown();

        }
        if (result[0].intValue() == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            return FN_RETURN_STATUS_SUCCESS;
        } else {
            return FN_RETURN_STATUS_ERROR;
        }
    }

    /**
     * 比较本地库和PLC返回的停车记录,更新本地停车记录为PLC的停车记录
     */
    private void comparePLC2Local() throws Exception {
        Map mapPLC = socketService.getParkingStatus(1);
        Map mapDB = socketService.getParkingStatus(0);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> itPLC = mapPLC.entrySet().iterator();
        Iterator<Map.Entry<Integer, String>> itDB = mapDB.entrySet().iterator();
        List missedCar = Lists.newArrayList();
        while (itDB.hasNext()) {
            Map.Entry<Integer, String> pairDB = itDB.next();
            boolean find = false;
            while (itPLC.hasNext()) {
                Map.Entry<Integer, String> pairPLC = itPLC.next();
                if (pairPLC.getKey().equals(pairDB.getKey())) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                missedCar.add(pairDB.getKey() + "");
            }
        }
        if (CollectionUtils.isNotEmpty(missedCar)) {//PLC没有的停车记录
            TstbMathineParkingCriteria criteria = new TstbMathineParkingCriteria();
            criteria.createCriteria().andTmpPhysicalCodeIn(missedCar);
            List<TstbMathineParking> missList = serviceMap.get("parkingService").queryForAll(criteria);
            if (CollectionUtils.isNotEmpty(missList)) {
                for (int i = 0; i < missList.size(); i++) {
                    TstbMathineParking tstbMathineParking = missList.get(i);
                    TstbMathineParkingLog tstbMathineParkingLog = TstbMathineParkingLog.builder().build();
                    tstbMathineParkingLog.setImaId(SkylotUtils.imaId);
                    tstbMathineParkingLog.setTmplCar(tstbMathineParking.getTmpCarCode());
                    tstbMathineParkingLog.setTmplCreatedate(SkylotUtils.getStrDate());
                    tstbMathineParkingLog.setTmplPhysicalCode(tstbMathineParking.getTmpPhysicalCode());
                    tstbMathineParkingLog.setTmplCreateuser("system");
                    tstbMathineParkingLog.setTmplType(MACHINEPARKING_TYPE_TAKE);
                    tstbMathineParkingLog.setTmplStatus(PARKING_PULLING_STATUS_FINISH);
                    this.daoMap.get("tstbMathineParkingLogDao").save(tstbMathineParkingLog);
                    CommandSchedule();
                }
            }
        }
    }

    /**
     * 新增一条错误待同步信息,如果没有error,新增一条
     *
     * @param errorType 0:正常数据,1:错误数据
     * @throws Exception
     */
    public void addSyncError(String errorType) throws Exception {
        OftbSyncLog oftbSyncLog = OftbSyncLog.builder().build();
        oftbSyncLog.setOslStatus(FN_RETURN_STATUS_ERROR);
        oftbSyncLog.setOslCreatedate(SkylotUtils.getStrDate());
        oftbSyncLog.setOslType(errorType);
        OftbSyncLogCriteria oftbSyncLogCriteria = new OftbSyncLogCriteria();
        oftbSyncLogCriteria.createCriteria().andOslTypeEqualTo(errorType);
        List errorList = this.daoMap.get("oftbSyncLogDao").ReadAll(oftbSyncLogCriteria);
        if (CollectionUtils.isEmpty(errorList) || StringUtils.equals(errorType, FN_RETURN_STATUS_SUCCESS)) {
            this.daoMap.get("oftbSyncLogDao").save(oftbSyncLog);
        }
    }

    /**
     * 是否有错误信息
     *
     * @param errorType
     * @return
     * @throws Exception
     */
    public boolean hasSyncError(String errorType, boolean... compareDate) throws Exception {
        OftbSyncLogCriteria oftbSyncLogCriteria = new OftbSyncLogCriteria();
        OftbSyncLogCriteria.Criteria criteria = oftbSyncLogCriteria.createCriteria();
        if (compareDate.length > 0) {
            criteria.andOslCreatedateLessThan(DateFormatUtils.format(DateUtils.addMinutes(new Date(), -2), DATE_FORMAT_STANDARD));
            // TODO: 05/02/2018 查找5分钟之前是否有同步失败的信息,如有则反馈SaaS,当前设备故障
        }
        List oftbSyncLogDao = this.daoMap.get("oftbSyncLogDao").ReadAll(oftbSyncLogCriteria);
        if (CollectionUtils.isNotEmpty(oftbSyncLogDao)) {
            OftbSyncLog errorList = (OftbSyncLog) oftbSyncLogDao.get(0);
            if (errorList != null) {
                if (errorList.getOslType().equals(errorType)) {
                    return true;
                }
            }
        }
        return false;
    }
}
