package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.SocketService;
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
@RequestMapping(value = "/door")
@Slf4j
public class GetCarController extends BaseController {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private SocketService socketService;
    @Autowired
    private ErrorCode code;

    @RequestMapping(value = "/open", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            if (StringUtils.equals(socketService.peopleDoor(FN_RETURN_STATUS_SUCCESS) + "", FN_RETURN_STATUS_SUCCESS)) {
                result.setResultType(true);
                jsonDataResult.setResult("0");
            } else {
                result.setResultType(false);
                exceptionBuilder.append("request.confirm.getcar.fail");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            subMap = SkylotUtils.beanToHashMap(jsonDataResult);
            SkylotUtils.removeNullValue(subMap);
            result.setData(subMap);
            resultMap = SkylotUtils.beanToHashMap(result);
        } catch (Exception e) {
            doException(code, result, jsonDataResult, resultMap, e);
        }
        return resultMap;
    }

}
