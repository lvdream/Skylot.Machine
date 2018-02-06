package com.fangda.skylot.mathine.web.webservice;

import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.service.webservice.PushWebService;
import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

/**
 * webservice 对应接口
 */
@RestController
@RequestMapping(value = "/webservice")
@Slf4j
public class PushServiceController {

    @Autowired
    private ErrorCode code;

    @Autowired
    private PushWebService pushWS;


    @RequestMapping(value = "/syncPush", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(IftbScheduleAction iftbScheduleAction) throws Exception {
        Map<String, String> messageObj = SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), Map.class);
        Map resultMap = Maps.newHashMap();
        StringBuilder exceptionBuilder = new StringBuilder();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        Map subMap = Maps.newHashMap();
        try {
            try {
//                wsThreadMgt.putCommander(messageObj);
            } catch (Exception e) {//已有队列正在运行
                exceptionBuilder.append("webservice.single.process.alive");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            if (MapUtils.isEmpty(messageObj)) {
                exceptionBuilder.append("webservice.required.parameter.error");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            if (!StringUtils.equals(SkylotUtils.imaId, iftbScheduleAction.getIsaModuleId())) {
                exceptionBuilder.append("webservice.parameter.error.imaid");
                throw new SkyLotException(exceptionBuilder.toString());
            }
            String resultStr = pushWS.pushSync(iftbScheduleAction);
            if (StringUtils.equals(resultStr, FN_RETURN_STATUS_SUCCESS)) {
                result.setResultType(true);
                jsonDataResult.setResult("0");
                subMap = SkylotUtils.beanToHashMap(jsonDataResult);
                SkylotUtils.removeNullValue(subMap);
                result.setData(subMap);
                resultMap = SkylotUtils.beanToHashMap(result);
            } else {
                if (StringUtils.equals(resultStr, FN_RETURN_STATUS_ERROR)) {
                    exceptionBuilder.append("webservice.execute.error");
                }
                if (StringUtils.equals(resultStr, FN_RETURN_STATUS_HANDLE)) {
                    exceptionBuilder.append("webservice.execute.timeout");
                }

                throw new SkyLotException(exceptionBuilder.toString());
            }

//            wsThreadMgt.getCommands();//线程队列释放
        } catch (SkyLotException e) {
            if (StringUtils.contains(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE)) {
                code.doErrorLogic(result, resultMap, StringUtils.substringAfterLast(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE));
            } else {
                throw new SkyLotException(e);
            }
        }
        return resultMap;
    }
}
