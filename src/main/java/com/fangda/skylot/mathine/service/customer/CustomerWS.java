/***********************************************************************
 * Module:  CustomerWS.java
 * Author:  saul
 * Purpose: Defines the Interface CustomerWS
 ***********************************************************************/

package com.fangda.skylot.mathine.service.customer;

import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;

/** 用户信息同步WS接口
 * 
 * 被动同步
 * 
 * @pdOid 720d4f7f-fd72-4453-b3a0-32fe402c2a23 */
public interface CustomerWS extends IBaseService<MstbCustomer, MstbCustomerCriteria> {
   /** 同步用户购买车位信息
    * 
    * 验证key是否正确
    * 如果正确进行同步
    * 分别插入或者更新3个参数里面的信息
    * 客户信息
    * 设备信息
    * 设备购买信息
    * 每次执行一次同步之后需要调用一次同步日志
    * 全部执行完成，如没有异常则返回0
    * 异常返回-1
    * 
    * @param cus 客户信息
    * JSON格式
    * 
    * [{}]存放多个客户信息
    * @param ima 设备信息
    * JSON格式
    * 
    * [{}]存放多个设备信息
    * @param maCus 客户购买车位信息
    * JSON格式
    * 
    * [{}]存放多个客户购买车位信息
    * @param key 加密密钥
    * @exception SkyLotException
    * @pdOid 37d6d1d7-4a8d-4c24-9c17-c2901d228fe5 */
   int toSyncCustomerData(String cus, String omi, String maCus, String ima, String tmp, String key) throws SkyLotException;
   /** 同步用户绑定的车牌信息
    * 
    * @param cus
    * @pdOid f91a4dd7-de97-4f41-be7c-4f96a547db65 */
   int toSyncCustomerCar(String cus) throws SkyLotException;

   String toPulling(String cusId, String carId, String maId, String key) throws SkyLotException;

   int toSyncOperationLog(String operationLog) throws SkyLotException;

}