package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.IftbScheduleActionDAO;
import com.fangda.skylot.mathine.dao.parking.IftbScheduleActionMapper;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.model.utils.IftbScheduleActionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("iftbScheduleActionDao")
public class IftbScheduleActionDAOImpl extends IBaseDaoImpl<IftbScheduleAction, IftbScheduleActionCriteria> implements IftbScheduleActionDAO {
    @Autowired
    public void setiBaseMapper(IftbScheduleActionMapper scheduleActionmapper) {
        super.setiBaseMapper(scheduleActionmapper);
    }

}
