package com.fangda.skylot.mathine.service.impl.customer;

import com.fangda.skylot.mathine.dao.customer.OftbCustomerCarDAO;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCar;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCarCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.CustomerCarService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Transactional
@Service("customercarService")
public class CustomerCarServiceImpl extends BaseServiceImpl<OftbCustomerCar, OftbCustomerCarCriteria>
        implements CustomerCarService {
    @Autowired
    private Map<String, IBaseService> serviceMap;

    @Autowired
    public void setBaseDao(OftbCustomerCarDAO customerCarDao) {
        super.setBaseDao(customerCarDao);
    }
}
