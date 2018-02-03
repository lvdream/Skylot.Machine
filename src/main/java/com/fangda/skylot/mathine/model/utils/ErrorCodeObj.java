package com.fangda.skylot.mathine.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeObj {
    /**
     * 错误代码
     */
    private String errorCode = "";
    /**
     * 错误信息
     */
    private String errorMsg = "";
}
