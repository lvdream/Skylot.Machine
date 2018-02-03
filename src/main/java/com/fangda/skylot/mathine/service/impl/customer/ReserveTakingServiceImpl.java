package com.fangda.skylot.mathine.service.impl.customer;


import com.fangda.skylot.mathine.dao.customer.OftbReserveTakingDAO;
import com.fangda.skylot.mathine.model.customer.OftbReserveTaking;
import com.fangda.skylot.mathine.model.customer.OftbReserveTakingCriteria;
import com.fangda.skylot.mathine.service.customer.ReserveTakingService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service("reserveTakingService")
public class ReserveTakingServiceImpl extends BaseServiceImpl<OftbReserveTaking, OftbReserveTakingCriteria> implements ReserveTakingService {

    @Autowired
    public void setBaseDao(OftbReserveTakingDAO reserveTakingDao) {
        super.setBaseDao(reserveTakingDao);
    }

}
