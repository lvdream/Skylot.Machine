package com.fangda.skylot.mathine.service;

import com.fangda.skylot.mathine.utils.constant.Constant;

import javax.jws.WebService;

/**
 * Created by Saul on 11/28/16.
 */
@WebService(targetNamespace = Constant.WEB_SERVICE_NS)
public interface WsSkylotMachine {
    String test(String str1);
}
