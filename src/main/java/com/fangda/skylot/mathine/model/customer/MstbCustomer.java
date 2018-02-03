package com.fangda.skylot.mathine.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MstbCustomer implements Serializable {
    private Integer mcId;

    private String mcCode;

    private String mcPass;

    private String mcNameCn;

    private String mcMobile;

    private String mcType;

    private String mcStatus;

    private String mcVerifyCode;

    private String mcCreatedate;

    private String mcCreateuser;

    private String mcUpdatedate;

    private String mcUpdateuser;

}