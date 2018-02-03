package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingDAO;
import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingMapper;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tstbMathineParkingDao")
public class TstbMathineParkingDAOImpl extends IBaseDaoImpl<TstbMathineParking, TstbMathineParkingCriteria> implements TstbMathineParkingDAO {

    @Autowired
    public void setiBaseMapper(TstbMathineParkingMapper tstbMathineParkingMapper) {
        super.setiBaseMapper(tstbMathineParkingMapper);
    }
}
