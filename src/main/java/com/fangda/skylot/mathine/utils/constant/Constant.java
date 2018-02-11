/***********************************************************************
 * Module:  Constant.java
 * Author:  saul
 * Purpose: Defines the Class Constant
 ***********************************************************************/

package com.fangda.skylot.mathine.utils.constant;

/**
 * 项目静态常量定义
 * <p>
 * c2fdcf1e-45cf-4856-b64e-082e332196e9
 */
public final class Constant {
    /**
     * 定义系统默认工作模式,0:测试模式,1:正常工作模式
     * 方法默认返回值
     * 成功
     * <p>
     * 940b1295-b95b-4cad-a36c-a4611347d897
     */
    public static final String SYSTEM_WORKING_MODEL_TEST = "0";
    public static final String SYSTEM_WORKING_MODEL_NORMAL = "1";


    /**
     * 定义存取车汉字对应的动作
     */
    public static final String BUSINESS_ACTION_TYPE_PULL = "取车";
    public static final String BUSINESS_ACTION_TYPE_PARK = "存车";
    /**
     * 定义常用静态变量
     * 方法默认返回值
     * 成功
     * <p>
     * 940b1295-b95b-4cad-a36c-a4611347d897
     */
    public static final String FN_RETURN_STATUS_SUCCESS = "0";
    /**
     * 定义常用静态变量
     * 方法默认返回值
     * 失败
     * <p>
     * a2c3b443-7963-497e-b108-3ef05ca49fb5
     */
    public static final String FN_RETURN_STATUS_ERROR = "1";
    /**
     * 方法默认返回值
     * 处理中
     */
    public static final String FN_RETURN_STATUS_HANDLE = "2";
    /**
     * 方法默认返回值
     * 超时
     */
    public static final String FN_RETURN_STATUS_TIMEOUT = "-2";
    /**
     * 判定同步是否失败时长（单位：分钟）
     */
    public static final int TIMEOUT_OF_SYNCHRONIZE = 10;
    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
    /**
     * 定义常用静态变量
     * 方法默认返回值
     * 异常
     * <p>
     * 6c1fc1a5-da35-4f1f-9fcc-f5f44f6d6a6f
     */
    public static final String FN_RETURN_STATUS_EXCEPTION = "-1";
    /**
     * webservice定义
     * <p>
     * 7a452628-7b3c-407e-9676-36951820e37e
     */
    public static final String WEB_SERVICE_NS = "http://soap.webservice.mathine.skylot.fangda.com";
    /**
     * P02，当前用户没有该停车设备的授权（用户还没有购买当前设备的车位）
     * <p>
     * eeeac1b6-baa6-4aa7-bf4f-300bcda95ebe
     */
    public static final String EX_PARKING_USER_AUTH_IN_MATHINE = "P02";
    /**
     * P03，用户购买的停车设备授权已过期或未开始
     * <p>
     * 07588d4b-a4d4-4fbc-bc71-98fbacc4f580
     */
    public static final String EX_PARKING_USER_AUTH_OUT_SERVICE = "P03";
    /**
     * P04，当前车牌已被禁用
     * <p>
     * eba386c3-75a6-4303-a475-93829b47a668
     */
    public static final String EX_PARKING_USER_CAR_NO_ACCESS = "P04";
    /**
     * P05，当前设备故障
     * <p>
     * 751e1fa1-ec5d-4ba2-828b-69f5c31b793d
     */
    public static final String EX_PARKING_MATHINE_EXCEPTION = "P05";
    /**
     * P06，当前设备没有可用车位
     * <p>
     * 44aec941-1bed-40bf-b579-6c71496499f6
     */
    public static final String EX_PARKING_MATHINE_NOT_AVIABLE = "P06";
    /**
     * 没有查询到需要取得车辆,P21，当前设备故障
     * <p>
     * eecf80ae-376f-476f-b247-c1c0994d50ba
     */
    public static final String EX_PULLING_NO_CAR_IN_SEARCH = "P21";
    /**
     * P22，当前设备故障
     * <p>
     * 331d0d6e-7510-4c71-8f6d-577f5522a949
     */
    public static final String EX_PULLING_MATHINE_EXCEPTION = "P22";
    /**
     * P23，当前设备忙，（正在运作前一个命令）
     * <p>
     * ceb9237c-4ae3-47b0-b5e7-65f2f8e9e43a
     */
    public static final String EX_PULLING_MATHINE_IN_PROCESS = "P23";
    /**
     * P01，当前用户没有授权（车牌信息查询不到）
     * <p>
     * e2e2f56b-0d34-4bf6-b951-188d5b73b255
     */
    public static final String EX_PARKING_USER_NO_AUTH = "P01";
    /**
     * P07，当前设备忙，（正在运作前一个命令）
     * <p>
     * 3ad29583-ffa8-4a35-ac86-d3975909dff4
     */
    public static final String EX_PARKING_MATHINE_IN_PROCESS = "P07";
    /**
     * 摄像机停车时间判定（超过5秒视为准备停车）
     */
    public static final int EX_PARKING_CAMERA_TIME = 2;
    /**
     * 该车位已被其它车辆使用
     */
    public static final String EX_PARKING_CARPORT_USED = "P08";
    /**
     * 该用户在该设备已无可用车位
     */
    public static final String EX_PARKING_ACTION_NO = "P09";
    /**
     * 该车已存在
     */
    public static final String EX_PARKING_CAR_EXIST = "P10";

