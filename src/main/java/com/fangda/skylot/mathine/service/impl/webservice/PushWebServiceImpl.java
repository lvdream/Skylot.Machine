package com.fangda.skylot.mathine.service.impl.webservice;

import com.fangda.skylot.mathine.model.customer.*;
import com.fangda.skylot.mathine.model.parking.IftbMachineAction;
import com.fangda.skylot.mathine.model.parking.IftbMachineActionCriteria;
import com.fangda.skylot.mathine.model.parking.OftbMathineItem;
import com.fangda.skylot.mathine.model.parking.OftbMathineItemCriteria;
import com.fangda.skylot.mathine.model.utils.IftbScheduleAction;
import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.customer.*;
import com.fangda.skylot.mathine.service.parking.MachineActionService;
import com.fangda.skylot.mathine.service.sync.MachineItemService;
import com.fangda.skylot.mathine.service.webservice.PushWebService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

@Service("pushWS")
@Slf4j
public class PushWebServiceImpl implements PushWebService {
    @Autowired
    private Map<String, IBaseService> serviceMap;

    /**
     * 推送同步信息
     *
     * @return -1执行失败,0执行成功
     */
    private int executeThread(IftbScheduleAction iftbScheduleAction) throws SkyLotException {
        int result = -1;
        if (iftbScheduleAction != null) {
            try {
                Map<String, String> messageObj = SingletonObjectMapper.getInstance().readValue(iftbScheduleAction.getIsaScheduleMessage(), Map.class);
                if (StringUtils.equals("IftbItemCustomer", iftbScheduleAction.getIsaBusinessObj())) {//购买对象的推送
                    IftbItemCustomer iftbItemCustomer = IftbItemCustomer.builder().build();
                    BeanUtils.populate(iftbItemCustomer, messageObj);
                    IftbItemCustomerCriteria customerCriteria = new IftbItemCustomerCriteria();
                    customerCriteria.createCriteria().andIicIdEqualTo(iftbItemCustomer.getIicId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((ItemCustomerService) serviceMap.get("itemCustomerService")).add(iftbItemCustomer);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((ItemCustomerService) serviceMap.get("itemCustomerService")).update(iftbItemCustomer, customerCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((ItemCustomerService) serviceMap.get("itemCustomerService")).delete(customerCriteria);
                    }
                } else if (StringUtils.equals("OftbCodeInfo", iftbScheduleAction.getIsaBusinessObj())) {//取车的推送
                    OftbCodeInfo oftbCodeInfo = OftbCodeInfo.builder().build();
                    BeanUtils.populate(oftbCodeInfo, messageObj);
                    OftbCodeInfoCriteria oftbCodeInfoCriteria = new OftbCodeInfoCriteria();
                    oftbCodeInfoCriteria.createCriteria().andOciIdEqualTo(oftbCodeInfo.getOciId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((CodeInfoService) serviceMap.get("codeInfoService")).add(oftbCodeInfo);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((CodeInfoService) serviceMap.get("codeInfoService")).update(oftbCodeInfo, oftbCodeInfoCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((CodeInfoService) serviceMap.get("codeInfoService")).delete(oftbCodeInfoCriteria);
                    }
                } else if (StringUtils.equals("OftbCustomerCar", iftbScheduleAction.getIsaBusinessObj())) {//用户车牌的推送
                    OftbCustomerCar oftbCustomerCar = OftbCustomerCar.builder().build();
                    BeanUtils.populate(oftbCustomerCar, messageObj);
                    OftbCustomerCarCriteria oftbCustomerCarCriteria = new OftbCustomerCarCriteria();
                    oftbCustomerCarCriteria.createCriteria().andOccIdEqualTo(oftbCustomerCar.getOccId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((CustomerCarService) serviceMap.get("customercarService")).add(oftbCustomerCar);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((CustomerCarService) serviceMap.get("customercarService")).update(oftbCustomerCar, oftbCustomerCarCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((CustomerCarService) serviceMap.get("customercarService")).delete(oftbCustomerCarCriteria);
                    }
                } else if (StringUtils.equals("OftbMathineItem", iftbScheduleAction.getIsaBusinessObj())) {//车位对象的推送
                    OftbMathineItem oftbMathineItem = OftbMathineItem.builder().build();
                    BeanUtils.populate(oftbMathineItem, messageObj);
                    OftbMathineItemCriteria oftbMathineItemCriteria = new OftbMathineItemCriteria();
                    oftbMathineItemCriteria.createCriteria().andOmiIdEqualTo(oftbMathineItem.getOmiId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((MachineItemService) serviceMap.get("machineItemService")).add(oftbMathineItem);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((MachineItemService) serviceMap.get("machineItemService")).update(oftbMathineItem, oftbMathineItemCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((MachineItemService) serviceMap.get("machineItemService")).delete(oftbMathineItemCriteria);
                    }
                } else if (StringUtils.equals("OftbReserveTaking", iftbScheduleAction.getIsaBusinessObj())) {//预约取车对象的推送
                    OftbReserveTaking oftbReserveTaking = OftbReserveTaking.builder().build();
                    BeanUtils.populate(oftbReserveTaking, messageObj);
                    OftbReserveTakingCriteria oftbReserveTakingCriteria = new OftbReserveTakingCriteria();
                    oftbReserveTakingCriteria.createCriteria().andOrtIdEqualTo(oftbReserveTaking.getOrtId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((ReserveTakingService) serviceMap.get("reserveTakingService")).add(oftbReserveTaking);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((ReserveTakingService) serviceMap.get("reserveTakingService")).update(oftbReserveTaking, oftbReserveTakingCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((ReserveTakingService) serviceMap.get("reserveTakingService")).delete(oftbReserveTakingCriteria);
                    }
                } else if (StringUtils.equals("MstbCustomer", iftbScheduleAction.getIsaBusinessObj())) {//用户对象的推送
                    MstbCustomer mstbCustomer = MstbCustomer.builder().build();
                    BeanUtils.populate(mstbCustomer, messageObj);
                    MstbCustomerCriteria mstbCustomerCriteria = new MstbCustomerCriteria();
                    mstbCustomerCriteria.createCriteria().andMcIdEqualTo(mstbCustomer.getMcId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((CustomerService) serviceMap.get("customerService")).add(mstbCustomer);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((CustomerService) serviceMap.get("customerService")).update(mstbCustomer, mstbCustomerCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((CustomerService) serviceMap.get("customerService")).delete(mstbCustomerCriteria);
                    }
                } else if (StringUtils.equals("IftbMachineAction", iftbScheduleAction.getIsaBusinessObj())) {//物业设备的推送
                    IftbMachineAction iftbMachineAction = IftbMachineAction.builder().build();
                    BeanUtils.populate(iftbMachineAction, messageObj);
                    IftbMachineActionCriteria iftbMachineActionCriteria = new IftbMachineActionCriteria();
                    iftbMachineActionCriteria.createCriteria().andImaIdEqualTo(iftbMachineAction.getImaId());
                    if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_ADD)) {//新增
                        ((MachineActionService) serviceMap.get("machineActionService")).add(iftbMachineAction);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_UPDATE)) {//更新
                        ((MachineActionService) serviceMap.get("machineActionService")).update(iftbMachineAction, iftbMachineActionCriteria);
                    } else if (StringUtils.equals(iftbScheduleAction.getIsaScheduleType(), SCHEDULEACTION_TYPE_DELETE)) {//删除
                        ((MachineActionService) serviceMap.get("machineActionService")).delete(iftbMachineActionCriteria);
                    }
                }
                result = 0;
            } catch (Exception e) {
                throw new SkyLotException(e);
            } finally {
                return result;
            }
        }
        return result;
    }

    /**
     * 依据单线程进行执行,如果执行时间大于预设时间,则杀死当前线程,抛出异常
     *
     * @return FN_RETURN_STATUS_ERROR FN_RETURN_STATUS_SUCCESS
     */
    @Override
    public String pushSync(final IftbScheduleAction iftbScheduleAction) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Integer[] result = {-1};
        FutureTask<Integer> future =
                new FutureTask<Integer>(new Callable<Integer>() {//使用Callable接口作为构造参数
                    public Integer call() throws SkyLotException {
                        return executeThread(iftbScheduleAction);
                    }
                });
        executor.execute(future);
        try {
            result[0] = future.get(NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.machine.operation.timeout")), TimeUnit.SECONDS); //取得结果，同时设置超时执行时间为系统预定义时间。
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            future.cancel(true);
        } catch (TimeoutException e) {
            log.warn("超时了!!!" + iftbScheduleAction.toString());
            future.cancel(true);
            return FN_RETURN_STATUS_HANDLE;
        } finally {
            executor.shutdown();

        }
        if (result[0].intValue() == NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS)) {
            return FN_RETURN_STATUS_SUCCESS;
        } else {
            return FN_RETURN_STATUS_ERROR;
        }
    }
}
