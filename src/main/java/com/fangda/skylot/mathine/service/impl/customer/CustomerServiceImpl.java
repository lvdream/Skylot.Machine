package com.fangda.skylot.mathine.service.impl.customer;


import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.dao.customer.IftbItemCustomerDAO;
import com.fangda.skylot.mathine.dao.customer.MstbCustomerDAO;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomer;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomerCriteria;
import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.CustomerService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.MachineActionService;
import com.fangda.skylot.mathine.service.parking.ParkingService;
import com.fangda.skylot.mathine.utils.DateUtil;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.MAP_QRCODE_CARCODE;

@Slf4j
@Transactional
@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<MstbCustomer, MstbCustomerCriteria> implements CustomerService {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private Map<String, IBaseDao> daoMap;

    @Autowired
    public void setBaseDao(MstbCustomerDAO mstbCustomerDao) {
        super.setBaseDao(mstbCustomerDao);
    }

    /**
     * 获取当前设备上的过期车辆
     *
     * @return List
     */
    @Override
    public List getExpiredCars() throws Exception {
        //判断当前设备是否是月租设备
        try {
            IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
            criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
            IftbMachineAction iftbMachineAction = ((MachineActionService) serviceMap.get("machineActionService")).query(criteria);
            if (iftbMachineAction != null && iftbMachineAction.getImaCode().equals("0")) {//月租
                //获取当前在停车台上的所有车辆
                List<TstbMathineParking> parkingCars = ((ParkingService) serviceMap.get("parkingService")).queryForAll(new TstbMathineParkingCriteria());
                if (CollectionUtils.isNotEmpty(parkingCars)) {
                    List<String> carCodes = Lists.newArrayList();
                    for (int i = 0; i < parkingCars.size(); i++) {
                        TstbMathineParking tstbMathineParking = parkingCars.get(i);
                        carCodes.add(tstbMathineParking.getTmpCarCode());
                    }
                    IftbItemCustomerCriteria customerCriteria = new IftbItemCustomerCriteria();
                    String dateCompare = DateUtil.dateToStrLong(DateUtils.truncate(new Date(), Calendar.DATE));
                    customerCriteria.createCriteria().andIccCarCodeIn(carCodes).andIicEnddateGreaterThan(dateCompare);
                    List<IftbItemCustomer> iftbItemCustomers = ((IftbItemCustomerDAO) this.daoMap.get("iftbItemCustomerDao")).ReadAll(customerCriteria);
                    if (CollectionUtils.isNotEmpty(iftbItemCustomers)) {
                        List<Map<String, String>> carCodeReturn = Lists.newArrayList();
                        for (int i = 0; i < iftbItemCustomers.size(); i++) {
                            IftbItemCustomer iftbItemCustomer = iftbItemCustomers.get(i);
                            Map strMap = Maps.newHashMap();
                            strMap.put(MAP_QRCODE_CARCODE, iftbItemCustomer.getIccCarCode());
                            carCodeReturn.add(strMap);
                        }
                        return carCodeReturn;
                    }
                }
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return null;
    }
}
