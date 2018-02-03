package com.fangda.skylot.mathine.utils.ftp;

import com.fangda.skylot.mathine.utils.GetProperties;
import com.fangda.skylot.mathine.utils.SkylotUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damon on 2016/12/5.
 */
@Component
@Data
@Slf4j
public class FtpUtils {
    private List commandList;
    private FTPClient ftpClient;

    private boolean connect() throws IOException {
        if (ftpClient == null) {
            ftpClient = new FTPClient();
        }
        String hostname = GetProperties.getProperties("system.properties", "ftp.ip");//本地路径
        String port = GetProperties.getProperties("system.properties", "ftp.port");//本地路径
        String username = GetProperties.getProperties("system.properties", "ftp.username");//本地路径
        String password = GetProperties.getProperties("system.properties", "ftp.password");//本地路径
        ftpClient.connect(hostname, Integer.parseInt(port));
        if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            if (ftpClient.login(username, password)) {
                ftpClient.enterLocalPassiveMode();
                ftpClient.sendCommand(
                        "OPTS UTF8", "ON");
                ftpClient.setControlEncoding("UTF-8");
                return true;
            }
        }
        return false;
    }

    private void disconnect() throws IOException {
        if (ftpClient != null && ftpClient.isConnected()) {
            ftpClient.disconnect();
        }
        ftpClient = null;
    }

    /**
     * 上传文件到服务器,新上传和断点续传
     *
     * @param localFileName 本地文件File句柄，绝对路径
     * @return
     * @throws IOException
     */
    public int uploadFile(String localFileName) throws IOException {
        disconnect();
        connect();
        boolean result = false;
        try {
            String localpath = GetProperties.getProperties("system.properties", "download.file.path");//本地路径
            File srcFile = new File(localpath + "/" + localFileName);
            FileInputStream fis = new FileInputStream(srcFile);
            ftpClient.changeWorkingDirectory("");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //存储文件==
            BufferedInputStream inStream = null;
            inStream = new BufferedInputStream(fis);
            log.error(localFileName + "开始上传.....");
            result = ftpClient.storeFile(localFileName, inStream);
            log.error(localFileName + "上传完毕");
            log.warn("删除远程文件");
            ftpClient.deleteFile("test.csv");
            log.warn("删除远程文件完成");
            log.warn("删除本地文件");
            File file = new File(localpath + "test.csv");
            file.deleteOnExit();
            if (file.exists()) {
                file.delete();
            }
            log.warn("删除本地文件完成");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传是失败！");
            return 1;
        } finally {
            disconnect();
        }
    }


    /**
     * @param remote
     * @param local
     * @return 下载成功:0,下载失败:1
     * @throws IOException
     */
    public int download(String remote, String local) throws IOException {
        connect();
        //检查远程文件是否存在
        FTPFile[] files = ftpClient.listFiles(remote);
        if (files.length < 1) {
            log.warn("no remote file!");
            return 1;
        } else {
            try {
                String localpath = GetProperties.getProperties("system.properties", "download.file.path");//本地路径
                File f = new File(localpath + "/" + local);
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                f.createNewFile();
                OutputStream out = new FileOutputStream(f);
                InputStream in = ftpClient.retrieveFileStream(remote);
                byte[] bytes = new byte[1024];
                int c;
                while ((c = in.read(bytes)) != -1) {
                    out.write(bytes, 0, c);
                }
                in.close();
                out.close();
                return ftpClient.completePendingCommand() ? 0 : 1;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
            return 1;
        }
    }

    /**
     * 下载csv文件,且读取到本地
     *
     * @param fileName
     */
    public void loadFile(String fileName) {
        try {
            commandList = new ArrayList();
            String localpath = GetProperties.getProperties("system.properties", "download.file.path");//本地路径
            File f = new File(localpath + "/" + fileName);
            if (f.exists()) {
                f.delete();
            }
            int a = download(fileName, fileName);
            if (a == 0) {
                FileInputStream fileStream = new FileInputStream(f);
                InputStreamReader inputReader = new InputStreamReader(fileStream, "UTF-8");
                BufferedReader reader2 = new BufferedReader(inputReader);
                reader2.readLine();
                String line2 = "";
                while ((line2 = reader2.readLine()) != null) {
                    commandList.add(line2);
                }
                reader2.close();
                inputReader.close();
                fileStream.close();
            }
            f = new File(localpath + "/test_02.csv");
            if (f.exists()) {
                f.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写Csv文件,追加的方式
     *
     * @param content 文件内存
     */
    public void writeFile(String content, String fileName) {
        try {
            String localpath = GetProperties.getProperties("system.properties", "download.file.path");//本地路径
            File f = new File(localpath + "/" + fileName);
            if (StringUtils.isNotEmpty(content)) {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "utf8"));
                bw.write(content);
                bw.newLine();
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取制定ftp目录下所有的文件
     *
     * @return FTPFile[] 文件集合
     * @throws IOException
     */
    public FTPFile[] getFile() throws SkyLotException, IOException {
        FTPFile[] ftpFiles = null;
        try {
            if (ftpClient == null) {
                connect();
            }
            ftpClient.changeWorkingDirectory(GetProperties.getProperties("system.properties", "ftp.image.file.directory"));
            if (ftpClient.changeWorkingDirectory(StringUtils.substringBefore(SkylotUtils.getStrDate(), " "))) {
                ftpFiles = ftpClient.listFiles();
                if (ftpFiles != null && ftpFiles.length > 0) {
                    return ftpFiles;
                }
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        } finally {
            disconnect();
            return ftpFiles;
        }

    }

    /**
     * 删除FTP上面的文件
     *
     * @return 0:成功,1:失败
     */
    public int removeFile(String ftpFile) throws Exception {
        try {
            if (StringUtils.isNotEmpty(ftpFile)) {
                if (ftpClient == null) {
                    connect();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(GetProperties.getProperties("system.properties", "ftp.image.file.directory"));
                stringBuilder.append(StringUtils.substringBefore(SkylotUtils.getStrDate(), " "));
                stringBuilder.append("/");
                Thread.sleep(2000);
                ftpClient.changeWorkingDirectory(GetProperties.getProperties("system.properties", "ftp.image.file.directory"));
                if (ftpClient.changeWorkingDirectory(StringUtils.substringBefore(SkylotUtils.getStrDate(), " "))) {
                    FTPFile[] ftpFiles = ftpClient.listFiles();
                    for (int i = 0; i < ftpFiles.length; i++) {
                        FTPFile file = ftpFiles[i];
                        if (StringUtils.contains(file.getName(), ftpFile)) {
                            stringBuilder.append(file.getName());
                            break;
                        }
                    }
                }
                ftpClient.deleteFile(new String(stringBuilder.toString().getBytes("UTF-8"), "iso-8859-1"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return 0;
    }

}
