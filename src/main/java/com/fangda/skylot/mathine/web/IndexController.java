/***********************************************************************
 * Module:  IndexController.java
 * Author:  saul
 * Purpose: Defines the Class IndexController
 ***********************************************************************/
package com.fangda.skylot.mathine.web;

/**
 * Created by Saul on 11/17/16.
 */

import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.parking.ParkingLogService;
import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.socket.WSThreadMgt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Map;


/**
 * 主页面处理控制器
 *
 * @pdOid aa0967bb-e224-4acc-a823-2660d00a4ac6
 */
@Controller
@RequestMapping(value = "/index")
@Slf4j
public class IndexController extends BaseController {
    @Autowired
    public Map<String, IBaseService> serviceMap;
    @Autowired
    private WSThreadMgt wsThreadMgt;
    /**
     * 监控摄像机发来的图片识别信息,HTTP方式
     *
     * @param
     * @param request
     * @throws SkyLotException
     * @pdOid 809d6bee-f9e1-4d94-a0b7-442cc71d8773
     */
    @RequestMapping(value = "/value", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String w(HttpServletRequest request) throws SkyLotException {
        try {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    jb.append(line);
                }
            } catch (Exception e) {
                throw new SkyLotException(e);
            }
            Map map = SingletonObjectMapper.getInstance().readValue(jb.toString(), Map.class);
            ((ParkingLogService) serviceMap.get("parkinglogService")).parkingFromCallbak(map);
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
        return "";
    }

}
