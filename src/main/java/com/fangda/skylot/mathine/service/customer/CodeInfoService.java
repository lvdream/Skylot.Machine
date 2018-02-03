/***********************************************************************
 * Module:  CostomerService.java
 * Author:  saul
 * Purpose: Defines the Interface CostomerService
 ***********************************************************************/

package com.fangda.skylot.mathine.service.customer;


import com.fangda.skylot.mathine.model.customer.OftbCodeInfo;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfoCriteria;
import com.fangda.skylot.mathine.service.IBaseService;

import java.util.Map;

/**
 * 预订取车时间
 */
public interface CodeInfoService extends IBaseService<OftbCodeInfo, OftbCodeInfoCriteria> {


    /**
     * 验证密码或者二维码
     *
     * @param originalCode 原始代码原始代码,支持密码或者二维码
     * @return 0.操作成功 1.临停未支付 2. 二维码/密码有误 3. 月租车位过期
     */
    Map verifyCode(String originalCode, boolean canceled) throws Exception;
}