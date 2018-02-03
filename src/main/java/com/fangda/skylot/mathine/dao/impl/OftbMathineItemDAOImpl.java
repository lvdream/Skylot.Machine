package com.fangda.skylot.mathine.dao.impl;

import com.fangda.skylot.mathine.dao.parking.OftbMathineItemDAO;
import com.fangda.skylot.mathine.dao.parking.OftbMathineItemMapper;
import com.fangda.skylot.mathine.model.parking.OftbMathineItem;
import com.fangda.skylot.mathine.model.parking.OftbMathineItemCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("oftbMathineItemDao")
public class OftbMathineItemDAOImpl extends IBaseDaoImpl<OftbMathineItem, OftbMathineItemCriteria> implements OftbMathineItemDAO {

    @Autowired
    public void setiBaseMapper(OftbMathineItemMapper oftbMathineItemMapper) {
        super.setiBaseMapper(oftbMathineItemMapper);
    }

}
