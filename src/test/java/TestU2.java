import com.qy.led.Material;
import com.qy.led.SendBuffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saul on 11/29/16.
 */
public class TestU2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 批量实时采集发送（2条）
        int nAreaWidth = 64;
        int nAreaHeight = 16;
        int nArrIndex = 0;
        int[] nArrUID = new int[]{1, 2};// UID
        int[] nArrTypeNo = new int[]{1, 2};// 种类编号
        String szCardIP = "192.168.10.230";
        String szVoice = "丝盖佬特,欢迎回家";
        String[] szArrContent = new String[]{"停车中", "停车中双基色批量实时采集发送成功"};
        int nScreenColor = 2;// 0--单机色；1--双基色；2--三基色
        int nShowStyle = 9;// 立即显示

//        List<Material> listMaterial = new ArrayList<Material>();
//        listMaterial.add(new Material(szArrContent[nArrIndex], nAreaWidth,
//                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
//                nScreenColor, nShowStyle, 1, 1, 1, 1, 1, 1, false));
//        listMaterial.add(new Material(szArrContent[nArrIndex], nAreaWidth,
//                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
//                nScreenColor, nShowStyle, 1, 1, 1, 1, 1, 1, false));
//        if (SendBuffer.SendMulCollectionData_Net(listMaterial, szCardIP, 1) == 0) {
//            System.out.println("批量实时采集发送成功！");
//        } else {
//            System.out.println("批量实时采集发送失败！重发..."); // 失败重发一次
//            if (SendBuffer.SendMulCollectionData_Net(listMaterial, szCardIP, 1) == 0) {
//                System.out.println("批量实时采集重发成功！");
//            } else {
//                System.out.println("批量实时采集重发失败！");
//            }
//        }

        // if (SendBuffer.SendCollectionData_Net("1采集12", "192.168.0.117", 1,
        // 41,
        // 1, 1, 1) == 0) {

        /**
         * int nTextIndex = 1; int nTextNum = 4; String[] szShowContent = new
         * String[]{"文1"}; if (SendBuffer.SendMulInternalText_Net(szShowContent
         * ,"192.168.0.117", 1, 32, 16, 1, 1, 9, 1, 1, 1, 1, 1, 1, false,
         * nTextIndex, nTextNum) == 0) { nTextIndex++; } if
         * (SendBuffer.SendMulInternalText_Net("文2", "192.168.0.117", 1, 32, 16,
         * 2, 1, 9, 1, 1, 1, 1, 1, 1, false, nTextIndex, nTextNum) == 0) {
         * nTextIndex++; } if (SendBuffer.SendMulInternalText_Net("文3",
         * "192.168.0.117", 1, 32, 16, 3, 1, 9, 1, 1, 1, 1, 1, 1, false,
         * nTextIndex, nTextNum) == 0) { nTextIndex++; }
         **/
        // if (SendBuffer.SendMulInternalText_Net("文4", "192.168.0.117", 1, 32,
        // 16, 4, 1, 9, 1, 1, 1, 1, 1, 1, false, nTextIndex, nTextNum) == 0) {

        /**
         * int nAreaWidth = 64; int nAreaHeight = 16; int nArrIndex = 0; int[]
         * nArrUID = new int[] { 1, 2 };// UID int[] nArrTypeNo = new int[] {
         * 41, 42 };// 种类编号 String szCardIP = "192.168.0.117"; String szVoice =
         * "语音文字播放"; String[] szArrContent = new String[] { "内码文字1", "内码文字2" };
         * int nScreenColor = 1;// 0--单机色；1--双基色；2--三基色 int nShowStyle = 9;//
         * 立即显示
         *
         * // 1. 语音播放发送 if (SendBuffer.PlayVoice_Net(szVoice, szCardIP, "0", 1,
         * 2) == 0) { System.out.println("语音播放发送成功！"); } else {
         * System.out.println("语音播放发送失败！重发..."); // 失败重发一次 if
         * (SendBuffer.PlayVoice_Net(szVoice, szCardIP, "0", 1, 2) == 0) {
         * System.out.println("语音播放重发成功！"); } else {
         * System.out.println("语音播放重发失败！"); } }
         **/
        if (SendBuffer.PlayVoice_Net(szVoice, szCardIP, "0", 1, 2) == 0) {
            System.out.println("语音播放发送成功！");
        }

        // 2. 批量内码文字发送（2条）
        List<Material> listMaterial = new ArrayList<Material>();
        listMaterial.add(new Material(szArrContent[nArrIndex], nAreaWidth,
                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
                nScreenColor, nShowStyle, 2, 1, 2, 3, 2, 1, false));
        listMaterial.add(new Material(szArrContent[nArrIndex], nAreaWidth,
                nAreaHeight, nArrUID[nArrIndex], nArrTypeNo[nArrIndex++],
                nScreenColor, nShowStyle, 0, 4, 1, 1, 0, 4, false));
        if (SendBuffer.SendMulInternalText_Net(listMaterial, szCardIP, 1) == 0) {
            System.out.println("内码文字发送成功！");
        } else {
            System.out.println("内码文字发送失败！重发..."); // 失败重发一次 if
            if (SendBuffer.SendMulInternalText_Net(listMaterial, szCardIP, 1) == 0) {
                System.out.println("内码文字重发成功！");
            } else {
                System.out.println("内码文字重发失败！");
            }
        }


        // 3. 单条内码文字发送
//        if (SendBuffer.SendInternalText_Net("安卓测试", "192.168.10.230", 1, 64, 32,
//                1, 0, 1, 1, 0, 1, 1, 1, 1, false) == 0) {
//            System.out.println("内码文字发送成功！");
//        } else {
//            System.out.println("内码文字发送失败！重发...");
//            // 失败重发一次
//            if (SendBuffer.SendInternalText_Net("安卓测试", "192.168.10.230", 1,
//                    64, 32, 2, 1, 1, 1, 1, 1, 1, 1, 1, false) == 0) {
//                System.out.println("内码文字重发成功！");
//            } else {
//                System.out.println("内码文字重发失败！");
//            }
//        }

    }

}
