package com.fangda.skylot.mathine.dao.customer;

import com.fangda.skylot.mathine.dao.IBaseMapper;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfo;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfoCriteria;
import org.springframework.stereotype.Repository;

@Repository("codeInfoMapper")
public interface OftbCodeInfoMapper extends IBaseMapper<OftbCodeInfo, OftbCodeInfoCriteria> {

}