    //自动任务定义
    /**
     * 添加数据
     */
    public static final String SCHEDULEACTION_TYPE_ADD = "0";
    /**
     * 修改数据
     */
    public static final String SCHEDULEACTION_TYPE_UPDATE = "1";
    /**
     * 删除数据
     */
    public static final String SCHEDULEACTION_TYPE_DELETE = "2";
    /**
     * 同步类型
     */
    public static final String SCHEDULEACTION_TYPE_HEARTBEAT = "SCHEDULEACTION_TYPE_HEARTBEAT";

    /**
     * 同步对象状态
     */
    public static final String SCHEDULEACTION_TYPE_ITEM = "SCHEDULEACTION_TYPE_ITEM";
    /**
     * 同步SCHEDULEACTION_MESSAGE
     */
    public static final String SCHEDULEACTION_MESSAGE = "SCHEDULEACTION_MESSAGE";
    /**
     * 心跳同步(PLC)
     */
    public static final String SCHEDULEACTION_TYPE_HEARTBEAT_PLC = "2";
    /**
     * 心跳同步(Server)
     */
    public static final String SCHEDULEACTION_TYPE_HEARTBEAT_SERVER = "3";
    /**
     * 同步完成
     */
    public static final String SCHEDULEACTION_STATUS_FINISH = "2";
    /**
     * 同步计划
     */
    public static final String SCHEDULEACTION_STATUS_PLAN = "0";
    /**
     * 同步进行中
     */
    public static final String SCHEDULEACTION_STATUS_IN_PROGRESS = "1";
    /**
     * 同步失败
     */
    public static final String SCHEDULEACTION_STATUS_ERROR = "3";

    //业务类型
    /**
     * customer
     */
    public static final String SCHEDULEACTION_BUSINESSOBJ_CUSTOMER = "customer";
    /**
     * machine
     */
    public static final String SCHEDULEACTION_BUSINESSOBJ_MACHINE = "IftbMachineAction";

    //子业务模块序号
    /**
     * customer
     */
    public static final String SCHEDULEACTION_MODULEID_CUSTOMER = "0";
    /**
     * customerCar
     */
    public static final String SCHEDULEACTION_MODULEID_CUSTOMERCAR = "1";
    /**
     * itemCustomer
     */
    public static final String SCHEDULEACTION_MODULEID_ITEMCUSTOMER = "2";
    /**
     * machineItem
     */
    public static final String SCHEDULEACTION_MODULEID_MACHINEITEM = "3";
    /**
     * machineAction
     */
    public static final String SCHEDULEACTION_MODULEID_MACHINEACTION = "4";
    /**
     * machineParking
     */
    public static final String SCHEDULEACTION_MODULEID_MACHINEPARKING = "5";

