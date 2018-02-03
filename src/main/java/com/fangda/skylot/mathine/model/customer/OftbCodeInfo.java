package com.fangda.skylot.mathine.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OftbCodeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ociId;
    private String imaId;
    private String ociPhysicalCode;
    private String ociCodeUrl;
    private String ociPassword;
    private String ociStatus;
    private String ociCreatedate;
    private String ociCreateuser;
    private String ociUpdatedate;
    private String ociUpdateuser;
}