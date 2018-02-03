package com.fangda.skylot.mathine.dao.customer;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.customer.OftbSyncLog;
import com.fangda.skylot.mathine.model.customer.OftbSyncLogCriteria;
import org.springframework.stereotype.Repository;

@Repository()
public interface OftbSyncLogMapper extends IBaseMapper<OftbSyncLog, OftbSyncLogCriteria> {
}