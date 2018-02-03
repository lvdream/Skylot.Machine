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
public class OftbReserveTaking implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ortId;
    private Integer mcId;
    private String imaId;
    private String ortPhysicalCode;
    private String ortReserveTime;
    private String ortStatus;
    private String ortCreatedate;
    private String ortCreateuser;
    private String ortUpdatedate;
    private String ortUpdateuser;
}