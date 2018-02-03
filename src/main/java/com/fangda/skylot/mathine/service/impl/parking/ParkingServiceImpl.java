package com.fangda.skylot.mathine.service.impl.parking;

import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingDAO;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.ParkingService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("parkingService")
public class ParkingServiceImpl extends BaseServiceImpl<TstbMathineParking, TstbMathineParkingCriteria> implements ParkingService {
    @Autowired
    public void setBaseDao(TstbMathineParkingDAO tstbMathineParkingDao) {
        super.setBaseDao(tstbMathineParkingDao);
    }

    @Override
    public int easyPullCar(int cusId, int carId, int maId, int key) throws SkyLotException {
        String returnStr = null;
        String pullMessage = null;
        TstbMathineParking tmp = null;
//        try {
//            // 判断key是否正确
//            if (true) {
//                // 查询汽车信息
//                OftbCustomerCar occ = (OftbCustomerCar) super.getServiceMap()   this.oftbCustomerCarDao.ReadByID(carId);
//                TstbMathineParkingCriteria tstbMathineParkingCriteria = new TstbMathineParkingCriteria();
//                TstbMathineParkingCriteria.Criteria tmpCriteria = tstbMathineParkingCriteria.createCriteria();
//                tmpCriteria.andTmpCarCodeLike(occ.getOccCode());
//                List tmpList = this.tstbMathineParkingDao.readByCode(tstbMathineParkingCriteria);
//                if (CollectionUtils.isEmpty(tmpList)) {
//                    pullMessage = Constant.EX_PULLING_NO_CAR_IN_SEARCH;
//                    return -1;
//                } else {
//                    tmp = (TstbMathineParking) tmpList.get(0);
//                }
//
//                // 查询设备与物业关系
//                IftbMachineAction ima = (IftbMachineAction) this.iftbMachineActionDao.ReadByID(maId);
//                if (StringUtils.equals(ima.getImaStatus(), Constant.MACHINEACTION_STATUS_BUSY)) {
//                    pullMessage = Constant.EX_PULLING_MATHINE_IN_PROCESS;
//                    return -1;
//                }
//                if (StringUtils.equals(ima.getImaStatus(), Constant.MACHINEACTION_STATUS_ERROR)) {
//                    pullMessage = Constant.EX_PULLING_MATHINE_EXCEPTION;
//                    return -1;
//                }
//
//                //验证通过，向PLC发送取车指令执行取车操作
//                SingleThreadSocket singleThreadSocket = new SingleThreadSocket();
//                returnStr = singleThreadSocket.start(Constant.PARKING_PHYSICALCODE_TWO, tmp.getTmpPhysicalCode());
//
//                MstbCustomer mc = (MstbCustomer) this.mstbCustomerDao.ReadByID(cusId);
//
//                TstbMathineParkingLog tstbMathineParkingLog = new TstbMathineParkingLog();
//                tstbMathineParkingLog.setImaId(Constant.MACHINEPARKING_IMAID);
//                tstbMathineParkingLog.setTmplCar(occ.getOccCode());
//                tstbMathineParkingLog.setTmplCustomer(mc.getMcNameCn());
//                tstbMathineParkingLog.setTmplType(Constant.MACHINEPARKING_TYPE_TAKE);
//                tstbMathineParkingLog.setTmplStatus(returnStr);
//
//                this.tstbMathineParkingLogDao.save(tstbMathineParkingLog);
//            }
//        } catch (Exception e) {
//            throw new SkyLotException("ParkingServiceImpl - Exception:easyPullCar", e.getCause());
//        }
        return Integer.valueOf(returnStr);
    }

}
