package com.fangda.skylot.mathine.scheduler.springtask;

import com.fangda.skylot.mathine.service.IBaseService;
import com.fangda.skylot.mathine.service.parking.ParkingLogService;
import com.fangda.skylot.mathine.service.sync.SyncService;
import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.MarqueeUtil;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.constant.Constant;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.fangda.skylot.mathine.utils.ftp.FtpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fangda.skylot.mathine.utils.constant.Constant.FN_RETURN_STATUS_ERROR;

/**
 * Created by Saul on 16/06/2017.
 */
@Component
@Slf4j
public class SyncFTPUtil {
    @Autowired
    private SyncService syncServiceImpl;
    @Autowired
    private FtpUtils ftpUtils;
    @Autowired
    public Map<String, IBaseService> serviceMap;
    private Logger loggerParking = Logger.getLogger("Parking");
    @Autowired
    private MarqueeUtil marqueeUtil;


    /**
     * 同步后台主方法
     *
     * @throws SkyLotException
     */
    public void ftp() throws Exception {
        int iType = NumberUtils.toInt(GetProperties.getProperties("system.properties", "identify.type"));
        if (iType == NumberUtils.toInt(Constant.SYSTEM_WORKING_MODEL_TEST)) {
            testLoad();
        } else {
            normalLoad();
        }
    }

    /**
     * 进行测试运行模式
     */
    private void testLoad() throws SkyLotException {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        log.warn(df.format(new Date()) + "******** ftp 任务执行******: ");
        try {
            ftpUtils.loadFile("test.csv");
            if (CollectionUtils.isNotEmpty(ftpUtils.getCommandList())) {
                for (Iterator iterator = ftpUtils.getCommandList().iterator(); iterator.hasNext(); ) {
                    String next = (String) iterator.next();
                    String[] strings = StringUtils.split(next, ",");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(StringUtils.trim(strings[0])).append(",");
                    stringBuilder.append(StringUtils.trim(strings[1])).append(",");
                    stringBuilder.append(StringUtils.trim(strings[2])).append(",");
                    Map statusMap = new HashMap();
                    String message = "";
                    loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作车辆序号[" + strings[0] + "],当前车辆是[" + strings[2] + "]");
                    if (strings[1].equals("存车")) {
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[存车],当前车辆是[" + strings[2] + "]");
                        statusMap = syncServiceImpl.parkCar(StringUtils.remove(strings[2], " "), false);

                    } else if (strings[1].equals("取车")) {
                        loggerParking.warn("当前时间:[" + SkylotUtils.getStrDate() + "],当前操作[取车],当前车辆是[" + strings[2] + "]");
                        statusMap = syncServiceImpl.pullCar(StringUtils.remove(strings[2], " "));
                    }
                    ftpUtils.writeFile(((ParkingLogService) serviceMap.get("parkinglogService")).layoutMessage(statusMap, strings[1]).toString(), "test_02.csv");
                }
                ftpUtils.uploadFile("test_02.csv");
            }
            log.warn(df.format(new Date()) + "********ftp 任务执行完毕******: ");
        } catch (Exception e) {
            throw new SkyLotException(e);
        }
    }

    /**
     * 进行正式运行模式
     */
    private void normalLoad() throws Exception {
        try {
            //抓取ftp上面车牌文件信息
            FTPFile[] ftpFiles = ftpUtils.getFile();
            if (ftpFiles != null && ftpFiles.length > 0) {
                List<String> errorList = new ArrayList<String>();
                //只取出最后的一条需要停车的记录
                for (int i = 0; i < ftpFiles.length; i++) {
                    FTPFile file = ftpFiles[i];
                    //直接将获取到车牌对象插入到数据中
                    String actualName = StringUtils.substringBeforeLast(StringUtils.substringAfterLast(file.getName(), GetProperties.getProperties("system.properties", "ftp.image.file.split")), GetProperties.getProperties("system.properties", "ftp.image.file.extention"));
                    int result = ((ParkingLogService) serviceMap.get("parkinglogService")).parkingAction(actualName, true);
//                    ftpUtils.removeFile(actualName);
                    if (result == NumberUtils.toInt(FN_RETURN_STATUS_ERROR)) {
                        errorList.add(file.getName());
                    }
                }
            }
        } catch (SkyLotException e) {
            throw new SkyLotException(e);
        } finally {

        }
    }

}
