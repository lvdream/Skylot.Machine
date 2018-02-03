import com.fangda.skylot.mathine.utils.SingletonObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saul on 03/06/2017.
 */
public class Test2 {
    public static void main(String[] args) throws JsonProcessingException {
        test();
    }


    private static void test() throws JsonProcessingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("21EA");
        Map vauelMap = new HashMap();
        int b = 0;
        for (int i = 0; i < stringBuilder.toString().length(); i++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(StringUtils.mid(stringBuilder.toString(), i, 1));
            int tempInt = Integer.parseInt(stringBuilder2.toString(), 16);
            b++;
            if (tempInt == 0) continue;
            for (int k = 0; k < 4; k++) {
                int t = 1;

                while (Math.pow(2, k + 1) * t < 17) {
                    if (tempInt < (Math.pow(2, k + 1) * t) && tempInt >= (Math.pow(2, k) * (2 * t - 1)) && tempInt > 0) {
                        System.out.println("k" + k + ";t" + t);
                        System.out.println("tempInt" + tempInt);
                        System.out.println("b" + b);
                        vauelMap.put((b - 1) * 4 + k, "1");
                        t = 17;
                        break;
                    }
                    t++;
                }
            }


        }
        System.out.println(SingletonObjectMapper.getInstance().writeValueAsString(vauelMap));
    }

    //计算最上停车位编号
    //最上停车位编号 = (车位数量 / 2) - 最下停车位编号 > 0 ? 最下停车位编号+(车位数量 / 2):最下停车位编号-(车位数量 / 2)

    //当下停车状况

    //最下停车位逆时针到最上停车位的停车数量


    //最下停车位顺时针到最上停车位的停车数量


    //停车判断条件说明

    /*
    接收参数
    01.设备总车位数量
    02.当下停车状态,每个车位编号对应停车状态
    03.最下停车为编号

    判断说明
    01,优先处理当前最上停车位,停车,如满足则结束逻辑
    02.再次处理,以最下停车位为基准,顺时针和逆时针2侧中间位置停车位,
        02.01需要判断顺时针和逆时针侧车辆数量,那边的少,就返回少这一侧中间车位编号,
        02.02如果当前中间停车位已经有车,那么判断中间车位正负1位置是否有空闲车位,如有返回空闲车位编号
        02.03如无,则继续判断当前车位正负2个位置,是否有空闲车位,如有则返回空闲车位编号,


    返回参数
    01.旋转到指定车位的编号
    02.顺时针or逆时针旋转

     */
}
