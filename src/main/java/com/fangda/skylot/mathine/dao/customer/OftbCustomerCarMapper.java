package com.fangda.skylot.mathine.dao.customer;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCar;
import com.fangda.skylot.mathine.model.customer.OftbCustomerCarCriteria;
import org.springframework.stereotype.Repository;

@Repository("customerCarMapper")
public interface OftbCustomerCarMapper extends IBaseMapper<OftbCustomerCar, OftbCustomerCarCriteria> {
}