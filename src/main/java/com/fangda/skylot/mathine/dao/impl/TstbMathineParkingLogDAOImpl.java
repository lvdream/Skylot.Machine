package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingLogDAO;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingLogMapper;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingLog;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingLogCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Damon on 2016/11/30.
 */
@Repository("tstbMathineParkingLogDao")
public class TstbMathineParkingLogDAOImpl extends IBaseDaoImpl<TstbMathineParkingLog, TstbMathineParkingLogCriteria> implements TstbMathineParkingLogDAO {
    @Autowired
    public void setiBaseMapper(TstbMathineParkingLogMapper tstbMathineParkingLogMapper) {
        super.setiBaseMapper(tstbMathineParkingLogMapper);
    }

}
