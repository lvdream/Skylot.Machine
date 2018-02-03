package com.fangda.skylot.mathine.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OftbCustomerCar implements Serializable {
    private Integer occId;

    private Integer mcId;

    private String occName;

    private String occCode;

    private String occType;

    private String occStatus;

    private String occCreateuser;

    private String occCreatedate;

    private String occUpdateuser;

    private String occUpdatedate;

}