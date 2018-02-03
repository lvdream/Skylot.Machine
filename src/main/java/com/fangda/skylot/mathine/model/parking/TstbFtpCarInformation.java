package com.fangda.skylot.mathine.model.parking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TstbFtpCarInformation implements Serializable {
    private Integer tfcId;

    private String imaId;

    private String tfcCarCode;

    private Integer tfcStatus;

    private String tfcCreatetime;

    private String tfcCreateuser;

    private String tfcUpdatetime;

    private String tfcUpdateuser;
    private String tfcCarColor;
    private String tfcCarType;
    private String tfcCarAction;
    private String tfcCarInCode;
    private String tfcCarInType;
    private String tfcCarInColor;
    private String tfcIsCanceled;

}