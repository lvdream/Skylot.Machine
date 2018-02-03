package com.fangda.skylot.mathine.dao.customer;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import org.springframework.stereotype.Repository;

@Repository("mstbCustomerMapper")
public interface MstbCustomerMapper extends IBaseMapper<MstbCustomer, MstbCustomerCriteria> {
}