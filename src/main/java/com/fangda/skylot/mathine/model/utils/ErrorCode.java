package com.fangda.skylot.mathine.model.utils;


import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 定义错误码信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ErrorCode {

    /**
     * 定义错误代码Map
     */
    private Map codeMap;
    /**
     * 定义错误代码Map__PLC
     */
    private Map codePLC;
    private String targetLot;
    private List errorList;
    private List errorCancel;

    /**
     * 处理错误逻辑
     */
    public void doErrorLogic(JsonResult result, Map resultMap, String errorCodes) {
        result.setResultType(false);
        List list = new ArrayList();
        String[] errorCodeArray = StringUtils.split(errorCodes, ",");
        for (int i = 0; i < errorCodeArray.length; i++) {
            String s = errorCodeArray[i];
            ErrorCodeObj errorCodeObj = ErrorCodeObj.builder().build();
            errorCodeObj.setErrorCode(s);
            errorCodeObj.setErrorMsg(codeMap.get(s).toString());
            Map errorMap = Maps.newHashMap();
            errorMap.put("ErrorCodeObj", SkylotUtils.beanToHashMap(errorCodeObj));
            list.add(errorMap);
        }
        result.setError(list);
        resultMap.put("error", list);
    }
}
