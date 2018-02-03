package com.fangda.skylot.mathine.utils.socket;

import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import static com.fangda.skylot.mathine.utils.constant.Constant.FN_RETURN_STATUS_SUCCESS;
import static com.fangda.skylot.mathine.utils.constant.Constant.PLC_COMMUNACAITON_HEAD;

/**
 * Socket基础连接对象
 * Created by Saul on 07/08/2017.
 */
@SuppressWarnings("ALL")
@Data
@Slf4j
@Component
public class BaseCommander {
    private Socket client = null;
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilderto = new StringBuilder();
    private OutputStream out_data = null;
    private PrintStream printStream = null;
    private InputStream inputStream;
    private String staticIP;

    /**
     * 初始化握手连接
     *
     * @return 是否连接成功 0:成功,1:失败
     */
    public int buildFirstConnection() throws IOException {
        if (client == null) {
            try {
                buildConnection();
                return baseCommand(PLC_COMMUNACAITON_HEAD, "");
            } catch (SkyLotException e) {
                e.printStackTrace();
            }
        }
        return NumberUtils.toInt(FN_RETURN_STATUS_SUCCESS);
    }

    /**
     * 处理基础命令
     *
     * @param HeadCommand    头命令
     * @param append_Command 附加命令
     * @param verifyCode     验证返回值,可选
     * @return 成功失败, 0成功,-1失败
     */
    public int baseCommand(String HeadCommand, String append_Command, String... verifyCode) {
        try {
            stringBuilder = new StringBuilder();
            stringBuilderto = new StringBuilder();
            stringBuilder.append(HeadCommand.toUpperCase());//通信头
            stringBuilder.append(StringUtils.leftPad(Integer.toHexString(NumberUtils.toInt(StringUtils.substringAfterLast(GetProperties.getProperties("system.properties", "skylot.machine.ip"), "."))).toUpperCase(), 2, "0"));// TODO: 01/07/2017 195环境ip写死
//            stringBuilder.append(Integer.toHexString(NumberUtils.toInt(StringUtils.substringAfterLast(SkylotUtils.resolveLocalIps().iterator().next().toString(), "."))).toUpperCase());//本地IP
            stringBuilder.append(append_Command.toUpperCase());//附加命令
            for (int i = 0; i <= stringBuilder.toString().length(); i++) {
                if (i % 2 == 0) {
                    if (StringUtils.substring(stringBuilder.toString(), i - 2, i).length() > 0) {
                        stringBuilderto.append(Integer.valueOf(StringUtils.substring(stringBuilder.toString(), i - 2, i), 16).byteValue()).append(" ");
                    }
                }

            }
            byte[] d;
            if (StringUtils.isNotEmpty(stringBuilderto.toString())) {
                d = new byte[StringUtils.split(stringBuilderto.toString(), " ").length];
                for (int i = 0; i < StringUtils.split(stringBuilderto.toString(), " ").length; i++) {
                    d[i] = Integer.valueOf(StringUtils.split(stringBuilderto.toString(), " ")[i]).byteValue();
                }
                byte[] buffer = null;
                setPrintStream(new PrintStream(getClient().getOutputStream(), true));
                getPrintStream().write(d);
                if (!getClient().isConnected()) {//处理断线之后,重新连接的问题
                    if (!buildConnection()) {
                        log.error("socket connection error");
                        return -1;
                    }
                }
                while (true) {
                    if (getInputStream().available() > 0 && getInputStream() != null) {
                        getInputStream().read(buffer = new byte[getInputStream().available()]);
                        break;
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilderto = new StringBuilder();
                for (byte b : buffer) {
                    stringBuilder.append(b).append(" ");
                    stringBuilderto.append(Integer.toHexString(b & 0xFF).toUpperCase()).append(" ");
                }
                if (ArrayUtils.isNotEmpty(verifyCode)) {
                    if (!StringUtils.contains(StringUtils.replace(stringBuilderto.toString(), " ", ""), verifyCode[0])) {
                        return -1;
                    }
                }

            }
            return 0;
        } catch (Exception e) {
            log.error("socket connection error");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 初始化连接
     */
    private boolean buildConnection() throws SkyLotException {
        setClient(new Socket());
        try {
            getClient().connect(new InetSocketAddress(GetProperties.getProperties("system.properties", "skylot.plc.ip"), NumberUtils.toInt(GetProperties.getProperties("system.properties", "skylot.plc.port"))), 1000);
            getClient().setSoTimeout(2000);
            setOut_data(getClient().getOutputStream());
            setInputStream(getClient().getInputStream());
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 关闭连接
     */
    public void closeConnection() {
        try {
            if (getInputStream() != null) {
                getInputStream().close();
                setInputStream(null);
            }
            if (getOut_data() != null) {
                getOut_data().close();
                setOut_data(null);
            }
            if (getClient() != null) {
                getClient().close();
                setClient(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
