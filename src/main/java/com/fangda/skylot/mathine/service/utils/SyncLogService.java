/***********************************************************************
 * Module:  SyncLogService.java
 * Author:  saul
 * Purpose: Defines the Interface SyncLogService
 ***********************************************************************/

package com.fangda.skylot.mathine.service.utils;

import java.util.Map;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;

/** 同步日志服务接口
 * 
 * @pdOid ab4f916b-f07d-4386-b58e-48abb9c8129b */
public interface SyncLogService {
   /** 保存同步日志
    * 
    * @param object
    * @exception SkyLotExcetion
    * @pdOid 2233b35c-3b63-47ff-93e8-364388d4d11c */
   int saveLog(Object object) throws SkyLotException;
   /** 检查上一次主动同步状态
    * 
    * Map(
    * Key:status
    * Key:lastCreatetime
    * )
    * status:
    * 0成功
    * 1失败
    * 2处理中
    * lastCreatetime:
    * yyyy-MM-dd hh:mm:ss
    * 
    * 
    * @exception SkylotException
    * @pdOid 06544bc1-664d-4f06-ad0e-f906af150670 */
   Map isSuccessSyncProcess() throws SkyLotException;
   /** 将上一次自动主体同步的日志记录改为失败状态
    * 
    * @exception com.fangda.skylot.mathine.utils.exception.SkyLotException
    * @pdOid c60ee9ce-b7de-470f-8a33-53a070164eb1 */
   int setFailed() throws SkyLotException;

}