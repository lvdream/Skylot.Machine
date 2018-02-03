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
public class TstbMathineParking implements Serializable {
    private Integer tmpId;

    private String imaId;

    private String tmpCode;

    private String tmpPhysicalCode;

    private String tmpCarCode;

    private String tmpStatus;

    private String tmpCreatedate;

    private String tmpCreateuser;

    private String tmpUpdateuser;

    private String tmpUpdatedate;

}