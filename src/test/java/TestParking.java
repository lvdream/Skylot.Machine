import com.fangda.skylot.mathine.utils.math.ParkingLogic;

import java.util.HashMap;

import static com.fangda.skylot.mathine.utils.constant.Constant.MACHINEPARKING_QUANTITY;

public class TestParking {
    public static void main(String[] args) {
        ParkingLogic p = new ParkingLogic();
        p.setMachineTotalItmes(MACHINEPARKING_QUANTITY);
        p.setBaseNum("1");
        HashMap p1 = new HashMap();
        p1.put(12, "1");
        p.setParkingStatusMap(p1);
    }
}
