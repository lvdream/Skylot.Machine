package com.fangda.skylot.mathine.utils.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static com.fangda.skylot.mathine.utils.constant.Constant.MACHINEPARKING_QUANTITY;

/**
 * Created by Saul on 05/08/2017.
 */
@Slf4j
public class ParkingLogicTest {
    @Test
    public void getStoreNum() throws Exception {
        ParkingLogic p = new ParkingLogic();
        p.setMachineTotalItmes(MACHINEPARKING_QUANTITY);
        p.setBaseNum("1");
        HashMap p1 = new HashMap();
        p1.put(12, "1");
        p.setParkingStatusMap(p1);
        Assert.assertEquals(10, p.getStoreNum(0));
    }


}