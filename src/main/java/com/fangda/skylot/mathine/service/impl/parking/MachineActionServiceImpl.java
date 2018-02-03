package com.fangda.skylot.mathine.service.impl.parking;

import com.fangda.skylot.mathine.dao.parking.IftbMachineActionDAO;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.MachineActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service("machineActionService")
public class MachineActionServiceImpl extends BaseServiceImpl<IftbMachineAction, IftbMachineActionCriteria> implements MachineActionService {

    @Autowired
    public void setBaseDao(IftbMachineActionDAO iftbMachineActionDao) {
        super.setBaseDao(iftbMachineActionDao);
    }
}
