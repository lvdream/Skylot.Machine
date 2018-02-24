package com.fangda.skylot.mathine.utils.math;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;

/**
 * 负责运算停车逻辑算法
 * Created by Saul on 10/06/2017.
 */
@Data
public class ParkingLogic {

    private String baseNum;// 最下方停车板编号
    private String topNum;// 最上方停车板编号
    private String leftNum;// 最左方停车板编号
    private String rightNum;// 最右方停车板编号
    private int leftColumnCount;//左侧停车数量
    private int rightColumnCount;//右侧侧停车数量
    private int upCount;//上方停车数量
    private int downCount;//下方侧停车数量
    private int actionDirect;//旋转的方向,待转向位置在左侧,则反转:2,如果在右侧,则正转:1
    private int finalPostionNumer;//最终需要荷载判定的旋转车台
    private int actionDirectwithFinalPosition;//荷载的旋转方向,待转向位置在左侧,则反转:2,如果在右侧,则正转:1


    /**
     * 设备车板数量
     */
    private String machineTotalItmes;//设备车板数量

    /**
     * 当前停车状态列表
     */
    private HashMap parkingStatusMap;//当前停车状态列表

    /**
     * 获取应该存储位置
     *
     * @param actionType 操作的类型,0:停车,1:取车
     * @param isQueue    是否是排队车辆,如果是排队车辆,则选择最近空置车台
     * @return 具体车板编号
     * @throws SkyLotException 定义异常
     */
    public int getStoreNum(int actionType, boolean isQueue) throws SkyLotException {
        if (StringUtils.isEmpty(getBaseNum())) {//没有传递最下方车板信息
            throw new SkyLotException(PLC_EXCEPTION_PARKING_GET_BASE_ITEM_ERROR);
        }
        if (StringUtils.isEmpty(getMachineTotalItmes())) {//没有传递设备总车板信息
            throw new SkyLotException(PLC_EXCEPTION_PARKING_GET_TOTAL_MACHINE_COUNT);
        }
        if (null == getParkingStatusMap()) {//没有传递设备当前停车状态
            throw new SkyLotException(PLC_EXCEPTION_PARKING_GET_PARKING_STATUS);
        }
        int parkingNumber;
        getTopNumber();//获取顶部车位编号
        getLeftNumber();//获取左边车位
        getRightNumber();//获取右边车位
        calculateSideCount();//推算左右2侧停车数量
        //0817更新,调整车位计算逻辑,考虑到效率的问题,使用就近停车逻辑
        if (!isLogic(NumberUtils.toInt(getBaseNum()))) {//最下方如果有空置车位,直接停
            return NumberUtils.toInt(getBaseNum());
        }
        parkingNumber = findPosition(0);
        calculateWeight(parkingNumber, actionType);//计算左右荷载
        return parkingNumber;
    }


    /**
     * 获取顶部车位标号
     */
    private void getTopNumber(int... Basenumber) {
        if (Basenumber.length > 0) {
            if (NumberUtils.toInt(Basenumber[0] + "") > NumberUtils.toInt(getMachineTotalItmes()) / 2) {
                setTopNum((Basenumber[0] - NumberUtils.toInt(getMachineTotalItmes()) / 2) + "");
            } else {
                setTopNum((Basenumber[0] + NumberUtils.toInt(getMachineTotalItmes()) / 2) + "");
            }
        } else {
            if (NumberUtils.toInt(getBaseNum()) > NumberUtils.toInt(getMachineTotalItmes()) / 2) {
                setTopNum((NumberUtils.toInt(getBaseNum()) - NumberUtils.toInt(getMachineTotalItmes()) / 2) + "");
            } else {
                setTopNum((NumberUtils.toInt(getBaseNum()) + NumberUtils.toInt(getMachineTotalItmes()) / 2) + "");
            }
        }

    }

