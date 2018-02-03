package com.fangda.skylot.mathine.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class InterfaceReturn {
    private boolean resultType;

    private Object data;

    private Object error;

    private Object timeStamp;


}
