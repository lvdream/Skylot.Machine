package com.fangda.skylot.mathine.dao.impl;


import com.fangda.skylot.mathine.dao.customer.OftbReserveTakingDAO;
import com.fangda.skylot.mathine.dao.customer.OftbReserveTakingMapper;
import com.fangda.skylot.mathine.model.customer.OftbReserveTaking;
import com.fangda.skylot.mathine.model.customer.OftbReserveTakingCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author cloud
 * 2016.11.15
 */
@Slf4j
@Repository("reserveTakingDao")
public class OftbReserveTakingDAOImpl extends IBaseDaoImpl<OftbReserveTaking, OftbReserveTakingCriteria> implements OftbReserveTakingDAO {

    @Autowired
    public void setiBaseMapper(OftbReserveTakingMapper reserveTakingMapper) {
        super.setiBaseMapper(reserveTakingMapper);
    }

}
