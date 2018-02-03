package com.fangda.skylot.mathine.dao.customer;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.customer.OftbReserveTaking;
import com.fangda.skylot.mathine.model.customer.OftbReserveTakingCriteria;
import org.springframework.stereotype.Repository;

@Repository("reserveTakingMapper")
public interface OftbReserveTakingMapper extends IBaseMapper<OftbReserveTaking, OftbReserveTakingCriteria> {

}