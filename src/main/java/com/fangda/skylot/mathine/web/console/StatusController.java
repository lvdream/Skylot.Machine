package com.fangda.skylot.mathine.web.console;

import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.model.utils.ConsoleParamater;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/console")
@Slf4j
public class StatusController {
    @Autowired
    private Map<String, IBaseService> serviceMap;

    @RequestMapping(value = "/status", method = RequestMethod.POST,
            produces = "application/json")
    public Map getJSON(ConsoleParamater consoleParamater) throws Exception {
        Map resultMap = Maps.newHashMap();
        try {
            IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
            criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
            IftbMachineAction iftbMachineAction = (IftbMachineAction) serviceMap.get("machineActionService").queryForAll(criteria).get(0);
            resultMap = SkylotUtils.jsonToMap(iftbMachineAction.getImaErrorJson());
        } catch (Exception e) {
            if (MapUtils.isEmpty(resultMap)) {
                resultMap = Maps.newHashMap();
            }
        } finally {
            if (MapUtils.isEmpty(resultMap)) {
                resultMap = Maps.newHashMap();
            }
        }
        return resultMap;
    }

}
