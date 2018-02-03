package com.fangda.skylot.mathine.utils;

import com.qy.led.Material;
import com.qy.led.SendBuffer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 跑马灯工具类
 */
@Component
public class MarqueeUtil {
    int nAreaWidth = 64;
    int nAreaHeight = 16;
    int nArrIndex = 0;
    int[] nArrUID = new int[]{1, 2};// UID
    int[] nArrTypeNo = new int[]{1, 2};// 种类编号
    String szCardIP = GetProperties.getProperties("system.properties", "skylot.marquee.ip");
    String szVoice = "语音文字播放";
    String[] szArrContent = new String[]{"SkyLot", "欢迎老郭回家"};
    int nScreenColor = 2;// 0--单机色；1--双基色；2--三基色
    int nShowStyle = 9;// 立即显示

    /**
     * 发送跑马灯文本
     *
     * @param title        文本抬头
     * @param content      文本内容
     * @param voiceBoolean 是否要读取文本
     * @return 0, 发送成功, 其他:发送失败
     */
    public int sendText(String title, String content, boolean voiceBoolean,String... voiceText) throws InterruptedException {
        int result = 0;
        List<Material> listMaterial = new ArrayList<Material>();
        listMaterial.add(new Material(title, nAreaWidth,
                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
                nScreenColor, nShowStyle, 1, 1, 2, 1, 1, 3, false));
        listMaterial.add(new Material(content, nAreaWidth,
                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
                nScreenColor, nShowStyle, 1, 1, 1, 1, 1, 1, false));
        nArrIndex = 0;
        if (voiceBoolean) {
            SendBuffer.SendMulInternalText_Net(listMaterial, szCardIP, 1);
            if(voiceText.length>0){
                title = voiceText[0];
            }
            result = SendBuffer.PlayVoice_Net(title + "," + content, szCardIP, "0", 1, 2);
        } else {
            result = SendBuffer.SendMulInternalText_Net(listMaterial, szCardIP, 1);
        }
        return result;
    }
}
