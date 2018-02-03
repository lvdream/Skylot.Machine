package com.fangda.skylot.mathine.service.impl.parking;

import com.fangda.skylot.mathine.dao.parking.TstbMathineParkingLogDAO;
import com.fangda.skylot.mathine.model.parking.*;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.ParkingLogService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.DateUtil;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.MarqueeUtil;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.ftp.FtpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

@Transactional
@Service("parkinglogService")
@Slf4j
public class ParkingLogServiceImpl extends BaseServiceImpl<TstbMathineParkingLog, TstbMathineParkingLogCriteria> implements ParkingLogService {
    @Autowired
    public void setBaseDao(TstbMathineParkingLogDAO tstbMathineParkingLogDao) {
        super.setBaseDao(tstbMathineParkingLogDao);
    }

    @Autowired
    private SyncService syncServiceImpl;
    @Autowired
    FtpUtils ftpUtils;
    private Logger loggerParking = Logger.getLogger("Parking");
    @Autowired
    private MarqueeUtil marqueeUtil;

    @Override
    public int parkingFromCallbak(Map map) throws Exception {
        if (MapUtils.isNotEmpty(map)) {
            Map alarmInfoPlateMap = MapUtils.getMap(map, "AlarmInfoPlate");
            if (MapUtils.isNotEmpty(alarmInfoPlateMap)) {
                Map resultMap = MapUtils.getMap(alarmInfoPlateMap, "result");
                if (MapUtils.isNotEmpty(resultMap)) {
                    Map plateResultMap = MapUtils.getMap(resultMap, "PlateResult");
                    if (MapUtils.isNotEmpty(plateResultMap)) {
                        String actualName = MapUtils.getString(plateResultMap, "license");
                        //验证车牌号
                        String rex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4,5}[A-Z0-9挂学警港澳]{1}$";
                        if (!Pattern.compile(rex).matcher(actualName).find()) {//// TODO: 21/12/2017 车牌验证规则需要更新,如果武警和使馆
                            return 1;
                        } else {
                            TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
                            carInformationCriteria.setOrderByClause("tfc_id asc");
                            List dataList = serviceMap.get("ftpcarService").queryForAll(carInformationCriteria);
                            if (CollectionUtils.isNotEmpty(dataList)) {
                                TstbFtpCarInformation tstbFtpCarInformation = (TstbFtpCarInformation) dataList.get(0);
                                tstbFtpCarInformation.setTfcCarInCode(actualName);
                                tstbFtpCarInformation.setTfcUpdatetime(DateUtil.getNowDate());
                                tstbFtpCarInformation.setTfcStatus(1);
                                carInformationCriteria.createCriteria().andTfcIdEqualTo(tstbFtpCarInformation.getTfcId());
                                serviceMap.get("ftpcarService").update(tstbFtpCarInformation, carInformationCriteria);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public int parkingAction(String parkingCar, boolean firstPark) throws Exception {
        TstbFtpCarInformationCriteria carInformationCriteria = new TstbFtpCarInformationCriteria();
        TstbFtpCarInformation tstbFtpCarInformation = TstbFtpCarInformation.builder().build();
        tstbFtpCarInformation.setTfcCarCode(parkingCar);
        tstbFtpCarInformation.setTfcCreatetime(SkylotUtils.getStrDate());
        tstbFtpCarInformation.setTfcStatus(NumberUtils.toInt(PARKING_PULLING_STATUS_PROGRESS));//进入停车流程
        tstbFtpCarInformation.setTfcCarAction(PARKING_PULLING_STATUS_FINISH);
        tstbFtpCarInformation.setTfcCreateuser("auto");
        tstbFtpCarInformation.setImaId(GetProperties.getProperties("system.properties", "skylot.machine.id"));
        //验证车牌号
        String rex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4,5}[A-Z0-9挂学警港澳]{1}$";
        if (!Pattern.compile(rex).matcher(parkingCar).find()) {//// TODO: 21/12/2017 车牌验证规则需要更新,如果武警和使馆
            return 1;
        }
        try {
            //查询ima设备是否可以停车
            IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
            criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
            IftbMachineAction iftbMachineAction = (IftbMachineAction) serviceMap.get("machineActionService").query(criteria);
            if (iftbMachineAction != null) {
                if (StringUtils.equals(FN_RETURN_STATUS_ERROR, iftbMachineAction.getImaPhysicalStatus())) {
                    marqueeUtil.sendText("错误", "当前设备暂停服务!", true);
                    return 1;
                }
            } else {
                marqueeUtil.sendText("错误", "当前设备暂时无法提供服务!", true);
                return 1;
            }
            //查询是否有车正在进行停车操作
            carInformationCriteria.createCriteria().andTfcStatusEqualTo(NumberUtils.toInt(PARKING_PULLING_STATUS_PROGRESS));
            TstbFtpCarInformation ftpCarInformation = (TstbFtpCarInformation) serviceMap.get("ftpcarService").query(carInformationCriteria);
            if (null != ftpCarInformation && !StringUtils.equals(ftpCarInformation.getTfcCarCode(), parkingCar)) {
                loggerParking.warn("当前已有车辆正在停车,请稍后");
                marqueeUtil.sendText("错误", "当前已有车辆正在停车,请稍后", true);
                ftpUtils.removeFile(parkingCar);
            }
            if (syncServiceImpl.checkCarFromDB(parkingCar) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//检查车辆是否授权
                if (syncServiceImpl.getParkingPhysicalCode(parkingCar) == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {//检查车辆是否已经停车
                    serviceMap.get("ftpcarService").add(tstbFtpCarInformation);//存储识别到的车牌号

                } else {
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],车牌[" + parkingCar + "],不能重复停车");
                    marqueeUtil.sendText("错误", parkingCar + "不能重复停车", true);
                    return NumberUtils.toInt(FN_RETURN_STATUS_HANDLE);//车辆已经在停车台上
                }
            } else {
                loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],车牌[" + parkingCar + "]没有授权");
                marqueeUtil.sendText("错误", parkingCar + "没有授权", true);
                return NumberUtils.toInt(FN_RETURN_STATUS_ERROR);
            }

        } catch (Exception e) {
            if (StringUtils.contains(e.getMessage(), "HY400")) {//可以识别的车辆大于2
                loggerParking.warn("无法处理大于数量2的停车请求");
            } else {
                throw new SkyLotException(e);
            }
        } finally {
            ftpUtils.removeFile(parkingCar);
        }
        return 0;
    }

    /**
     * 处理消息的显示
     *
     * @param statusMap 状态Map
     * @param action    操作类型
     * @return StringBuilder
     */
    public StringBuilder layoutMessage(Map statusMap, String action) {
        StringBuilder stringBuilder = new StringBuilder();
        String message = "";
        stringBuilder.append(MapUtils.getIntValue(statusMap, MAP_PARKING_STATUS)).append(",");
        switch (MapUtils.getIntValue(statusMap, MAP_PARKING_STATUS)) {
            case -1:
                message = "系统异常";
                break;
            case 1:
                message = "当前用户没有该停车设备的授权";
                break;
            case 2:
                message = "当前设备故障";
                break;
            case 3:
                message = action.equals("取车") ? "没有查询到需要取得车辆" : "当前车牌不能重复存车!";
                break;
            case 4:
                message = action.equals("存车") ? "当前停车设备没有可用停车位" : "";
                break;
            default:
                message = action.equals("存车") ? "成功" : "取车成功";
                break;
        }
        stringBuilder.append(message).append(",");
        stringBuilder.append(SkylotUtils.getStrDate()).append(",");
        stringBuilder.append("停车位置").append(MapUtils.getString(statusMap, MAP_PARKING_LOCATION, "")).append(",");
        stringBuilder.append("最下方车位").append(MapUtils.getString(statusMap, MAP_PARKING_BASENUMBER, "")).append(",");
        stringBuilder.append("转向车位").append(MapUtils.getString(statusMap, MAP_PARKING_DIRECTION, "")).append(",");
        stringBuilder.append("总耗时").append(MapUtils.getString(statusMap, MAP_TIME_SPEND_ALL, "")).append(",");
        stringBuilder.append("停取操作耗时").append(MapUtils.getString(statusMap, MAP_TIME_SPEND_DOING, "")).append(",");
        stringBuilder.append("旋转耗时").append(MapUtils.getString(statusMap, MAP_TIME_SPEND_DIRECTION, "")).append(",");
        stringBuilder.append("荷载耗时").append(MapUtils.getString(statusMap, MAP_TIME_SPEND_WEIGHT, "")).append(",");
        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],本次操作结束,操作总耗时[" + MapUtils.getString(statusMap, MAP_TIME_SPEND_ALL, "") + "]");
        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],本次操作结束,停取操作耗时[" + MapUtils.getString(statusMap, MAP_TIME_SPEND_DOING, "") + "]");
        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],本次操作结束,旋转耗时[" + MapUtils.getString(statusMap, MAP_TIME_SPEND_DIRECTION, "") + "]");
        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],本次操作结束,荷载耗时[" + MapUtils.getString(statusMap, MAP_TIME_SPEND_WEIGHT, "") + "]");
        loggerParking.warn("**************************************************************");
        stringBuilder.append("存车用").append(MapUtils.getString(statusMap, "basenumber_save", ""));
        log.warn(stringBuilder.toString());
        return stringBuilder;
    }
}
