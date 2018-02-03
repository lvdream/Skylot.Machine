import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingLogDAO;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingLog;
import com.fangda.skylot.mathine.scheduler.springtask.SyncFTPUtil;
import com.fangda.skylot.mathine.scheduler.springtask.SyncParkingLogicServer;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.impl.SocketServiceImpl;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.DateUtil;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.ftp.FtpUtils;
import com.fangda.skylot.mathine.utils.math.ParkingLogic;
import com.fangda.skylot.mathine.utils.socket.BaseCommanderMarquee;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.MACHINEPARKING_TYPE_TAKE;
import static com.fangda.skylot.mathine.utils.constant.Constant.PARKING_PULLING_STATUS_FINISH;

/**
 * Created by Saul on 11/29/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@Slf4j
public class TestU {
    private static int produceTaskSleepTime = 10;
    @Autowired
    private Map<String, IBaseService> serviceMap;
    private static int produceTaskMaxNumber = 1000;
    @Autowired
    private SyncService syncServiceImpl;
    @Autowired
    private FtpUtils ftpUtils;
    @Autowired
    private SocketServiceImpl socketService;
    @Autowired
    private SyncParkingLogicServer syncParkingLogicServer;
    @Autowired
    private SyncFTPUtil syncFTPUtil;
    @Autowired
    private Map<String, IBaseDao> daoMap;
    @Autowired
    private BaseCommanderMarquee baseCommanderMarquee;

    private static double EARTH_RADIUS = 6378.137;// 单位千米

    private static double getRadian(double degree) {
        return degree * Math.PI / 180.0;
    }

    @Test
    @Ignore
    public void test3() {
        ParkingLogic parkingLogic = new ParkingLogic();
        List<Integer> LeftNumbers = ListUtils.sum(parkingLogic.getRightPositionNumber(NumberUtils.toInt("5"), 0), parkingLogic.getRightPositionNumber(NumberUtils.toInt("5"), 2));
        parkingLogic.setBaseNum("5");
        System.out.println(ArrayUtils.contains(LeftNumbers.toArray(), 3));
        System.out.println(parkingLogic.getTopNum());
        System.out.println(parkingLogic.getRightPositionNumber(NumberUtils.toInt("11"), 0));
        System.out.println(parkingLogic.getRightPositionNumber(NumberUtils.toInt("11"), 2));
        System.out.println(LeftNumbers);
    }

//    @Test
//    @Ignore
//    public void test4() {
//        ParkingLogService parkingLogService = (ParkingLogService) serviceMap.get("parkinglogService");
//        TstbMathineParkingLogCriteria criteria = new TstbMathineParkingLogCriteria();
//        criteria.createCriteria().andTmplCreatedateGreaterThanOrEqualTo(DateFormatUtils.format(DateUtils.addDays(new Date(), -11), DATE_FORMAT_STANDARD)).andTmplCreatedateLessThanOrEqualTo(SkylotUtils.getStrDate());//// TODO: 2017/6/25 默认抓取PLC同步时间是当前时间减去一分钟之内的时间区间
//        List quaryList = parkingLogService.queryForAll(criteria);
//        if (CollectionUtils.isNotEmpty(quaryList)) {
//            Map scheduleMap = new HashMap();
//            scheduleMap.put(SCHEDULEACTION_TYPE_HEARTBEAT, SCHEDULEACTION_TYPE_HEARTBEAT_SERVER);
//            scheduleMap.put(SCHEDULEACTION_TYPE_ITEM, "0");
//            try {
//                scheduleMap.put(SCHEDULEACTION_MESSAGE, SingletonObjectMapper.getInstance().writeValueAsString(quaryList));
//                ScheduleService scheduleService = (ScheduleService) serviceMap.get("scheduleService");
//                //01.删除已经同步完成的对象
//
//                IftbScheduleActionCriteria iftbScheduleActionCriteria = new IftbScheduleActionCriteria();
//                iftbScheduleActionCriteria.createCriteria().andIsaStatusEqualTo(SCHEDULEACTION_STATUS_FINISH);
//                scheduleService.delete(iftbScheduleActionCriteria);
//
//                //02.更新心跳
//                IftbScheduleAction iftbScheduleAction = IftbScheduleAction.builder().build();
//                iftbScheduleAction.setIsaUpdatedate(SkylotUtils.getStrDate());
//                iftbScheduleAction.setIsaCreatedate(SkylotUtils.getStrDate());
//                iftbScheduleAction.setIsaStatus(SCHEDULEACTION_TYPE_ADD);
//                iftbScheduleAction.setIsaModuleId(GetProperties.getProperties("system.properties", "skylot.machine.id"));
//                iftbScheduleAction.setIsaScheduleDate(SkylotUtils.getStrDate());
//                iftbScheduleAction.setIsaScheduleType(MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_HEARTBEAT, ""));
//                iftbScheduleAction.setIsaItemId(MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_ITEM));
//                iftbScheduleAction.setIsaBusinessObj(SCHEDULEACTION_BUSINESSOBJ_MACHINE);
//                iftbScheduleAction.setIsaScheduleMessage(MapUtils.getString(scheduleMap, SCHEDULEACTION_MESSAGE));
//                if (MapUtils.getString(scheduleMap, SCHEDULEACTION_TYPE_HEARTBEAT, "").equals(SCHEDULEACTION_TYPE_HEARTBEAT_PLC)) {
//                    iftbScheduleActionCriteria.clear();
//                    iftbScheduleActionCriteria.createCriteria().andIsaScheduleTypeEqualTo(SCHEDULEACTION_TYPE_HEARTBEAT_PLC).andIsaUpdatedateLessThan(SkylotUtils.getStrDate());
//                    IftbScheduleAction fromdb = scheduleService.query(iftbScheduleActionCriteria);
//                    if (fromdb == null) {
//                        scheduleService.add(iftbScheduleAction);
//                    } else {
//                        iftbScheduleAction.setIsaId(fromdb.getIsaId());
//                        iftbScheduleAction.setIsaScheduleMessage(SingletonObjectMapper.getInstance().writeValueAsString(iftbScheduleAction));
//                        iftbScheduleAction.setIsaCreatedate(null);
//                        scheduleService.update(iftbScheduleAction, iftbScheduleActionCriteria);
//                    }
//                } else {
//                    scheduleService.add(iftbScheduleAction);
//                }
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = getRadian(lat1);
        double radLat2 = getRadian(lat2);
        System.out.println(radLat1);
        System.out.println(radLat2);
        double a = radLat1 - radLat2;// 两点纬度差
        System.out.println(a);
        double b = getRadian(lng1) - getRadian(lng2);// 两点的经度差
        System.out.println(b);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        System.out.println(Math.sin(a / 2));
        System.out.println(Math.pow(Math.sin(a / 2), 2));
        System.out.println(Math.sqrt(Math.pow(Math.sin(a / 2), 2)));
        System.out.println(Math.cos(radLat1));
        System.out.println(Math.cos(radLat2));
        System.out.println(Math.cos(radLat1) * Math.cos(radLat2));
        System.out.println(Math.sin(b / 2));
        System.out.println(Math.pow(Math.sin(b / 2), 2));
        System.out.println(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        System.out.println(2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2))));
        s = s * EARTH_RADIUS;
        return s * 1000;
    }

    @Test
//    @Ignore
    public void Test() throws IOException, SkyLotException {
//        String com = "FE 5C 4B 89 41 00 00 00 61 00 00 00 00 2E 00 00 00 05 00 00 08 00 05 03 09 23 30 30 33 32 23 30 30 31 36 23 31 23 36 36 23 31 23 30 23 30 23 30 30 23 35 37 3B 2F 38 31 32 34 32 23 30 30 23 FF FF";
//        baseCommanderMarquee.run(com);
//        ParkingLogic parkingLogic = new ParkingLogic();
//        parkingLogic.setActionDirect(2);
//        socketService.doDirection(1,parkingLogic);
//        socketService.getHighErrorStatus();
        for (int i = 1; i <= 12; i++) {
            socketService.getParkingStatus(1);
            log.warn("未取车,当前车板停车状态:" + socketService.getValueMap());
            if (socketService.confirmStatus(2) == 0) {
                log.warn("当前取车位置:" + (i));
                ParkingLogic parkingLogic = new ParkingLogic();
                parkingLogic.setActionDirect(1);
                socketService.PullCar((i), parkingLogic);
                socketService.getEnergy();
                log.warn("运作电量:" + socketService.getDirectionEnergy());
                log.warn("取车完成");
                log.warn("取车总耗时:" + (socketService.getDirectionBeforeTime() + socketService.getFinishParkingTime() + socketService.getDirectionAfterTime()) / 1000);
                log.warn("取车耗时:" + (socketService.getFinishParkingTime()) / 1000);
                log.warn("取车旋转耗时:" + (socketService.getDirectionBeforeTime()) / 1000);
                log.warn("取车荷载耗时:" + (socketService.getDirectionAfterTime()) / 1000);
                socketService.getParkingStatus(1);
                log.warn("已取车,当前车板停车状态:" + socketService.getValueMap());
            }

        }
//        socketService.confirmStatus(2);
//        socketService.carDoor("0");
//        socketService.peopleDoor("0");
//        String s = "{\"data\":{\"machineStatus\":\"0\"},\"error\":[],\"resultType\":true,\"resultType2\":null}";
//        String w = "4|沪HW5998|1|41532ea88c964c83917a76936f1e618d|7|507835|2018-02-18 00:00:00";
//        System.out.println(BaseCommandUtils.encode(w));
//        socketService.carDoor("0");
//        System.out.println(SkylotUtils.verifyCode(BaseCommandUtils.encode(w)));
//        try {
//            System.out.println(SingletonObjectMapper.getInstance().readValue(s, Map.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        code.doErrorLogic(new JsonResult(), Maps.newHashMap(),"request.user.parking.1005");
//        for (int i = 7; i <= 12; i++) {
//            socketService.getParkingStatus();
//            log.warn("未停车,当前车板停车状态:" + socketService.getValueMap());
//            if (socketService.confirmStatus(2) == 0) {
//                socketService.doParking("粤B00001");
//                log.warn("停车完成");
//                log.warn("停车总耗时:" + (socketService.getDirectionBeforeTime() + socketService.getFinishParkingTime() + socketService.getDirectionAfterTime()) / 1000);
//                log.warn("停车旋转耗时:" + (socketService.getDirectionBeforeTime()) / 1000);
//                log.warn("停车荷载耗时:" + (socketService.getDirectionAfterTime()) / 1000);
//                socketService.getParkingStatus();
//                log.warn("已停车,当前车板停车状态:" + socketService.getValueMap());
////                socketService.ParkingCar(i, "粤B00001");
//            }
//
//        }
    }

    @Test
    @Ignore
    public void Test2() throws Exception {
        TstbMathineParkingLog tstbMathineParkingLog = TstbMathineParkingLog.builder().build();
        tstbMathineParkingLog.setImaId("2222");
        tstbMathineParkingLog.setTmplCreatedate(DateUtil.getNowDate());
        tstbMathineParkingLog.setTmplCar("2222");
        tstbMathineParkingLog.setTmplPhysicalCode("2222");
        tstbMathineParkingLog.setTmplCustomer("2222");
        tstbMathineParkingLog.setTmplType(MACHINEPARKING_TYPE_TAKE);
        tstbMathineParkingLog.setTmplStatus(PARKING_PULLING_STATUS_FINISH);
        tstbMathineParkingLog.setTmplDiectionCode("2");
        tstbMathineParkingLog.setTmplOperationDuriationTotal("2222");
        tstbMathineParkingLog.setTmplOperationDuriationRouting("2222");
        tstbMathineParkingLog.setTmplOperationDuriationManually("2222");
        tstbMathineParkingLog.setTmplOperationDuriationWeighting("2222");
        tstbMathineParkingLog.setTmplOperationEnergyCost("2222");
        ((TstbMathineParkingLogDAO) this.daoMap.get("tstbMathineParkingLogDao")).save(tstbMathineParkingLog);
//        for (int i = 1; i <= 12; i++) {
//            socketService.getParkingStatus();
//            log.warn("未取车,当前车板停车状态:" + socketService.getValueMap());
//            if (socketService.confirmStatus(2) == 0) {
//                log.warn("当前取车位置:" + (i));
//                ParkingLogic parkingLogic = new ParkingLogic();
//                parkingLogic.setActionDirect(1);
//                socketService.PullCar((i), parkingLogic);
//                socketService.getEnergy();
//                log.warn("运作电量:" + socketService.getDirectionEnergy());
//                log.warn("取车完成");
//                log.warn("取车总耗时:" + (socketService.getDirectionBeforeTime() + socketService.getFinishParkingTime() + socketService.getDirectionAfterTime()) / 1000);
//                log.warn("取车耗时:" + (socketService.getFinishParkingTime()) / 1000);
//                log.warn("取车旋转耗时:" + (socketService.getDirectionBeforeTime()) / 1000);
//                log.warn("取车荷载耗时:" + (socketService.getDirectionAfterTime()) / 1000);
//                socketService.getParkingStatus();
//                log.warn("已取车,当前车板停车状态:" + socketService.getValueMap());
//            }
//
//        }
    }

    //    @Test
//    public void test5() throws Exception {
//        ScheduleService scheduleService = (ScheduleService) serviceMap.get("scheduleService");
//        IftbScheduleActionCriteria iftbScheduleActionCriteria = new IftbScheduleActionCriteria();
//        iftbScheduleActionCriteria.createCriteria().andIsaStatusEqualTo(SCHEDULEACTION_STATUS_PLAN);
//        List<IftbScheduleAction> iftbScheduleActions = scheduleService.queryForAll(iftbScheduleActionCriteria);
//        List<IftbScheduleAction> list = iftbScheduleActions;
//        if (CollectionUtils.isNotEmpty(list)) {
//            DynamicClientFactory factory = DynamicClientFactory.newInstance();
//            String wsdlUrl = GetProperties.getProperties("system.properties", "skylot.webservice.parking");
//            Client client = factory.createClient(wsdlUrl);
//
//            for (Iterator<IftbScheduleAction> iterator = list.iterator(); iterator.hasNext(); ) {
//                IftbScheduleAction next = iterator.next();
//                Object[] resultArr = null;
//                if (next.getIsaScheduleType().equals(SCHEDULEACTION_TYPE_HEARTBEAT_SERVER)) {//停取车同步
//                    resultArr = client.invoke("receiveParkingLog", next.getIsaScheduleMessage());
//                } else if (next.getIsaScheduleType().equals(SCHEDULEACTION_TYPE_HEARTBEAT_PLC)) {//心跳
//                    if (StringUtils.isEmpty(next.getIsaScheduleMessage())) {
//                        continue;
//                    }
//                    resultArr = client.invoke("receiveSchedule", next.getIsaScheduleMessage());
//                }
//                if (resultArr != null) {
//                    if (resultArr[0] != null) {
//                        if (StringUtils.equals(FN_RETURN_STATUS_SUCCESS, resultArr[0].toString())) {//同步成功
//                            next.setIsaStatus(SCHEDULEACTION_STATUS_FINISH);
//                            scheduleService.update(next);
//                        } else if (StringUtils.equals(FN_RETURN_STATUS_EXCEPTION, resultArr[0].toString())) {
//                            next.setIsaStatus(SCHEDULEACTION_STATUS_ERROR);
//                            scheduleService.update(next);
//                        }
//                    }
//                }
//            }
//        }
//    }
    @Test
    @Ignore
    public void test4() throws SkyLotException {
        socketService.getHighErrorStatus();
        log.warn(socketService.getStringBuilder().toString());
        log.warn(socketService.getStringBuilderto().toString());
        log.warn(socketService.getValueMap().toString());
        log.warn(socketService.getValueMapAppend().toString());
    }

    @Test
    @Ignore
    public void test6() throws SkyLotException {
//        System.out.println(getDistance(31.86, 117.27, 30.26, 120.19) + "");

//        log.info();
    }

    @Test
    @Ignore
    public void testLog4j() throws SkyLotException {
        int a = 0;
        try {
            List<String> stringList = new ArrayList<String>();
//            stringList.add("1431201308_沪HW5998");
            stringList.add("1430531908_黑GW0M30");
            ftpUtils.removeFile("1430531908_黑GW0M30");
//            syncFTPUtil.ftp();
//            System.out.println(a / 0);
        } catch (Exception e) {
            throw new SkyLotException(e);
        } finally {
            System.out.println(2);
//
        }
    }
}
