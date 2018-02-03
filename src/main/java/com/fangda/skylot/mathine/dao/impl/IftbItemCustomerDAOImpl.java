package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.customer.IftbItemCustomerDAO;
import com.fangda.skylot.mathine.dao.customer.IftbItemCustomerMapper;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomer;
import com.fangda.skylot.mathine.model.customer.IftbItemCustomerCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("iftbItemCustomerDao")
public class IftbItemCustomerDAOImpl extends IBaseDaoImpl<IftbItemCustomer, IftbItemCustomerCriteria> implements IftbItemCustomerDAO {
    @Autowired
    public void setiBaseMapper(IftbItemCustomerMapper iftbMachineActionMapper) {
        super.setiBaseMapper(iftbMachineActionMapper);
    }

}
