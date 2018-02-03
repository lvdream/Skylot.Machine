package com.fangda.skylot.mathine.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleParamater {
    /**
     * 二维码
     */
    private String scanCode;
    /**
     * 密码
     */
    private String password;
    /**
     * 车牌
     */
    private String carCode;
    /**
     * 管理员工号
     */
    private String managerNumber;
    /**
     * 管理员密码
     */
    private String managerPassword;
    /**
     * 是否已支付,0,未支付,1,已支付
     */
    private String payCost;
}
