package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.customer.OftbCustomerCarDAO;
import com.fangda.skylot.mathine.dao.customer.OftbCustomerCarMapper;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCar;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCarCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("customerCarDao")
public class OftbCustomerCarDAOImpl extends IBaseDaoImpl<OftbCustomerCar, OftbCustomerCarCriteria> implements OftbCustomerCarDAO {

    @Autowired
    public void setiBaseMapper(OftbCustomerCarMapper customerCarMapper) {
        super.setiBaseMapper(customerCarMapper);
    }

}