    /**
     * 停取车操作定义：停取车中
     */
    public static final String PARKING_PULLING_STATUS_PROGRESS = "1";
    /**
     * 停取车操作定义：停取车完成
     */
    public static final String PARKING_PULLING_STATUS_FINISH = "0";
    /**
     * 心跳同步间隔时长（单位：分钟）
     */
    public static final int SYNC_OF_HEARTBEAT_TIME = 1;

    /**
     * 设备旋转方向
     */
    public static final String MACHINEACTION_DIRECTION_CODE = "direction_code";
    /**
     * 设备旋转方向--逆时针
     */
    public static final String MACHINEACTION_DIRECTION_CODE_ANTICLOCKWISE = "2";

    /**
     * 设备旋转方向--顺时针
     */
    public static final String MACHINEACTION_DIRECTION_CODE_CLOCKWISE = "1";

    /**
     * PLC物理车位
     */
    public static final String PARKING_PHYSICALCODE_TWO = "02";

    /**
     * 停车类型
     */
    public static final String MACHINEPARKING_TYPE_PARK = "0";

    public static final String MACHINEPARKING_TYPE_TAKE = "1";

    /**
     * 设备类型,临停设备
     */
    public static final String MACHINEPARKING_TYPE_TEMPLATE = "1";

    /**
     * 设备类型,月租设备
     */
    public static final String MACHINEPARKING_TYPE_FIXPRICE = "0";
    /**
     * 设备可以停车数量 // TODO: 27/07/2017 停车数量写死 12
     */
    public static final String MACHINEPARKING_QUANTITY = "12";

    /**
     * PLC通信,头信息
     */
    public static final String PLC_COMMUNACAITON_HEAD = "46494E530000000C0000000000000000000000";
    /**
     * PLC通信,头信息--验证
     */
    public static final String PLC_COMMUNACAITON_HEAD_VERIFY = "46494E5300000010000000010000";
    /**
     * PLC通信,头信息_停车
     */
    public static final String PLC_COMMUNACAITON_HEAD_PARKING = "46494E5300000020000000020000000080000200010000";
    /**
     * PLC通信,头信息_取车
     */
    public static final String PLC_COMMUNACAITON_HEAD_PULLING = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_车牌
     */
    public static final String PLC_COMMUNACAITON_HEAD_CAR_CODE = "46494E530000002E000000020000000080000200010000";
    /**
     * PLC通信,头信息_车位状态
     */
    public static final String PLC_COMMUNACAITON_HEAD_PARKING_STATUS = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_最下方车板编号
     */
    public static final String PLC_COMMUNACAITON_HEAD_BASE_NUMBER = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_旋转
     */
    public static final String PLC_COMMUNACAITON_HEAD_DIRECTION = "46494E5300000020000000020000000080000200010000";
    /**
     * PLC通信,头信息_整体状态
     */
    public static final String PLC_COMMUNACAITON_HEAD_STATUS = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_故障状态
     */
    public static final String PLC_COMMUNACAITON_HEAD_ERROR_STATUS = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_故障状态
     */
    public static final String PLC_COMMUNACAITON_HEAD_ERROR_NORMAL_STATUS = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,头信息_故障状态
     */
    public static final String PLC_COMMUNACAITON_HEAD_ALL_INDEX_STATUS = "46494E530000001A000000020000000080000200010000";
    /**
     * PLC通信,模式改变
     */
    public static final String PLC_COMMUNACAITON_HEAD_MODEL_CHANGE = "46494E530000001C000000020000000080000200010000";
    /**
     * PLC通信,车库门
     */
    public static final String PLC_COMMUNACAITON_HEAD_CAR_DOOR = "46494E530000001C000000020000000080000200010000";
    /**
     * PLC通信,取消指令
     */
    public static final String PLC_COMMUNACAITON_HEAD_CANCEL_ACTION = "46494E530000001C000000020000000080000200010000";
    /**
     * PLC通信,人行门
     */
    public static final String PLC_COMMUNACAITON_HEAD_PEOPLE_DOOR = "46494E530000001C000000020000000080000200010000";