    /**
     * 获取左边车位标号
     */
    private void getLeftNumber() {
        int number = Math.abs(NumberUtils.toInt(getTopNum()) - NumberUtils.toInt(getBaseNum())) / 2 + NumberUtils.toInt(getTopNum());
        if (number > NumberUtils.toInt(getMachineTotalItmes())) {
            number = number - NumberUtils.toInt(getMachineTotalItmes());
        }
        setLeftNum(number + "");
    }

    /**
     * 获取右边车位标号
     */
    private void getRightNumber() {
        int number = Math.abs(NumberUtils.toInt(getTopNum()) - NumberUtils.toInt(getBaseNum())) / 2 + NumberUtils.toInt(getBaseNum());
        if (number > NumberUtils.toInt(getMachineTotalItmes())) {
            number = number - NumberUtils.toInt(getMachineTotalItmes());
        }
        setRightNum(number + "");
    }

    /**
     * 计算两侧停车状态
     */
    private void calculateSideCount() {
        if (MapUtils.isEmpty(parkingStatusMap)) {
            setRightColumnCount(0);
            setLeftColumnCount(0);
        } else {
            setRightColumnCount(0);
            setLeftColumnCount(0);
            List<Integer> LeftNumbers = ListUtils.sum(getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 0), getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 2));  //左侧车位编号
            for (Object o : parkingStatusMap.keySet()) {
                int pNum = (Integer) o;
                if (pNum == NumberUtils.toInt(getTopNum()) || pNum == NumberUtils.toInt(getBaseNum())) {//最顶部和最下部不参与计算
                    continue;
                }
                if (ArrayUtils.contains(LeftNumbers.toArray(), pNum)) {
                    setLeftColumnCount(getLeftColumnCount() + 1);
                } else {
                    setRightColumnCount(getRightColumnCount() + 1);
                }
            }
        }
    }

    /**
     * 计算左右荷载
     * 最终将计算出finalPositionNumber,这个对象如果和最下方车位编号不一样,则需要进行旋转,如果编号是0,不进行操作
     *
     * @param currentBaseNum 当前最下停车位
     * @param actionTyppe    操作类型.  0:停车,1:取车
     * @throws SkyLotException 定义异常
     */
    private void calculateWeight(int currentBaseNum, int actionTyppe) throws SkyLotException {
        if (!NumberUtils.isDigits(currentBaseNum + "")) {
            throw new SkyLotException("baseNumber is error");
        } else {
            setBaseNum(currentBaseNum + "");
            getTopNumber();
            if (MapUtils.isEmpty(parkingStatusMap)) {
                setFinalPostionNumer(0);
            } else {
                getLeftNumber();
                getRightNumber();
                getTopNumber();
                calculateSideCount();
                if (actionTyppe == 0) {
                    this.getParkingStatusMap().put(currentBaseNum, "1");
                    findPosition(1);
                }
            }
        }

    }

    /**
     * 判断逻辑循环中的逻辑是成立
     *
     * @param checkNum 判断的位置
     * @return 成立或不成立
     */
    private boolean isLogic(int checkNum) {
        boolean isCorrect = false;
        for (Object o : parkingStatusMap.keySet()) {
            int pNum = (Integer) o;
            if (pNum == checkNum) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }

    /**
     * 找到需要的停车位
     *
     * @param pType 0,计算停车位,1,计算转向车位
     * @return 停车位
     */
    private int findPosition(int pType) {
        int parkingNumber = 0;
        int countNumber = 0;//初始化,左右平衡关系,默认左右负载:0,左负载:1,右负载:2
        if (getLeftColumnCount() > getRightColumnCount()) {//左侧停车数量大于右侧停车数量
            countNumber = 1;
        }
        if (getLeftColumnCount() < getRightColumnCount()) {//左侧停车数量小于右侧停车数量
            countNumber = 2;
        }
        if (pType == 0) {
            //获取左下车位编号
            List<Integer> LeftNumbers = getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 0);//左下侧停车编号
            List<Integer> rightNumbers = getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 1);//右下侧停车编号
            //第一步,处理左右平衡
            if (countNumber == 0) {//左右平衡
                // TODO: 18/08/2017 暂时不考虑效能问题,只处理停车平衡问题
                parkingNumber = positionLogic(LeftNumbers, rightNumbers);//首先在
                if (parkingNumber == 0) {//在下方没有找到合适的停车位置,继续在上方查找
                    LeftNumbers = getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 2);//左上侧停车编号
                    rightNumbers = getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 3);//右上侧停车编号
                    parkingNumber = positionLogic(LeftNumbers, rightNumbers);
                }
            } else if (countNumber == 1) {//左侧负载
                for (int i = 0; i < 4; i++) {
                    if (i == 0 || i == 2) {//跳过左侧的计算
                        continue;
                    }
                    List positionList = getRightPositionNumber(Integer.parseInt(getBaseNum()), i);//依次查找,下方和左侧;上方和左侧
                    parkingNumber = positionLogic(positionList, null);
                    if (parkingNumber > 0) {
                        setActionDirect(1);
                        break;
                    }
                }
            } else {//右侧负载
                for (int i = 0; i < 4; i++) {
                    if (i == 1 || i == 3) {//跳过右侧的计算
                        continue;
                    }
                    List positionList = getRightPositionNumber(Integer.parseInt(getBaseNum()), i);//依次查找,下方和右侧;上方和右侧
                    parkingNumber = positionLogic(null, positionList);

                    if (parkingNumber > 0) {
                        setActionDirect(2);
                        break;
                    }
                }
            }
        } else {//左右负载逻辑计算
            if (Math.abs(getLeftColumnCount() - getRightColumnCount()) > 1) {//左右存在不平衡的情况
                List leftpositionList = ListUtils.sum(getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 0), getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 2));//依次查找,下方和左侧;上方和左侧
                List rightpositionList = ListUtils.sum(getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 1), getRightPositionNumber(NumberUtils.toInt(getBaseNum()), 3));//依次查找,下方和右侧;上方和右侧
                if (getLeftColumnCount() > getRightColumnCount()) {//左侧停车数量大于右侧停车数量
                    doParkingNumberwithFind(leftpositionList, true);
                } else {//右侧负载
                    doParkingNumberwithFind(rightpositionList, false);
                }

            }
        }
        return parkingNumber;
    }

    /**
     * 计算下方车位的
     *
     * @param currentBaseNum 当前停车板最下方车板编号
     */
    private void getDownCounts(int currentBaseNum) {
        List dataList = new ArrayList<Integer>();
        dataList = ListUtils.sum(dataList, getRightPositionNumber(currentBaseNum, 0));//计算左侧车位编号,放入3,计算最下面车位左侧3个位置车位的编号
        dataList = ListUtils.sum(dataList, getRightPositionNumber(currentBaseNum, 1));//计算右侧车位编号,放入3,计算最下面车位右侧3个位置车位的编号
        setDownCount(0);
        setUpCount(0);
        for (Object o : parkingStatusMap.keySet()) {
            int pNum = (Integer) o;
            if (pNum == NumberUtils.toInt(getLeftNum()) || pNum == NumberUtils.toInt(getRightNum())) {//最左侧和最右侧不参与计算
                continue;
            }
            if (ArrayUtils.contains(dataList.toArray(), pNum)) {
                //推算下面车位数量
                setDownCount(getDownCount() + 1);
            } else {
                //推算上面车位数量
                setUpCount(getUpCount() + 1);
            }
        }
    }

    /**
     * 获取区间内的车位信息,
     *
     * @param currentBaseNum 最下方车板位置编号
     * @param getType        获取车位信息的类型,0:获取最下方和最左侧之间的车位,1:获取最下方和最右侧车位信息,2:获取最上方和最左侧的车位编号,3:获取最上方和最右侧车位编号
     * @return [车板信息]
     */
    public List<Integer> getRightPositionNumber(int currentBaseNum, int getType) {
        List<Integer> dataList = new ArrayList<Integer>();
        setMachineTotalItmes(MACHINEPARKING_QUANTITY);
        //计算左侧车位编号,放入3,计算最下面车位左侧3个位置车位的编号
        switch (getType) {
            case 0:
                for (int i = 1; i <= 3; i++) {
                    if (currentBaseNum - i > 0) {
                        dataList.add(currentBaseNum - i);
                    } else {
                        dataList.add(currentBaseNum - i + NumberUtils.toInt(getMachineTotalItmes()));
                    }
                }
                break;
            case 1:
                for (int i = 1; i <= 3; i++) {
                    if (currentBaseNum + i <= NumberUtils.toInt(getMachineTotalItmes())) {
                        dataList.add(currentBaseNum + i);
                    } else {
                        dataList.add(currentBaseNum + i - NumberUtils.toInt(getMachineTotalItmes()));
                    }
                }
                break;
            case 2:
                getTopNumber(currentBaseNum);
                for (int i = 1; i <= 3; i++) {
                    if (NumberUtils.toInt(getTopNum()) + i <= 12) {
                        dataList.add(NumberUtils.toInt(getTopNum()) + i);
                    } else {
                        dataList.add(NumberUtils.toInt(getTopNum()) + i - NumberUtils.toInt(getMachineTotalItmes()));
                    }
                }

                break;
            case 3:
                getTopNumber(currentBaseNum);
                for (int i = 1; i <= 3; i++) {
                    if (NumberUtils.toInt(getTopNum()) - i > 0) {
                        dataList.add(NumberUtils.toInt(getTopNum()) - i);
                    } else {
                        dataList.add(NumberUtils.toInt(getTopNum()) - i + NumberUtils.toInt(getMachineTotalItmes()));
                    }
                }
                break;
        }

        return dataList;
    }

    /**
     * 计算应当停车位置
     *
     * @param positionList 可用停车位置列表
     * @param isLeft       是否是左侧判断
     * @return
     */
    private void doParkingNumberwithFind(List positionList, boolean isLeft) {
        Collections.sort(positionList);//排序
        //依次将获取到的编号放入最下方编号
        for (int i = positionList.size() - 1; i >= 0; i--) {
            //设置最下车位编号
            setBaseNum(positionList.get(i) + "");
            //重新计算左右平衡
            calculateSideCount();
            setActionDirectwithFinalPosition(isLeft ? 2 : 1);//左侧则反转,右侧则正转
            setFinalPostionNumer((Integer) positionList.get(i));
            if (Math.abs(getLeftColumnCount() - getRightColumnCount()) <= 1) {//平衡已经修正
                break;
            }
        }
    }

    /**
     * 寻找有效车位信息
     *
     * @param leftnumbers  左侧停车位
     * @param rightnumbers 右侧停车位
     * @return 整形, 是否找到停车位置, 非0:是,0:否
     */
    private int positionLogic(List<Integer> leftnumbers, List<Integer> rightnumbers) {
        int parkingNumber = 0;
        List<Integer> loopList = CollectionUtils.isNotEmpty(leftnumbers) ? leftnumbers : rightnumbers;
        for (int i = 0; i < loopList.size(); i++) {
            Integer integer = loopList.get(i);
            //首选判断,左右都有停车位置,那么判断左右负载情况,负载多的一侧,作为待停车位置
            if (CollectionUtils.isNotEmpty(leftnumbers) && !isLogic(integer)) {//查看左侧是否可以停车
                parkingNumber = integer;
                setActionDirect(2);
            } else if (CollectionUtils.isNotEmpty(rightnumbers) && !isLogic(rightnumbers.get(i))) {//查看右侧是否可以停车
                parkingNumber = rightnumbers.get(i);
                setActionDirect(1);
            }
            if (parkingNumber > 0) {//找到待停车位置,跳出本次车位寻找
                break;
            }
        }
        return parkingNumber;
    }
}
