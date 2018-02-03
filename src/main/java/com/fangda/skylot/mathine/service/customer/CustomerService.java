/***********************************************************************
 * Module:  CostomerService.java
 * Author:  saul
 * Purpose: Defines the Interface CostomerService
 ***********************************************************************/

package com.fangda.skylot.mathine.service.customer;


import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import com.fangda.skylot.mathine.service.IBaseService;

import java.util.List;

/**
 * 顾客Service
 */
public interface CustomerService extends IBaseService<MstbCustomer, MstbCustomerCriteria> {
    /**
     * 获取当前设备上的过期车辆
     *
     * @return List
     */
    List getExpiredCars() throws Exception;
}