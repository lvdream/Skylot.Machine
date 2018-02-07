package com.fangda.skylot.mathine.service;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.math.ParkingLogic;

import java.util.Map;

/**
 * Created by Saul on 08/06/2017.
 */
public interface SocketService {
    /**
     * 获取当前PLC的状态
     *
     * @param bType      状态查询:2,查询停车:0,查询取车:1,车库门打开:3,车库门关闭:4,人行门打开:5,获取整体状态:6,心跳查询:9
     * @param followLoop 是否使用自身循环
     * @return 0, 正常, 1, 无法使用
     * @throws SkyLotException
     */
    int confirmStatus(int bType, boolean... followLoop) throws SkyLotException;

    /**
     * 获取当前PLC设备的全部状态
     *
     * @return operationStatus:{0,空闲;1:运作中;2:异常故障},businessStatus:{0,停车中;1:取车中;2:荷载中}
     * @throws SkyLotException
     */
    Map getAllStatus(boolean... getDirection) throws SkyLotException;

    /**
     * 获取当前停车状态
     *
     * @return 0, 有空位, 1, 没有空位
     */
    int enableParking() throws SkyLotException;

    /**
     * 进行停车
     *
     * @return iStatus:0, 停车成功, 1, 停车失败;iParkingLocation:停车位置;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     */
    Map doParking(String carNumber, boolean firstPark) throws SkyLotException;

    /**
     * 进行取车
     *
     * @return iStatus:0, 停车成功, 1, 停车失败;iDirection:待旋转到最下方车位;BaseNumber:操作之前最下方车位编号;iParkingStatus:当前停车状态
     */
    Map doPulling(String positionNumber, boolean firstPull) throws SkyLotException;


    /**
     * 获取1005号位置的,错误信息,依据此判断是否可以进行存车完成状态
     *
     * @return
     * @throws SkyLotException
     */
    Map getIndexError() throws SkyLotException;

    /**
     * * 获取1007号位置的,错误信息,依据此判断是否可以进行存车完成状态
     *
     * @return
     * @throws SkyLotException
     */
    Map pullIndexError() throws SkyLotException;


    /**
     * 车库门开关
     *
     * @param actionType 0,开门,1,关门
     * @return
     * @throws SkyLotException
     */
    int carDoor(String actionType) throws SkyLotException;

    /**
     * 人行门打开方法
     *
     * @param actionType
     * @return
     * @throws SkyLotException
     */
    int peopleDoor(String actionType) throws SkyLotException;

    /**
     * 配重
     *
     * @param number
     * @param parkingLogic
     * @return
     */
    int doDirection(int number, ParkingLogic parkingLogic);

    /**
     * 获取严重故障
     *
     * @return
     * @throws SkyLotException
     */
    int getHighErrorStatus() throws SkyLotException;

    /**
     * 写车牌
     *
     * @param carCode 车牌
     * @return
     * @throws SkyLotException
     */
    int writeCarcode(String carCode) throws SkyLotException;


    /**
     * 取消存取车,操作
     *
     * @param actionType 0,存车;1:取车
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    int cancelAction(String actionType) throws SkyLotException;

    /**
     * 获取停车状态列表
     *
     * @param Type 0:获取数据来自停车数据库,1:获取数据来自PLC
     * @return 0, 操作成功,-1操作失败,-2,操作超时
     * @throws SkyLotException
     */
    Map getParkingStatus(int Type) throws SkyLotException;

    /**
     * 获取PLC一般故障
     *
     * @return Map
     * @throws SkyLotException
     */
    Map getNormalErrorStatus() throws SkyLotException;
}
