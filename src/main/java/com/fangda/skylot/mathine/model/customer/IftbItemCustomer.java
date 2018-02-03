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
public class IftbItemCustomer implements Serializable {
    private Integer iicId;

    private Integer mcId;

    private Integer omiId;

    private String iiicStatus;

    private String iicStartdate;

    private String iicEnddate;

    private String iicCost;

    private String iicFormula;

    private String iicCreatedate;

    private String iicCreateuser;

    private String iicUpdatedate;

    private String iicUpdateuser;

    /**
     * 购买绑定车牌
     */
    private String iccCarCode;

}