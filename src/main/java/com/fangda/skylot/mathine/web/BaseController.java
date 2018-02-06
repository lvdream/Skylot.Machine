/***********************************************************************
 * Module:  BaseController.java
 * Author:  saul
 * Purpose: Defines the Class BaseController
 ***********************************************************************/


package com.fangda.skylot.mathine.web;

/**
 * Created by Saul on 11/17/16.
 */

import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadUtil;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.FN_RETURN_STATUS_SUCCESS;
import static com.fangda.skylot.mathine.utils.constant.Constant.STR_EXCEPTION_BUSINESS_CODE;

/**
 * 基础Web-Controller
 *
 * @pdOid 8c4bd22d-a009-4b0d-940d-9c785255ab7e
 */
public class BaseController {
    protected void doException(ErrorCode code, JsonResult result, JsonDataResult jsonDataResult, Map resultMap, Exception e) {
        if (StringUtils.contains(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE)) {
            code.doErrorLogic(result, resultMap, StringUtils.substringAfterLast(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE));
        } else {
            result.setResultType(false);
            result.setData(Maps.newHashMap());
            resultMap = SkylotUtils.beanToHashMap(result);
//                throw new SkyLotException(e);
        }
    }

    protected void cancelCar(JsonDataResult jsonDataResult, MainThreadUtil mainThreadUtil, JsonResult result, StringBuilder exceptionBuilder) throws SkyLotException {
        if (StringUtils.equals(jsonDataResult.getResult(), FN_RETURN_STATUS_SUCCESS)) {//验证成功,可以取消取车
            mainThreadUtil.userCancel();
            result.setResultType(true);
        } else {
            exceptionBuilder.append("request.password.usercancel.not.auth");
            throw new SkyLotException(exceptionBuilder.toString());
        }
    }
}
