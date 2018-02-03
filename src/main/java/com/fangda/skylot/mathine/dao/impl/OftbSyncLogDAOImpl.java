package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.customer.OftbSyncLogDAO;
import com.fangda.skylot.mathine.dao.customer.OftbSyncLogMapper;
import com.fangda.skylot.mathine.model.customer.OftbSyncLog;
import com.fangda.skylot.mathine.model.customer.OftbSyncLogCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("oftbSyncLogDao")
public class OftbSyncLogDAOImpl extends IBaseDaoImpl<OftbSyncLog, OftbSyncLogCriteria> implements OftbSyncLogDAO {

    @Autowired
    public void setiBaseMapper(OftbSyncLogMapper oftbSyncLogMapper) {
        super.setiBaseMapper(oftbSyncLogMapper);
    }

}
