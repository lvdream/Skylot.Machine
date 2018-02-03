package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.customer.MstbCustomerDAO;
import com.fangda.skylot.mathine.dao.customer.MstbCustomerMapper;
import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mstbCustomerDao")
public class MstbCustomerDAOImpl extends IBaseDaoImpl<MstbCustomer, MstbCustomerCriteria> implements MstbCustomerDAO {

    @Autowired
    public void setiBaseMapper(MstbCustomerMapper mstbCustomerMapper) {
        super.setiBaseMapper(mstbCustomerMapper);
    }

}
