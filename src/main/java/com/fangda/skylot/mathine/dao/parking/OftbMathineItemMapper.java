package com.fangda.skylot.mathine.dao.parking;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.parking.OftbMathineItem;
import com.fangda.skylot.mathine.model.parking.OftbMathineItemCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("oftbMathineItemMapper")
public interface OftbMathineItemMapper extends IBaseMapper<OftbMathineItem, OftbMathineItemCriteria> {

    String selectByImaCode(@Param("occCode") String occCode, @Param("omiStatus") String omiStatus);
}