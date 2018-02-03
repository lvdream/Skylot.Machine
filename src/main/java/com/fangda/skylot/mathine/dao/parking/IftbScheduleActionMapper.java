package com.fangda.skylot.mathine.dao.parking;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.model.utils.IftbScheduleActionCriteria;
import org.springframework.stereotype.Repository;

@Repository("scheduleActionmapper")
public interface IftbScheduleActionMapper extends IBaseMapper<IftbScheduleAction, IftbScheduleActionCriteria> {

}