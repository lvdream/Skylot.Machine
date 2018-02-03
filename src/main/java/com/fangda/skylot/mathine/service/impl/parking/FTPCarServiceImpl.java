package com.fangda.skylot.mathine.service.impl.parking;

import com.fangda.skylot.mathine.dao.parking.TstbFtpCarInformationDAO;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformation;
import com.fangda.skylot.mathine.model.parking.TstbFtpCarInformationCriteria;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.FTPCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ftpcarService")
public class FTPCarServiceImpl extends BaseServiceImpl<TstbFtpCarInformation, TstbFtpCarInformationCriteria> implements FTPCarService {
    @Autowired
    public void setBaseDao(TstbFtpCarInformationDAO tstbFtpCarInformationDao) {
        super.setBaseDao(tstbFtpCarInformationDao);
    }
}
