package com.fangda.skylot.mathine.service.impl.customer;

import com.fangda.skylot.mathine.dao.customer.IftbItemCustomerDAO;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomer;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomerCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.ItemCustomerService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Transactional
@Service("itemCustomerService")
public class ItemCustomerServiceImpl extends BaseServiceImpl<IftbItemCustomer, IftbItemCustomerCriteria>
        implements ItemCustomerService {
    @Autowired
    private Map<String, IBaseService> serviceMap;

    @Autowired
    public void setBaseDao(IftbItemCustomerDAO iftbItemCustomerDao) {
        super.setBaseDao(iftbItemCustomerDao);
    }
}
