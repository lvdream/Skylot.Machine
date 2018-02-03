package com.fangda.skylot.mathine.service.impl.customer;

//@Service("WFServiceSkylotMachine")
//public class CustomerWSImpl extends BaseServiceImpl<MstbCustomer, MstbCustomerCriteria> implements CustomerWS {

//    @Autowired
//    private MstbCustomerDAO mstbCustomerDao;
//    @Autowired
//    private OftbMathineItemDAO oftbMathineItemDao;
//    @Autowired
//    private IftbItemCustomerDAO iftbItemCustomerDao;
//    @Autowired
//    private SyncLogService syncLogService;
//    @Autowired
//    private TstbMathineParkingDAO tstbMathineParkingDao;
//    @Autowired
//    private IftbMachineActionDAO iftbMachineActionDao;
//    @Autowired
//    private TstbMathineParkingLogDAO tstbMathineParkingLogDao;
//
//
//    @Override
//    public int toSyncCustomerData(String cus, String omi, String maCus, String ima, String tmp, String key) throws SkyLotException {
//        int result = -1;
//        List<LinkedHashMap> mapList = null;
//        try {
//            //判断key是否正确
//            if (true) {
//                OftbSyncLog osl = new OftbSyncLog();
//                //同步客户信息
//                List<MstbCustomer> customerList = new ArrayList<MstbCustomer>();
//                mapList = SingletonObjectMapper.getInstance().readValue(cus, List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        MstbCustomer example = new MstbCustomer();
//                        BeanUtils.populate(example, linkedHashMap);
//                        customerList.add(example);
//                    }
//                }
//
//                for (MstbCustomer mCustomer : customerList) {
//                    MstbCustomer mc = (MstbCustomer) this.mstbCustomerDao.ReadByID(mCustomer.getMcId());
//                    if (mc != null) {
//                        mc.setMcCode(mCustomer.getMcCode());
//                        mc.setMcCreatedate(mCustomer.getMcCreatedate());
//                        mc.setMcCreateuser(mCustomer.getMcCreateuser());
//                        mc.setMcId(mCustomer.getMcId());
//                        mc.setMcMobile(mCustomer.getMcMobile());
//                        mc.setMcNameCn(mCustomer.getMcNameCn());
//                        mc.setMcPass(mCustomer.getMcPass());
//                        mc.setMcStatus(mCustomer.getMcStatus());
//                        mc.setMcType(mCustomer.getMcType());
//                        mc.setMcUpdatedate(mCustomer.getMcUpdatedate());
//                        mc.setMcUpdateuser(mCustomer.getMcUpdateuser());
//                        mc.setMcVerifyCode(mCustomer.getMcVerifyCode());
//                        this.mstbCustomerDao.update(mc);
//                    } else {
//                        this.mstbCustomerDao.save(mCustomer);
//                    }
//                }
//                osl.setOslCount(customerList.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("2");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//                //同步车牌
//                List<OftbCustomerCar>customerCarsList=new ArrayList<OftbCustomerCar>();
//                mapList=SingletonObjectMapper.getInstance().readValue(key,List.class);
//                if(CollectionUtils.isNotEmpty(mapList)){
//                    for(LinkedHashMap linkedHashMap : mapList){
//                        OftbCustomerCar example=new OftbCustomerCar();
//                        BeanUtils.populate(example,linkedHashMap);
//                        customerCarsList.add(example);
//                    }
//                }
//                for(OftbCustomerCar oftbCustomerCar:customerCarsList){
//                    OftbCustomerCar oftbCustomerCar1=(OftbCustomerCar)this.oftbCustomerCarDao.ReadByID(oftbCustomerCar.getOccId());
//                    if(oftbCustomerCar1 != null){
//                        oftbCustomerCar1.setMcId(oftbCustomerCar.getMcId());
//                        oftbCustomerCar1.setOccName(oftbCustomerCar.getOccName());
//                        oftbCustomerCar1.setOccCode(oftbCustomerCar.getOccCode());
//                        oftbCustomerCar1.setOccType(oftbCustomerCar.getOccType());
//                        oftbCustomerCar1.setOccStatus(oftbCustomerCar.getOccStatus());
//                        oftbCustomerCar1.setOccCreateuser(oftbCustomerCar.getOccCreateuser());
//                        oftbCustomerCar1.setOccCreatedate(oftbCustomerCar.getOccCreatedate());
//                        this.oftbCustomerCarDao.update(oftbCustomerCar1);
//
//                    }else {
//                        this.oftbCustomerCarDao.save(oftbCustomerCar);
//                    }
//
//                }
//                osl.setOslCount(customerCarsList.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("2");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//                //同步设备车位信息
//                List<OftbMathineItem> machineList = new ArrayList<OftbMathineItem>();
//                mapList = SingletonObjectMapper.getInstance().readValue(omi, List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        OftbMathineItem oftbMathineItem = OftbMathineItem.builder().build();
//                        BeanUtils.populate(oftbMathineItem, linkedHashMap);
//                        machineList.add(oftbMathineItem);
//                    }
//                }
//                for (OftbMathineItem oftbMathineItem : machineList) {
//                    OftbMathineItem oftbMathineItem1 = (OftbMathineItem) this.oftbMathineItemDao.ReadByID(oftbMathineItem.getOmiId());
//                    if (oftbMathineItem1 != null) {
//                        oftbMathineItem1.setImaId(oftbMathineItem.getImaId());
//                        oftbMathineItem1.setOmiCode(oftbMathineItem.getOmiCode());
//                        oftbMathineItem1.setOmiCreatedate(oftbMathineItem.getOmiCreatedate());
//                        oftbMathineItem1.setOmiCreateuser(oftbMathineItem.getOmiCreateuser());
//                        oftbMathineItem1.setOmiEnddate(oftbMathineItem.getOmiEnddate());
//                        oftbMathineItem1.setOmiId(oftbMathineItem.getOmiId());
//                        oftbMathineItem1.setOmiName(oftbMathineItem.getOmiName());
//                        oftbMathineItem1.setOmiPhysicalCode(oftbMathineItem.getOmiPhysicalCode());
//                        oftbMathineItem1.setOmiRate(oftbMathineItem.getOmiRate());
//                        oftbMathineItem1.setOmiStartdate(oftbMathineItem.getOmiStartdate());
//                        oftbMathineItem1.setOmiStatus(oftbMathineItem.getOmiStatus());
//                        oftbMathineItem1.setOmiUpdatedate(oftbMathineItem.getOmiUpdatedate());
//                        oftbMathineItem1.setOmiUpdateuser(oftbMathineItem.getOmiUpdateuser());
//                        this.oftbMathineItemDao.update(oftbMathineItem1);
//                    } else {
//                        this.oftbMathineItemDao.save(oftbMathineItem);
//                    }
//
//                }
//                osl.setOslCount(machineList.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("2");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//                //同步客户绑定车位信息
//                List<IftbItemCustomer> iftbItemCustomerList = new ArrayList<IftbItemCustomer>();
//                mapList = SingletonObjectMapper.getInstance().readValue(maCus, List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        IftbItemCustomer iftbItemCustomer = new IftbItemCustomer();
//                        BeanUtils.populate(iftbItemCustomer, linkedHashMap);
//                        iftbItemCustomerList.add(iftbItemCustomer);
//                    }
//                }
//                for (IftbItemCustomer iftbItemCustomer : iftbItemCustomerList) {
//                    IftbItemCustomer iic = (IftbItemCustomer) this.iftbItemCustomerDao.ReadByID(iftbItemCustomer.getIicId());
//                    if (iic != null) {
//                        iic.setIicCost(iftbItemCustomer.getIicCost());
//                        iic.setIicCreatedate(iftbItemCustomer.getIicCreatedate());
//                        iic.setIicCreateuser(iftbItemCustomer.getIicCreateuser());
//                        iic.setIicEnddate(iftbItemCustomer.getIicEnddate());
//                        iic.setIicFormula(iftbItemCustomer.getIicFormula());
//                        iic.setIicId(iftbItemCustomer.getIicId());
//                        iic.setIicStartdate(iftbItemCustomer.getIicStartdate());
//                        iic.setIicUpdatedate(iftbItemCustomer.getIicUpdatedate());
//                        iic.setIicUpdateuser(iftbItemCustomer.getIicUpdateuser());
//                        iic.setIiicStatus(iftbItemCustomer.getIiicStatus());
//                        iic.setMcId(iftbItemCustomer.getMcId());
//                        iic.setOmiId(iftbItemCustomer.getOmiId());
//                        this.iftbItemCustomerDao.update(iic);
//                    } else {
//                        this.iftbItemCustomerDao.save(iftbItemCustomer);
//                    }
//
//                }
//                osl.setOslCount(iftbItemCustomerList.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("1");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//                //同步设备信息
//                List<IftbMachineAction> iftbMachineActions = new ArrayList<IftbMachineAction>();
//                mapList = SingletonObjectMapper.getInstance().readValue(ima, List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
//                        BeanUtils.populate(iftbMachineAction, linkedHashMap);
//                        iftbMachineActions.add(iftbMachineAction);
//                    }
//                }
//                for (IftbMachineAction iftbMachineAction : iftbMachineActions) {
//                    IftbMachineAction iftbMachineAction1 = (IftbMachineAction) this.iftbMachineActionDao.ReadByID(iftbMachineAction.getImaId());
//                    if (iftbMachineAction1 != null) {
//                        iftbMachineAction1.setImaId(iftbMachineAction.getImaId());
//                        iftbMachineAction1.setMmId(iftbMachineAction.getMmId());
//                        iftbMachineAction1.setMaId(iftbMachineAction.getMaId());
//                        iftbMachineAction1.setImaStatus(iftbMachineAction.getImaStatus());
//                        iftbMachineAction1.setImaAddress(iftbMachineAction.getImaAddress());
//                        iftbMachineAction1.setImaCode(iftbMachineAction.getImaCode());
//                        iftbMachineAction1.setImaName(iftbMachineAction.getImaName());
//                        iftbMachineAction1.setImaPort(iftbMachineAction.getImaPort());
//                        iftbMachineAction1.setImaCreatetime(iftbMachineAction.getImaCreatetime());
//                        iftbMachineAction1.setImaCreateuser(iftbMachineAction.getImaCreateuser());
//                        iftbMachineAction1.setImaUpdatetime(iftbMachineAction.getImaUpdatetime());
//                        iftbMachineAction1.setImaUpdateuser(iftbMachineAction.getImaUpdateuser());
//                        this.iftbMachineActionDao.update(iftbMachineAction1);
//                    } else {
//                        this.iftbMachineActionDao.save(iftbMachineAction);
//                    }
//                }
//                osl.setOslCount(iftbMachineActions.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("1");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//                //同步停车信息
//                List<TstbMathineParking> tstbMathineParkings = new ArrayList<TstbMathineParking>();
//                mapList = SingletonObjectMapper.getInstance().readValue(tmp, List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        TstbMathineParking tstbMathineParking = TstbMathineParking.builder().build();
//                        BeanUtils.populate(tstbMathineParking, linkedHashMap);
//                        tstbMathineParkings.add(tstbMathineParking);
//                    }
//                }
//                for (TstbMathineParking tstbMathineParking : tstbMathineParkings) {
//                    TstbMathineParking tstbMathineParking1 = (TstbMathineParking) this.tstbMathineParkingDao.ReadByID(tstbMathineParking.getTmpId());
//                    if (tstbMathineParking1 != null) {
//                        tstbMathineParking1.setTmpId(tstbMathineParking1.getTmpId());
//                        tstbMathineParking1.setImaId(tstbMathineParking1.getImaId());
//                        tstbMathineParking1.setTmpCarCode(tstbMathineParking.getTmpCarCode());
//                        tstbMathineParking1.setTmpCode(tstbMathineParking.getTmpCode());
//                        tstbMathineParking1.setTmpPhysicalCode(tstbMathineParking.getTmpPhysicalCode());
//                        tstbMathineParking1.setTmpStatus(tstbMathineParking.getTmpStatus());
//                        tstbMathineParking1.setTmpCreatedate(tstbMathineParking.getTmpCreatedate());
//                        tstbMathineParking1.setTmpCreateuser(tstbMathineParking.getTmpCreateuser());
//                        tstbMathineParking1.setTmpUpdatedate(tstbMathineParking.getTmpUpdatedate());
//                        tstbMathineParking1.setTmpUpdateuser(tstbMathineParking.getTmpUpdateuser());
//                        this.tstbMathineParkingDao.update(tstbMathineParking1);
//                    } else {
//                        this.tstbMathineParkingDao.save(tstbMathineParking);
//                    }
//                }
//                osl.setOslCount(tstbMathineParkings.size());
//                osl.setOslCreatedate(DateUtil.getNowDate());
//                osl.setOslStatus("0");
//                osl.setOslType("1");
//                osl.setOslUpdatedate(DateUtil.getNowDate());
//                this.syncLogService.saveLog(osl);
//            }
//
//            result = 0;
//        } catch (Exception e) {
//            throw new SkyLotException("CustomerWSImpl - Exception:toSyncCustomerData", e.getCause());
//        }
//        return result;
//    }
//
//    @Override
//    public int toSyncCustomerCar(String cus) throws SkyLotException {
//        int result = -1;
//        try {
//            List<OftbCustomerCar> occList = new ArrayList<OftbCustomerCar>();
//            List<LinkedHashMap> mapList = SingletonObjectMapper.getInstance().readValue(cus, List.class);
//            if (CollectionUtils.isNotEmpty(mapList)) {
//                for (LinkedHashMap linkedHashMap : mapList) {
//                    OftbCustomerCar example = new OftbCustomerCar();
//                    BeanUtils.populate(example, linkedHashMap);
//                    occList.add(example);
//                }
//            }
//            for (OftbCustomerCar occ : occList) {
//                OftbCustomerCar oftbCustomerCar = (OftbCustomerCar) this.oftbCustomerCarDao.ReadByID(occ.getOccId());
//                if (oftbCustomerCar != null) {
//                    oftbCustomerCar.setMcId(occ.getMcId());
//                    oftbCustomerCar.setOccCode(occ.getOccCode());
//                    oftbCustomerCar.setOccId(occ.getOccId());
//                    oftbCustomerCar.setOccName(occ.getOccName());
//                    oftbCustomerCar.setOccType(occ.getOccType());
//                    oftbCustomerCar.setOccStatus(occ.getOccStatus());
//                    oftbCustomerCar.setOccCreateuser(occ.getOccCreateuser());
//                    oftbCustomerCar.setOccCreatedate(occ.getOccCreatedate());
//                    oftbCustomerCar.setOccUpdateuser(occ.getOccUpdateuser());
//                    oftbCustomerCar.setOccUpdatedate(occ.getOccUpdatedate());
//                    this.oftbCustomerCarDao.update(oftbCustomerCar);
//                } else {
//                    this.oftbCustomerCarDao.save(occ);
//                }
//            }
//            result = 0;
//        } catch (Exception e) {
//            throw new SkyLotException("CustomerWSImpl - Exception:toSyncCustomerCar", e.getCause());
//        }
//        return result;
//    }
//
//
//    @Override
//    public String toPulling(String cusId, String carId, String maId, String key) throws SkyLotException {
//        String returnStr = "-1";
//        List tmpList = null;
//        try {
//            // 判断key是否正确
//            if (true) {
//                TstbMathineParking tmp = null;
//                // 查询汽车信息
//                OftbCustomerCar occ = (OftbCustomerCar) this.oftbCustomerCarDao.ReadByID(Integer.valueOf(carId));
//                if (null != occ) {
//                    TstbMathineParkingCriteria tstbMathineParkingCriteria = new TstbMathineParkingCriteria();
//                    TstbMathineParkingCriteria.Criteria tmpCriteria = tstbMathineParkingCriteria.createCriteria();
//                    tmpCriteria.andTmpCarCodeLike(occ.getOccCode());
////                    tmpList = this.tstbMathineParkingDao.readByCode(tstbMathineParkingCriteria);
//                } else {
//                    return Constant.EX_PULLING_NO_CAR_IN_SEARCH;
//                }
//
//                if (CollectionUtils.isEmpty(tmpList)) {
//                    return Constant.EX_PULLING_NO_CAR_IN_SEARCH;
//                } else {
//                    tmp = (TstbMathineParking) tmpList.get(0);
//                }
//
//                // 查询设备与物业关系
//                IftbMachineAction ima = (IftbMachineAction) this.iftbMachineActionDao.ReadByID(Integer.valueOf(maId));
//                if (ima != null) {
//                    if (StringUtils.equals(ima.getImaStatus(),"1")) {
//                        //设备运行中
//                        return Constant.EX_PULLING_MATHINE_IN_PROCESS;
//                    }
//                    if (!StringUtils.equals(ima.getImaStatus(),"0") && !StringUtils.equals(ima.getImaStatus(),"1")) {
//                        //设备故障
//                        return Constant.EX_PULLING_MATHINE_EXCEPTION;
//                    }
//                } else {
//                    return "please add machine";
//                }
//
//                //验证通过，向PLC发送取车指令执行取车操作
////                SingleThreadSocket singleThreadSocket = new SingleThreadSocket();
////                returnStr = singleThreadSocket.start("02", tmp.getTmpPhysicalCode());
//                returnStr = "0";
//                if (StringUtils.equals(returnStr,"0")) {
//                    OftbMathineItemCriteria oftbMathineItemCriteria = new OftbMathineItemCriteria();
//                    OftbMathineItemCriteria.Criteria omiCriteria = oftbMathineItemCriteria.createCriteria();
//                    omiCriteria.andImaIdEqualTo(maId);
////                    omiCriteria.andOmiPhysicalCodeLike(tmp.getTmpPhysicalCode());
//                    omiCriteria.andOmiPhysicalCodeLike("1");
//                    List omiList = this.oftbMathineItemDao.ReadAllByOrder(oftbMathineItemCriteria);
//                    if (CollectionUtils.isNotEmpty(omiList)){
//                        OftbMathineItem omi = (OftbMathineItem) omiList.get(0);
//                        omi.setOmiStatus("0");
//                        this.oftbMathineItemDao.update(omi);
//                    }
//                }
//                MstbCustomer mc = (MstbCustomer) this.mstbCustomerDao.ReadByID(Integer.valueOf(cusId));
//                TstbMathineParkingLog tstbMathineParkingLog = TstbMathineParkingLog.builder().build();
//                tstbMathineParkingLog.setImaId(maId);
//                tstbMathineParkingLog.setTmplPhysicalCode(tmp.getTmpPhysicalCode());
//                tstbMathineParkingLog.setTmplCar(occ.getOccCode());
//                tstbMathineParkingLog.setTmplCustomer(mc.getMcNameCn());
//                tstbMathineParkingLog.setTmplType("1");
//                tstbMathineParkingLog.setTmplStatus(returnStr);
//                this.tstbMathineParkingLogDao.save(tstbMathineParkingLog);
////                this.parkingWS.toSyncParking();
//            }
//        } catch (Exception e) {
//            throw new SkyLotException("ParkingWSImpl - Exception:toPulling", e.getCause());
//        }
//        return returnStr;
//    }
//
//    @Override
//    public int toSyncOperationLog(String operationLog) throws SkyLotException {
//        int result = 0;
//        try {
//            IftbScheduleAction iftbScheduleAction = SingletonObjectMapper.getInstance().readValue(operationLog, IftbScheduleAction.class);
//            if (StringUtils.equals(iftbScheduleAction.getIsaModuleId(),Constant.SCHEDULEACTION_MODULEID_CUSTOMER)) {
//                //用户信息
//                List<MstbCustomer> mstbCustomers = new ArrayList<MstbCustomer>();
//                List<LinkedHashMap> mapList =  SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        MstbCustomer mstbCustomer = new MstbCustomer();
//                        BeanUtils.populate(mstbCustomer, linkedHashMap);
//                        mstbCustomers.add(mstbCustomer);
//                    }
//                }
//                for (MstbCustomer mc:mstbCustomers){
//                    if (iftbScheduleAction.getIsaScheduleType().equals(Constant.SCHEDULEACTION_TYPE_ADD)) {
//                        result = this.mstbCustomerDao.save(mc);
//                    } else {
//                        result = this.mstbCustomerDao.update(mc);
//                    }
//                }
//            } else if (iftbScheduleAction.getIsaModuleId().equals(Constant.SCHEDULEACTION_MODULEID_CUSTOMERCAR)) {
//                //用户绑定车牌
//                List<OftbCustomerCar> oftbCustomerCars = new ArrayList<OftbCustomerCar>();
//                List<LinkedHashMap> mapList =  SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        OftbCustomerCar oftbCustomerCar = new OftbCustomerCar();
//                        BeanUtils.populate(oftbCustomerCar, linkedHashMap);
//                        oftbCustomerCars.add(oftbCustomerCar);
//                    }
//                }
//                for (OftbCustomerCar occ:oftbCustomerCars){
//                    if (iftbScheduleAction.getIsaScheduleType().equals(Constant.SCHEDULEACTION_TYPE_ADD)) {
//                        result = this.oftbCustomerCarDao.save(occ);
//                    } else {
//                        result = this.oftbCustomerCarDao.update(occ);
//                    }
//                }
//            } else if (iftbScheduleAction.getIsaModuleId().equals(Constant.SCHEDULEACTION_MODULEID_ITEMCUSTOMER)) {
//                //用户绑定车位
//                List<IftbItemCustomer> iftbItemCustomers = new ArrayList<IftbItemCustomer>();
//                List<LinkedHashMap> mapList =  SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        IftbItemCustomer iftbItemCustomer = new IftbItemCustomer();
//                        BeanUtils.populate(iftbItemCustomer, linkedHashMap);
//                        iftbItemCustomers.add(iftbItemCustomer);
//                    }
//                }
//                for (IftbItemCustomer iic:iftbItemCustomers){
//                    if (iftbScheduleAction.getIsaScheduleType().equals(Constant.SCHEDULEACTION_TYPE_ADD)) {
//                        result = this.iftbItemCustomerDao.save(iic);
//                    } else {
//                        result = this.iftbItemCustomerDao.update(iic);
//                    }
//                }
//
//            } else if (iftbScheduleAction.getIsaModuleId().equals(Constant.SCHEDULEACTION_MODULEID_MACHINEITEM)) {
//                //设备车位
//                List<OftbMathineItem> oftbMathineItems = new ArrayList<OftbMathineItem>();
//                List<LinkedHashMap> mapList =  SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        OftbMathineItem oftbMathineItem = OftbMathineItem.builder().build();
//                        BeanUtils.populate(oftbMathineItem, linkedHashMap);
//                        oftbMathineItems.add(oftbMathineItem);
//                    }
//                }
//                for (OftbMathineItem omi:oftbMathineItems){
//                    if (iftbScheduleAction.getIsaScheduleType().equals(Constant.SCHEDULEACTION_TYPE_ADD)) {
//                        result = this.oftbMathineItemDao.save(omi);
//                    } else {
//                        result = this.oftbMathineItemDao.update(omi);
//                    }
//                }
//            } else if (iftbScheduleAction.getIsaModuleId().equals(Constant.SCHEDULEACTION_MODULEID_MACHINEACTION)) {
//                //设备物业关系
//                List<IftbMachineAction> iftbMachineActions = new ArrayList<IftbMachineAction>();
//                List<LinkedHashMap> mapList =  SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), List.class);
//                if (CollectionUtils.isNotEmpty(mapList)) {
//                    for (LinkedHashMap linkedHashMap : mapList) {
//                        IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
//                        BeanUtils.populate(iftbMachineAction, linkedHashMap);
//                        iftbMachineActions.add(iftbMachineAction);
//                    }
//                }
//                for (IftbMachineAction ima:iftbMachineActions){
//                    if (iftbScheduleAction.getIsaScheduleType().equals(Constant.SCHEDULEACTION_TYPE_ADD)) {
//                        result = this.iftbMachineActionDao.save(ima);
//                    } else {
//                        result = this.iftbMachineActionDao.update(ima);
//                    }
//                }
//            }
//
//            return result;
//        } catch (Exception e) {
//            throw new SkyLotException("ParkingWSImpl - Exception:toSyncOperationLog", e.getCause());
//        }
//    }
//}
