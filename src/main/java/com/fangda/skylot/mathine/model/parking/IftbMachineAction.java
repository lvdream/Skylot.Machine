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
public class IftbMachineAction implements Serializable {
    private static final long serialVersionUID = 1L;
    private String imaId;
    private Integer mmId;
    private Integer maId;
    private String imaCode;
    private String imaName;
    private String imaAddress;
    private String imaPort;
    private String imaStatus;
    private String imaCreatetime;
    private String imaCreateuser;
    private String imaUpdatetime;
    private String imaUpdateuser;
    private String imaErrorJson;
    private String imaPhysicalStatus;

}