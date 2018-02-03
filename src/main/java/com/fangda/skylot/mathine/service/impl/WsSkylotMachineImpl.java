package com.fangda.skylot.mathine.service.impl;

import com.fangda.skylot.mathine.dao.customer.MstbCustomerDAO;
import com.fangda.skylot.mathine.service.WsSkylotMachine;
import com.fangda.skylot.mathine.utils.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Saul on 11/28/16.
 */
@Service("WsSkylotMachine")
@WebService(targetNamespace = Constant.WEB_SERVICE_NS)
public class WsSkylotMachineImpl implements WsSkylotMachine {
    @Autowired
    private MstbCustomerDAO mstbCustomerDAO;

    @Override
    public String test(String str1) {
        System.out.println(1);

        try {
            mstbCustomerDAO.delete(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
