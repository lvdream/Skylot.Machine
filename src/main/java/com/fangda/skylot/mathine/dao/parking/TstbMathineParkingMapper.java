package com.fangda.skylot.mathine.dao.parking;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.parking.TstbMathineParking;
import com.fangda.skylot.mathine.model.parking.TstbMathineParkingCriteria;
import org.springframework.stereotype.Repository;

@Repository("tstbMathineParkingMapper")
public interface TstbMathineParkingMapper extends IBaseMapper<TstbMathineParking, TstbMathineParkingCriteria> {

}