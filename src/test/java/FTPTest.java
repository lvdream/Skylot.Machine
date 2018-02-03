import com.fangda.skylot.mathine.service.impl.SocketServiceImpl;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.ftp.FtpUtils;
import com.fangda.skylot.mathine.utils.socket.BaseCommander;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Damon on 2016/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@Slf4j
public class FTPTest {
    @Autowired
    private FtpUtils ftpUtils;
    protected static String hexString = "0123456789ABCDEF";
    @Autowired
    private BaseCommander baseCommander;
    @Autowired
    private SocketServiceImpl socketService;

    @Test
    @Ignore
    public void strToHexStr() throws SkyLotException {

//        FtpUtils.downloadFile("/","测试录入数据.csv");
        try {
//            FtpUtils.download("测试录入数据.csv","测试录入数据.csv");
            ftpUtils.loadFile("测试录入数据.csv");
            System.out.println(ftpUtils.getCommandList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static String encode(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    @Test
    public void PLC() {

        MyThread my = new MyThread();
        my.setGo(1);
        new Thread(my).start();
        try {
            Thread.sleep(3210);
            MyThread my2 = new MyThread();
            my2.setGo(2);
            new Thread(my2).start();
            Thread.sleep(2310);
            MyThread my3 = new MyThread();
            my3.setGo(3);
            new Thread(my3).start();
            Thread.sleep(500000000);
        } catch (Exception e) {
            log.error(e.getMessage());
            MyThread my4 = new MyThread();
            my4.setGo(3);
            new Thread(my4).start();
            e.printStackTrace();
        }
//        MyThread my2 = new MyThread();
//        my2.setIp("10.8.0.136");
//        new Thread(my2).start();

//        new Thread(my).start();
    }

    class MyThread extends Thread {
        private int go;

        public int getGo() {
            return go;
        }

        public void setGo(int go) {
            this.go = go;
        }

        public void run() {
            Logger loggerParking = Logger.getLogger("Parking");
            try {
                for (int i = 0; i < 100000; i++) {
                    if (go == 1) {
                        socketService.getParkingStatus(1);
                        log.warn(socketService.getStringBuilder().toString());
                    } else if (go == 2) {
                        socketService.getBaseNumber();
                        log.warn(socketService.getStringBuilderto().toString());
                    } else if (go == 3) {
                        socketService.getEnergy();
                        log.warn(socketService.getStringBuilderto().toString());
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                loggerParking.error(e);
                e.printStackTrace();
                try {
                    Thread.sleep(2000);
                    socketService.getEnergy();
                } catch (SkyLotException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }


        }
    }
}
