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
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
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
@RequestMapping(value = "/password")
@Slf4j
public class PasswordController extends BaseController {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private ErrorCode code;
    @Autowired
    private SocketService socketService;
    @Autowired
    private MainThreadUtil mainThreadUtil;

    /**
     * 密码取车
     *
     * @param consoleParamater
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getCar", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        JsonResult result = new JsonResult();
        JsonDataResult jsonDataResult = new JsonDataResult();
        StringBuilder exceptionBuilder = new StringBuilder();
        Map subMap = Maps.newHashMap();
        exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
        try {
            result.setResultType(true);
            if (StringUtils.isNotEmpty(consoleParamater.getPassword()) &&
                    StringUtils.isEmpty(consoleParamater.getScanCode())) {
                consoleParamater.setScanCode(consoleParamater.getPassword());
            }
            if (StringUtils.isNotEmpty(consoleParamater.getScanCode())) {
                Map subMapData = ((CodeInfoService) serviceMap.get("codeInfoService")).verifyCode(consoleParamater.getScanCode(), false);
                jsonDataResult.setResult(MapUtils.getString(subMapData, MAP_PARKING_STATUS));
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
                } else {
                    if (StringUtils.equals(jsonDataResult.getResult(), FN_RETURN_STATUS_ERROR)) {//过期
                        exceptionBuilder.append("request.scancode.getcar.overrate");
                    } else if (StringUtils.equals(jsonDataResult.getResult(), EX_PARKING_USER_CAR_NO_ACCESS)) {//找不到
                        exceptionBuilder.append("system.scancode.getcar.fail");
                    }
                    throw new SkyLotException(exceptionBuilder.toString());

                }
                jsonDataResult.setCarCode(MapUtils.getString(SkylotUtils.verifyCode(consoleParamater.getScanCode()), MAP_QRCODE_CARCODE));
            }
            subMap = SkylotUtils.beanToHashMap(jsonDataResult);
            SkylotUtils.removeNullValue(subMap);
            result.setData(subMap);
            resultMap = SkylotUtils.beanToHashMap(result);
        } catch (Exception e) {
            doException(code, result, jsonDataResult, resultMap, e);
        }
        resultMap.put("resultType", true);
        subMap.put("machineStatus", "1");
        resultMap.put("data", subMap);
        if (exceptionBuilder.toString().contains("system.scancode.getcar.fail")) {
            resultMap.put("resultType", false);
        }
        return resultMap;
    }

    /**
     * 密码取消取车
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
            if (StringUtils.isNotEmpty(consoleParamater.getPassword()) &&
                    StringUtils.isEmpty(consoleParamater.getScanCode())) {
                consoleParamater.setScanCode(consoleParamater.getPassword());
            }
            if (StringUtils.isNotEmpty(consoleParamater.getScanCode())) {
                Map subMapData = ((CodeInfoService) serviceMap.get("codeInfoService")).verifyCode(consoleParamater.getScanCode(), true);
                jsonDataResult.setResult(MapUtils.getString(subMapData, MAP_PARKING_STATUS));
                cancelCar(jsonDataResult, mainThreadUtil, result, exceptionBuilder, socketService, "1");
                jsonDataResult.setCarCode(MapUtils.getString(SkylotUtils.verifyCode(consoleParamater.getScanCode()), MAP_QRCODE_CARCODE));
            }

        } catch (Exception e) {
        }
        return resultMap;
    }

}
