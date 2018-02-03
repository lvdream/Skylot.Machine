package com.fangda.skylot.mathine.utils.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

/**
 * Created by Saul on 05/08/2017.
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@PrepareForTest({FtpUtils.class})
public class FtpUtilsTest {
    private FTPClient ftpClient;
    private FtpUtils ftpUtils;

    @Before
    public void setUp() throws Exception {
        ftpUtils = new FtpUtils();
        ftpClient = mock(FTPClient.class);
        ftpUtils.setFtpClient(ftpClient);
    }

    @Test
    public void uploadFile() throws Exception {
        File file = mock(File.class);
        FileInputStream fileInputStream = mock(FileInputStream.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(fileInputStream);
        String filename = anyString();
        assertEquals(0, ftpUtils.uploadFile(filename));
    }

    @Test
    public void download() throws Exception {
        FTPFile ftpFile = mock(FTPFile.class);
        FileOutputStream fileOutputStream = mock(FileOutputStream.class);
        InputStream in = mock(InputStream.class);
        FTPFile[] ftpFiles = new FTPFile[2];
        ftpFiles[0] = ftpFile;
        ftpFiles[1] = ftpFile;
        File file = mock(File.class);
        File parentFile = mock(File.class);
        PowerMockito.when(ftpClient.listFiles(anyString())).thenReturn(ftpFiles);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
//        PowerMockito.whenNew(byte[].class).withAnyArguments().thenReturn(file);
        PowerMockito.whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        PowerMockito.when(file.getParentFile()).thenReturn(parentFile);
        PowerMockito.when(parentFile.exists()).thenReturn(true);
        PowerMockito.when(ftpClient.retrieveFileStream(anyString())).thenReturn(in);
        PowerMockito.when(in.read(ArgumentMatchers.<byte[]>any())).thenReturn(-1);
        assertEquals(1, ftpUtils.download("w", "a"));
    }


}