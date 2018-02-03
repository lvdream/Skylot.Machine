package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.parking.ParkingLogService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.BUSINESS_ACTION_TYPE_PULL;
import static com.fangda.skylot.mathine.utils.constant.Constant.STR_EXCEPTION_BUSINESS_CODE;

@RestController
@RequestMapping(value = "/mgt")
@Slf4j
public class ManagerController {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private SyncService syncServiceImpl;
    @Autowired
    private ErrorCode code;

    /**
     * 管理员登录
     *
     * @param consoleParamater
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            if (StringUtils.isEmpty(consoleParamater.getManagerNumber()) || StringUtils.isEmpty(consoleParamater.getManagerPassword())) {
                exceptionBuilder.append("management.login.parameter.error");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            // TODO: 28/12/2017 管理员登录
            String mgtUser = GetProperties.getProperties("system.properties", "mgt.username");
            String mgtPasswd = GetProperties.getProperties("system.properties", "mgt.password");
            jsonDataResult.setResult("1");
            if (StringUtils.equals(consoleParamater.getManagerNumber(), mgtUser) && StringUtils.equals(consoleParamater.getManagerPassword(), mgtPasswd)) {
                result.setResultType(true);
                jsonDataResult.setResult("0");
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

    /**
     * 管理员取车
     *
     * @param consoleParamater
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON2(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            Map subMap = Maps.newHashMap();
            if (StringUtils.isEmpty(consoleParamater.getCarCode())) {
                exceptionBuilder.append("management.getcar.parameter.error");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            jsonDataResult.setResult("1");
            Map dataMap = syncServiceImpl.pullCar(consoleParamater.getCarCode());
            StringBuilder message = ((ParkingLogService) serviceMap.get("parkinglogService")).layoutMessage(dataMap, BUSINESS_ACTION_TYPE_PULL);
            if (StringUtils.contains(message, "成功")) {
                result.setResultType(true);
                jsonDataResult.setResult("0");
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
