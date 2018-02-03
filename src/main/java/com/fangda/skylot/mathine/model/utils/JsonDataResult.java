package com.fangda.skylot.mathine.model.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 定义返回客户端的JSON对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonDataResult {
    /**
     * 操作状态  1-车台旋转中, 2-车台位置就绪, 3-操作完成
     */
    private String operatingType;
    /**
     * 工控机状态 1-空置,2-工作中, 9-严重错误
     */
    private String machineStatus;
    /**
     * 运行状态 1-无操作, 2-取车操作, 3-存车操作, 4-预约取车, 5-取车完成后，配载操作
     */
    private String operationStatus;

    /**
     * 车牌号
     */
    private String carCode;

    /**
     * 结果类型 0.操作成功 1.临停未支付 2. 二维码识别中 3. 二维码/密码有误 4. 月租车位过期
     */
    private String result;
    /**
     * 内外摄像头 0. 外摄像头 1.内摄像头
     */
    private String sideType;
    /**
     * 目标旋转车台
     */
    private String targetLot;

    /**
     * 汽车车牌
     */
    private List<Map<String, String>> carCodes;

}
