package com.fangda.skylot.mathine.model.parking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TstbMathineParkingLog implements Serializable {
    /**
     * 停车日志序号
     */
    private Integer tmplId;
    /**
     * 关系表序号
     */
    private String imaId;
    /**
     * 停车汽车号牌
     */
    private String tmplCar;
    /**
     * 停车位置物理代码
     */
    private String tmplPhysicalCode;
    /**
     * 停车用户名
     */
    private String tmplCustomer;
    /**
     * 停车类型
     */
    private String tmplType;
    /**
     * 状态
     */
    private String tmplStatus;
    /**
     * 创建时间
     */
    private String tmplCreatedate;
    /**
     * 创建人
     */
    private String tmplCreateuser;
    /**
     * 更新时间
     */
    private String tmplUpdatedate;
    /**
     * 更新人
     */
    private String tmplUpdateuser;
    /**
     * 停车结束时间
     */
    private String endTime;
    /**
     * 设备ID
     */
    private String imaName;
    /**
     * 旋转方向 1:正转,2:反转
     */
    private String tmplDiectionCode;
    /**
     * 停取车总耗时
     */
    private String tmplOperationDuriationTotal;
    /**
     * 停取车转动耗时
     */
    private String tmplOperationDuriationRouting;
    /**
     * 停取车操作耗时
     */
    private String tmplOperationDuriationManually;
    /**
     * 荷载操作耗时
     */
    private String tmplOperationDuriationWeighting;
    /**
     * 停取车之前最下方车位编号
     */
    private String tmplOperationDownCode;
    /**
     * 停取车荷载车位编号
     */
    private String tmplOperationWeightingCode;
    /**
     * 停取车耗电量
     */
    private String tmplOperationEnergyCost;

}