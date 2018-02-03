package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.CustomerService;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.STR_EXCEPTION_BUSINESS_CODE;

@RestController
@RequestMapping(value = "/expired")
@Slf4j
public class ExpiredController {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private ErrorCode code;

    @RequestMapping(value = "/listcar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            //查询当前设备是否是月租设备
            List cars = ((CustomerService) serviceMap.get("customerService")).getExpiredCars();
            if (CollectionUtils.isNotEmpty(cars)) {
                result.setResultType(true);
                jsonDataResult.setCarCodes(cars);
            } else {
                exceptionBuilder.append("request.admin.getcar.fail");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            subMap = SkylotUtils.beanToHashMap(jsonDataResult);
            SkylotUtils.removeNullValue(subMap);
            result.setData(subMap);
            resultMap = SkylotUtils.beanToHashMap(result);
        } catch (Exception e) {
            if (StringUtils.contains(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE)) {
                code.doErrorLogic(result, resultMap, StringUtils.substringAfterLast(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE));
            } else {
                throw new SkyLotException(e);
            }
        }
        return resultMap;
    }

}
