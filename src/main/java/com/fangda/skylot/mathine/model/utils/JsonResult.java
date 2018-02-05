package com.fangda.skylot.mathine.model.utils;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 定义返回客户端的JSON对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回的状态值
     */
    private boolean resultType;
    /**
     * 设备的类型
     */
    private String serviceType;

    /**
     * 返回的数据类型
     */
    private Map data;

    /**
     * 错误对象
     */
    private List<Object> error = Lists.newArrayList();
}
