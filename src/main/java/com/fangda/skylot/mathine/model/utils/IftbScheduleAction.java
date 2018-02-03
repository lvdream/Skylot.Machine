package com.fangda.skylot.mathine.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IftbScheduleAction implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer isaId;
    private String isaBusinessObj;
    private String isaModuleId;
    private String isaItemId;
    private String isaScheduleDate;
    private String isaScheduleType;
    private String isaScheduleMessage;
    private String isaStatus;
    private String isaCreatedate;
    private String isaCreateuser;
    private String isaUpdatedate;
    private String isaUpdateuser;

}