package com.fangda.skylot.mathine.service.impl.sync;

import com.fangda.skylot.mathine.dao.parking.OftbMathineItemDAO;
import com.fangda.skylot.mathine.model.parking.OftbMathineItem;
import com.fangda.skylot.mathine.model.parking.OftbMathineItemCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.sync.MachineItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Transactional
@Service("machineItemService")
public class MachineItemServiceImpl extends BaseServiceImpl<OftbMathineItem, OftbMathineItemCriteria>
        implements MachineItemService {
    @Autowired
    private Map<String, IBaseService> serviceMap;

    @Autowired
    public void setBaseDao(OftbMathineItemDAO oftbMathineItemDao) {
        super.setBaseDao(oftbMathineItemDao);
    }
}
