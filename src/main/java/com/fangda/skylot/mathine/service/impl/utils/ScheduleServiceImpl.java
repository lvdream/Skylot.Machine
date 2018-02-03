package com.fangda.skylot.mathine.service.impl.utils;

import com.fangda.skylot.mathine.dao.parking.IftbScheduleActionDAO;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.model.utils.IftbScheduleActionCriteria;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.utils.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("scheduleService")
public class ScheduleServiceImpl extends BaseServiceImpl<IftbScheduleAction, IftbScheduleActionCriteria> implements ScheduleService {
    @Autowired
    public void setBaseDao(IftbScheduleActionDAO iftbScheduleActionDao) {
        super.setBaseDao(iftbScheduleActionDao);
    }

}
