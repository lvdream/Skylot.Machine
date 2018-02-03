package com.fangda.skylot.mathine.model.parking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OftbMathineItem implements Serializable {
    private Integer omiId;

    private String imaId;

    private String omiCode;

    private String omiPhysicalCode;

    private String omiName;

    private String omiRate;

    private String omiStartdate;

    private String omiEnddate;

    private String omiStatus;

    private String omiCreateuser;

    private String omiCreatedate;

    private String omiUpdateuser;

    private String omiUpdatedate;
    //页面显示 车牌
    private String occCode;

}