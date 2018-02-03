package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.TstbFtpCarInformationDAO;
import com.fangda.skylot.mathine.dao.parking.TstbFtpCarInformationMapper;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Damon on 2016/12/6.
 */
@Repository("tstbFtpCarInformationDao")
public class TstbFtpCarInformationDAOImpl extends IBaseDaoImpl<TstbFtpCarInformation, TstbFtpCarInformationCriteria> implements TstbFtpCarInformationDAO {

    @Autowired
    public void setiBaseMapper(TstbFtpCarInformationMapper tstbFtpCarInformationMapper) {
        super.setiBaseMapper(tstbFtpCarInformationMapper);
    }

}
