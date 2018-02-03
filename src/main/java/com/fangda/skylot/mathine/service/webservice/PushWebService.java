package com.fangda.skylot.mathine.service.webservice;

import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;

import javax.jws.WebMethod;

public interface PushWebService {
    /**
     * 推送同步信息
     *
     * @return
     */
    @WebMethod
    String pushSync(IftbScheduleAction iftbScheduleAction);
}