    /**
     * PLC通信,异常,获取最下停车位错误
     */
    public static final String PLC_EXCEPTION_PARKING_GET_BASE_ITEM_ERROR = "0";
    /**
     * PLC通信,异常,获取设备停车位数错误
     */
    public static final String PLC_EXCEPTION_PARKING_GET_TOTAL_MACHINE_COUNT = "1";
    /**
     * PLC通信,异常,获取设备停车位状态错误
     */
    public static final String PLC_EXCEPTION_PARKING_GET_PARKING_STATUS = "1";
    /**
     * PLC通信,异常,获取长度错误
     */
    public static final String PLC_EXCEPTION_COMMUNACAITON_LENGTH_ERROR = "-1";


    /**
     * Map 对象,标示停取车中的key定义,停车命令,执行状态
     */
    public static final String MAP_PARKING_STATUS = "iStatus";

    /**
     * Map 对象,标示停取车中的key定义,停车位置信息
     */
    public static final String MAP_PARKING_CAR_PARKING_STATUS = "iParkingStatus";
    /**
     * Map 对象,标示停取车中的key定义,待停车位置
     */
    public static final String MAP_PARKING_LOCATION = "iParkingLocation";
    /**
     * Map 对象,标示停取车中的key定义,待转向位置
     */
    public static final String MAP_PARKING_DIRECTION = "iDirection";
    /**
     * Map 对象,标示停取车,总耗时
     */
    public static final String MAP_TIME_SPEND_ALL = "timeSpendAll";
    /**
     * Map 对象,标示停取车,旋转耗时
     */
    public static final String MAP_TIME_SPEND_DIRECTION = "timeSpendDirection";
    /**
     * Map 对象,标示停取车,停取车耗时
     */
    public static final String MAP_TIME_SPEND_DOING = "timeSpendDoing";
    /**
     * Map 对象,标示停取车,荷载耗时
     */
    public static final String MAP_TIME_SPEND_WEIGHT = "timeSpendWeight";
    /**
     * Map 对象,标示停取车,耗电量
     */
    public static final String MAP_ENERGY = "energy";
    /**
     * Map 对象,标示停取车,耗电量_荷载
     */
    public static final String MAP_ENERGY_DIRECTION = "energyDirection";
    /**
     * Map 对象,标示停取车中的key定义,最下方车位
     */
    public static final String MAP_PARKING_BASENUMBER = "BaseNumber";

    /**
     * Map 对象,标示二维码对象的Key定义,mcId,客户序号
     */
    public static final String MAP_QRCODE_MCID = "mcId";
    /**
     * Map 对象,标示二维码对象的Key定义,车牌
     */
    public static final String MAP_QRCODE_CARCODE = "carCode";
    /**
     * Map 对象,标示二维码对象的Key定义,项目序号
     */
    public static final String MAP_QRCODE_MAID = "maId";
    /**
     * Map 对象,标示二维码对象的Key定义,机器编号
     */
    public static final String MAP_QRCODE_IMAID = "imaId";
    /**
     * Map 对象,标示二维码对象的Key定义,逻辑停车位置
     */
    public static final String MAP_QRCODE_PHYSICALCODE = "physicalCode";
    /**
     * Map 对象,标示二维码对象的Key定义,密码
     */
    public static final String MAP_QRCODE_PASSWORD = "password";
    /**
     * Map 对象,标示二维码对象的Key定义,有效截止日期
     */
    public static final String MAP_QRCODE_ENDDATE = "enddate";

    /**
     * String 对象,标示Exception针对business_code
     */
    public static final String STR_EXCEPTION_BUSINESS_CODE = "business_code";

    /**
     * 指令,取消存车指令
     */
    public static final String CMD_STR_CANCEL_PARK = "0";
    /**
     * 指令,取消取车指令
     */
    public static final String CMD_STR_CANCEL_EXTRACT = "1";
}