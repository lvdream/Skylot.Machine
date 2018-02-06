package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.model.utils.ErrorCode;
import com.fangda.skylot.mathine.model.utils.JsonDataResult;
import com.fangda.skylot.mathine.model.utils.JsonResult;
import com.fangda.skylot.mathine.scheduler.springtask.MainThreadUtil;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.SocketService;
import com.fangda.skylot.mathine.service.customer.CodeInfoService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.web.BaseController;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

@RestController
@RequestMapping(value = "/qrcode")
@Slf4j
public class QRCodeController extends BaseController {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private ErrorCode code;
    @Autowired
    private SocketService socketService;
    @Autowired
    private MainThreadUtil mainThreadUtil;

    @RequestMapping(value = "/getCar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        try {
            Map subMap = Maps.newHashMap();
            result.setResultType(false);
            if (StringUtils.isNotEmpty(consoleParamater.getScanCode())) {
                Map subMapData = ((CodeInfoService) serviceMap.get("codeInfoService")).verifyCode(consoleParamater.getScanCode(), false);
                jsonDataResult.setResult(MapUtils.getString(subMapData, MAP_PARKING_STATUS));
                jsonDataResult.setCarCode(MapUtils.getString(SkylotUtils.verifyCode(consoleParamater.getScanCode()), MAP_QRCODE_CARCODE));
                if (StringUtils.equals(jsonDataResult.getResult(), FN_RETURN_STATUS_SUCCESS)) {//验证成功,可以取车
                    TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                    TstbFtpCarInformation tstbFtpCarInformation = TstbFtpCarInformation.builder().build();
                    tstbFtpCarInformation.setTfcCarCode(MapUtils.getString(subMapData, SCHEDULEACTION_BUSINESSOBJ_CUSTOMER));
                    tstbFtpCarInformation.setTfcCreatetime(SkylotUtils.getStrDate());
                    tstbFtpCarInformation.setTfcStatus(NumberUtils.toInt(PARKING_PULLING_STATUS_PROGRESS));//进入取车流程
                    tstbFtpCarInformation.setTfcCarAction(PARKING_PULLING_STATUS_PROGRESS);
                    tstbFtpCarInformation.setTfcCreateuser("auto");
                    tstbFtpCarInformation.setImaId(GetProperties.getProperties("system.properties", "skylot.machine.id"));
                    serviceMap.get("ftpcarService").add(tstbFtpCarInformation);//存储识别到的车牌号
                    result.setResultType(true);
                }
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

    @RequestMapping(value = "/cancelCar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON2(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        Map subMap = Maps.newHashMap();
        try {
            if (StringUtils.isNotEmpty(consoleParamater.getScanCode())) {
                Map subMapData = ((CodeInfoService) serviceMap.get("codeInfoService")).verifyCode(consoleParamater.getScanCode(), true);
                jsonDataResult.setResult(MapUtils.getString(subMapData, MAP_PARKING_STATUS));
                jsonDataResult.setCarCode(MapUtils.getString(SkylotUtils.verifyCode(consoleParamater.getScanCode()), MAP_QRCODE_CARCODE));
                cancelCar(jsonDataResult, mainThreadUtil, result, exceptionBuilder);
                result.setResultType(true);
                jsonDataResult.setResult("0");
                subMap = SkylotUtils.beanToHashMap(jsonDataResult);
                SkylotUtils.removeNullValue(subMap);
                result.setData(subMap);
                resultMap = SkylotUtils.beanToHashMap(result);
            }
        } catch (Exception e) {
        }
        return resultMap;
    }

}
