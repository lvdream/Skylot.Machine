package com.fangda.skylot.mathine.dao.parking;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import org.springframework.stereotype.Repository;

@Repository("tstbFtpCarInformationMapper")
public interface TstbFtpCarInformationMapper extends IBaseMapper<TstbFtpCarInformation, TstbFtpCarInformationCriteria> {
}