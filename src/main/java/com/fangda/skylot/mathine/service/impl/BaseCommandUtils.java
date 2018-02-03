package com.fangda.skylot.mathine.service.impl;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import static com.fangda.skylot.mathine.utils.constant.Constant.PLC_EXCEPTION_COMMUNACAITON_LENGTH_ERROR;

/**
 * 基础操作命令集合
 */
@SuppressWarnings({"WeakerAccess", "StringBufferReplaceableByString"})
@Data
public class BaseCommandUtils {
    protected static String hexString = "0123456789ABCDEF";
    protected HashMap valueMap;
    protected HashMap valueMapAppend;
    protected StringBuilder stringBuilder = new StringBuilder();
    protected StringBuilder stringBuilderto = new StringBuilder();

    public static String encode(String str) {

        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    public static String decode(String bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
        return new String(baos.toByteArray());
    }


    /**
     * 依据返回16进制对象,转换为可以识别的停车位置信息
     * FFFF--> 15:1;14:0 .......
     * @param bit16Sstr 标准对象
     */
    protected void calculateStatus(String bit16Sstr) {
        int b = 0;
        valueMap = new HashMap();
        bit16Sstr = StringUtils.reverse(bit16Sstr);
        if (StringUtils.isNotEmpty(bit16Sstr)) {
            for (int i = 0; i < bit16Sstr.length(); i++) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(StringUtils.mid(bit16Sstr, i, 1));
                int tempInt = Integer.parseInt(stringBuilder2.toString(), 16);
                b++;
                if (tempInt == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int t = 1;
                    while (Math.pow(2, k + 1) * t < 17) {
                        if (tempInt < (Math.pow(2, k + 1) * t) && tempInt >= (Math.pow(2, k) * (2 * t - 1)) && tempInt > 0) {
                            valueMap.put((b - 1) * 4 + k + 1, "1");
                            t = 17;
                            break;
                        }
                        t++;
                    }
                }
            }
        }

    }

    /**
     * 处理返回字符串,进行计算返回值
     *
     * @param returnStr PLC返回的字符串
     */
    protected void convertArraytoCalc(String returnStr) throws SkyLotException {
        StringBuilder stringBuildernew = new StringBuilder();
        if (StringUtils.split(returnStr, " ").length == 32) {
            stringBuildernew = new StringBuilder();
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[30], 2, "0"));
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[31], 2, "0"));
            calculateStatus(stringBuildernew.toString());
        } else if (StringUtils.split(returnStr, " ").length == 34) {//获取故障代码相关长度,状态信息
            stringBuildernew = new StringBuilder();
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[32], 2, "0"));
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[33], 2, "0"));
            calculateStatus(stringBuildernew.toString());
            setValueMapAppend(this.valueMap);
            stringBuildernew = null;
            stringBuildernew = new StringBuilder();
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[30], 2, "0"));
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[31], 2, "0"));
            calculateStatus(stringBuildernew.toString());
        } else if (StringUtils.split(returnStr, " ").length == 30) {//获取故障代码相关长度,状态信息
            stringBuildernew = new StringBuilder();
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[28], 2, "0"));
            stringBuildernew.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[29], 2, "0"));
            calculateStatus(stringBuildernew.toString());
        } else {
            throw new SkyLotException(PLC_EXCEPTION_COMMUNACAITON_LENGTH_ERROR);
        }
    }

    /**
     * 处理返回字符串,进行计算16进制转换10进制
     *
     * @param returnStr PLC返回的字符串
     * @return
     * @throws SkyLotException
     */
    protected float convert16bit(String returnStr) throws SkyLotException {
        if (StringUtils.split(returnStr, " ").length == 34) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[32], 2, "0"));
            stringBuilder.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[33], 2, "0"));
            stringBuilder.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[30], 2, "0"));
            stringBuilder.append(StringUtils.leftPad(StringUtils.split(returnStr, " ")[31], 2, "0"));
            return Float.intBitsToFloat(Integer.parseInt(stringBuilder.toString(), 16));
        } else {
            throw new SkyLotException(PLC_EXCEPTION_COMMUNACAITON_LENGTH_ERROR);
        }
    }


}
