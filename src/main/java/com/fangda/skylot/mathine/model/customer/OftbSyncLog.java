package com.fangda.skylot.mathine.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class OftbSyncLog implements Serializable {
    private Integer oslId;

    private String oslType;

    private Integer oslCount;

    private String oslStatus;

    private String oslCreatedate;

    private String oslCreateuser;

    private String oslUpdatedate;

    private String oslUpdateuser;

    private String oslOrignalMessage;
}