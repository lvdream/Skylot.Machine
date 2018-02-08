package com.fangda.skylot.mathine.service.impl.customer;

import com.fangda.skylot.mathine.dao.IBaseDao;
import com.fangda.skylot.mathine.dao.customer.OftbCodeInfoDAO;
import com.fangda.skylot.mathine.model.customer.MstbCustomer;
import com.fangda.skylot.mathine.model.customer.MstbCustomerCriteria;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfo;
import com.fangda.skylot.mathine.model.customer.OftbCodeInfoCriteria;
import com.fangda.skylot.mathine.model.parking.*;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.CodeInfoService;
import com.fangda.skylot.mathine.service.customer.CustomerService;
import com.fangda.skylot.mathine.service.impl.BaseServiceImpl;
import com.fangda.skylot.mathine.service.parking.FTPCarService;
import com.fangda.skylot.mathine.service.parking.MachineActionService;
import com.fangda.skylot.mathine.service.parking.ParkingService;
import com.fangda.skylot.mathine.utils.DateUtil;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

@Slf4j
@Transactional
@Service("codeInfoService")
public class CodeInfoServiceImpl extends BaseServiceImpl<OftbCodeInfo, OftbCodeInfoCriteria>
        implements CodeInfoService {
    @Autowired
    private Map<String, IBaseService> serviceMap;
    @Autowired
    private Map<String, IBaseDao> daoMap;

    @Autowired
    public void setBaseDao(OftbCodeInfoDAO codeInfoDao) {
        super.setBaseDao(codeInfoDao);
    }


    /**
     * 验证密码或者二维码
     *
     * @param originalCode 原始代码,支持密码或者二维码
     * @param canceled     是否验证取消操作
     * @return 0.操作成功 1.临停未支付 2. 二维码/密码有误 3. 月租车位过期
     * @throws Exception
     */
    @Override
    public Map verifyCode(String originalCode, boolean canceled) throws Exception {
        Map resultMap = Maps.newHashMap();
        try {
            Map map = SkylotUtils.verifyCode(originalCode);
            if (MapUtils.isEmpty(map)) {
                OftbCodeInfoCriteria codeInfoCriteria = new OftbCodeInfoCriteria();
                codeInfoCriteria.createCriteria().andOciPasswordEqualTo(originalCode);
                OftbCodeInfo oftbCodeInfo = ((OftbCodeInfoDAO) daoMap.get("codeInfoDao")).ReadSingle(codeInfoCriteria);
                if (oftbCodeInfo != null) {
                    map = SkylotUtils.verifyCode(oftbCodeInfo.getOciCodeUrl());
                }
            }
            if (MapUtils.isNotEmpty(map)) {
                if (StringUtils.equals(SkylotUtils.imaId, MapUtils.getString(map, MAP_QRCODE_IMAID))) {//比较IMA是否一致
                    //获取当前设备所属类型,是否临停,还是月租
                    IftbMachineActionCriteria criteria = new IftbMachineActionCriteria();
                    criteria.createCriteria().andImaIdEqualTo(SkylotUtils.imaId);
                    IftbMachineAction iftbMachineAction = ((MachineActionService) serviceMap.get("machineActionService")).query(criteria);
                    if (iftbMachineAction != null) {
                        Date veriableDate = DateUtil.strToDateLong(MapUtils.getString(map, MAP_QRCODE_ENDDATE));
                        Date systemDate = DateUtil.strToDateLong(DateUtil.getNowDate());
                        resultMap.put(SCHEDULEACTION_BUSINESSOBJ_CUSTOMER, MapUtils.getString(map, MAP_QRCODE_CARCODE));
                        if (!canceled) {
                            boolean dateBoolean = veriableDate.after(systemDate);
                            if (!dateBoolean) {//二维码有效期小于当前系统时间
                                if (iftbMachineAction.getImaCode().equals("0")) {//月租
                                    resultMap.put(MAP_PARKING_STATUS, SCHEDULEACTION_STATUS_ERROR);
                                } else {//临停
                                    resultMap.put(MAP_PARKING_STATUS, FN_RETURN_STATUS_ERROR);
                                }
                            }
                        }
                        TstbMathineParkingCriteria tstbMathineParkingCriteria = new TstbMathineParkingCriteria();
                        tstbMathineParkingCriteria.createCriteria().andTmpCarCodeEqualTo(MapUtils.getString(map, MAP_QRCODE_CARCODE)).andTmpPhysicalCodeLike(MapUtils.getString(map, MAP_QRCODE_PHYSICALCODE));
                        //判断车牌和位置
                        TstbMathineParking parking = ((ParkingService) serviceMap.get("parkingService")).query(tstbMathineParkingCriteria);
                        if (null != parking) {
                            //判断用户,月租用户需要判断
                            resultMap.put(MAP_PARKING_STATUS, FN_RETURN_STATUS_SUCCESS);
                            if (iftbMachineAction.getImaCode().equals("0")) {//月租
                                MstbCustomerCriteria customerCriteria = new MstbCustomerCriteria();
                                customerCriteria.createCriteria().andMcIdEqualTo(NumberUtils.toInt(MapUtils.getString(map, MAP_QRCODE_MCID)));
                                MstbCustomer customer = ((CustomerService) serviceMap.get("customerService")).query(customerCriteria);
                                if (null == customer) {
                                    resultMap.put(MAP_PARKING_STATUS, FN_RETURN_STATUS_HANDLE);
                                }
                            }
                        }
                        if (canceled) {//检查是否要取消停车
                            TstbFtpCarInformationCriteria tstbFtpCarInformationCriteria = new TstbFtpCarInformationCriteria();
                            tstbFtpCarInformationCriteria.createCriteria().andTfcCarCodeEqualTo(MapUtils.getString(map, MAP_QRCODE_CARCODE));//当前扫描的二维码是不是当前要取得汽车
                            List dataList = ((FTPCarService) serviceMap.get("ftpcarService")).queryForAll(tstbFtpCarInformationCriteria);
                            if (CollectionUtils.isEmpty(dataList)) {
                                resultMap.put(MAP_PARKING_STATUS, FN_RETURN_STATUS_HANDLE);
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
