package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadMgt;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadUtil;
import com.fangda.skylot.mathine.service.SocketService;
import com.fangda.skylot.mathine.service.impl.BaseCommandUtils;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.web.BaseController;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.FN_RETURN_STATUS_SUCCESS;
import static com.fangda.skylot.mathine.utils.constant.Constant.STR_EXCEPTION_BUSINESS_CODE;

@RestController
@RequestMapping(value = "/parkCar")
@Slf4j
public class ParkCarController extends BaseController {
    @Autowired
    private MainThreadMgt mainThreadMgt;
    @Autowired
    private SocketService socketService;
    @Autowired
    private MainThreadUtil mainThreadUtil;
    @Autowired
    private ErrorCode code;

    @RequestMapping(value = "/now", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            if (StringUtils.isNotEmpty(consoleParamater.getCarCode())) {
                if (mainThreadMgt.hasTasktodo()) {
                    TstbFtpCarInformation tstbFtpCarInformation = mainThreadMgt.getTstbFtpCarInformation();
                    tstbFtpCarInformation.setTfcCarInCode(BaseCommandUtils.decode(consoleParamater.getCarCode()));
                    if (mainThreadMgt.userconfirmCar(tstbFtpCarInformation)) {
                        result.setResultType(true);
                        jsonDataResult.setResult("0");
                    } else {
                        exceptionBuilder.append("request.user.parking.fail");
                        result.setResultType(false);
                        throw new SkyLotException(exceptionBuilder.toString());
                    }
                }
            }
            subMap = SkylotUtils.beanToHashMap(jsonDataResult);
            SkylotUtils.removeNullValue(subMap);
            result.setData(subMap);
            resultMap = SkylotUtils.beanToHashMap(result);
        } catch (Exception e) {
            if (StringUtils.contains(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE)) {
                code.doErrorLogic(result, resultMap, StringUtils.substringAfterLast(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE));
            } else {
                result.setResultType(false);
                result.setData(Maps.newHashMap());
                resultMap = SkylotUtils.beanToHashMap(result);
//                throw new SkyLotException(e);
            }
        }
        return resultMap;
    }

    /**
     * 取消停车
     *
     * @param consoleParamater
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cancelCar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON2(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            jsonDataResult.setResult(FN_RETURN_STATUS_SUCCESS);
            cancelCar(jsonDataResult, mainThreadUtil, result, exceptionBuilder, socketService, "0");
            jsonDataResult.setResult("0");
            subMap = SkylotUtils.beanToHashMap(jsonDataResult);
            SkylotUtils.removeNullValue(subMap);
            result.setData(subMap);
            resultMap = SkylotUtils.beanToHashMap(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
