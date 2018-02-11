import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Saul on 11/29/16.
 */
@Slf4j
public class Test {
    private static String hexString = "0123456789ABCDEF";

    public static void main(String[] args) throws Exception {
        Map mapPLC = Maps.newHashMap();
        Map mapDB = Maps.newHashMap();
        mapDB.put(1, "1");
        mapDB.put(2, "1");
        mapDB.put(3, "1");
        mapDB.put(4, "1");
        mapPLC.put(1, "1");
//        mapPLC.put(2, "1");
//        mapPLC.put(3, "1");
        mapPLC.put(4, "1");
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> itDB = mapDB.entrySet().iterator();
        List missedCar = Lists.newArrayList();
        while (itDB.hasNext()) {
            Map.Entry<Integer, String> pairDB = itDB.next();
            if (mapPLC.get(pairDB.getKey()) == null) {
                missedCar.add(pairDB.getKey() + "");
            }
//            boolean find = false;
//            while (itPLC.hasNext()) {
//                Map.Entry<Integer, String> pairPLC = itPLC.next();
//                if (pairPLC.getKey().equals(pairDB.getKey())) {
//                    find = true;
//                    break;
//                }
//            }
//            if (!find) {
//                missedCar.add(pairDB.getKey() + "");
//            }
        }
        log.warn(missedCar.toString());
//        socketService.longCommandR();
//        socketService.longCommandW();
    }

}
