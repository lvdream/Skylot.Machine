package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.IftbMachineActionDAO;
import com.fangda.skylot.mathine.dao.parking.IftbMachineActionMapper;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("iftbMachineActionDao")
public class IftbMachineActionDAOImpl extends IBaseDaoImpl<IftbMachineAction, IftbMachineActionCriteria> implements IftbMachineActionDAO {
    @Autowired
    public void setiBaseMapper(IftbMachineActionMapper iftbMachineActionMapper) {
        super.setiBaseMapper(iftbMachineActionMapper);
    }

}
