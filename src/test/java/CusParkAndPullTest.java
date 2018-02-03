import com.fangda.skylot.mathine.service.impl.parking.ParkingServiceImpl;
import com.fangda.skylot.mathine.service.parking.ParkingService;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2016/11/30.
 */
public class CusParkAndPullTest {

    @Autowired
    private ParkingService parkingService;

    @Ignore
    public static void main(String[] args) throws SkyLotException{
        try {
            ParkingServiceImpl p = new ParkingServiceImpl();
//            int result1 = p.cusParking("B9999");
//            System.out.println(result1);

//            int result2 = p.cusPulling("B8888");
//            System.out.println(result2);
        }catch (Exception e){
            throw new SkyLotException("",e.getCause());
        }

    }

    @Test
    @Ignore
    public void parkingTest() throws SkyLotException {
        try {
//            System.out.println(this.parkingService.cusParking("粤B 9999"));
        } catch (Exception e) {
            throw new SkyLotException("", e.getCause());
        }

    }
}
