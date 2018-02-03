import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

/**
 * Created by Saul on 11/29/16.
 */
@Slf4j
public class Test {
    private static String hexString = "0123456789ABCDEF";

    public static void main(String[] args) throws Exception {
        Logger logger2 = Logger.getLogger("Parking");
        logger2.debug("debug!!!");
        logger2.info("info!!!");
        logger2.warn("warn!!!");
        logger2.error("error!!!");
//        socketService.longCommandR();
//        socketService.longCommandW();
    }

}
