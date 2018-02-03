package com.fangda.skylot.mathine.dao.impl;


import com.fangda.skylot.mathine.dao.customer.OftbCodeInfoDAO;
import com.fangda.skylot.mathine.dao.customer.OftbCodeInfoMapper;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfo;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfoCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author cloud
 * 2016.11.15
 */
@Slf4j
@Repository("codeInfoDao")
public class OftbCodeInfoDAOImpl extends IBaseDaoImpl<OftbCodeInfo, OftbCodeInfoCriteria> implements OftbCodeInfoDAO {

    @Autowired
    public void setiBaseMapper(OftbCodeInfoMapper codeInfoMapper) {
        super.setiBaseMapper(codeInfoMapper);
    }

}
