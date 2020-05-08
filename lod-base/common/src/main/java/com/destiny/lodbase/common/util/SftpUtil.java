package com.destiny.lodbase.common.util;

import com.destiny.lodbase.common.pojo.SftpAuthority;
import com.jcraft.jsch.*;

import java.util.Properties;
import java.io.*;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

/**
 * @description SFTP工具类
 * @author: lenovo
 * @date: 2020/5/8 9:18
 * @version:
 * @modified By:
 */
public class SftpUtil {

    private ChannelSftp channelSftp;

    private Session session;

    /**
     * @param authority SftpAuthority
     */
    public SftpUtil(SftpAuthority authority) {
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(authority.getUsername(), authority.getHost(), authority.getPort());
            if (authority.getPassword() != null) {
                // 使用用户名密码创建SSH
                session.setPassword(authority.getPassword());
            }
            if (authority.getPrivateKey() != null) {
                // 使用私钥创建SSH
                jsch.addIdentity(authority.getPrivateKey());
            }
            Properties config = new Properties();
            // 主动接收ECDSA key fingerprint，不进行HostKeyChecking
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            // 设置超时时间为无穷大
            session.setTimeout(0);
            session.connect();
            // 打开SFTP通道
            Channel channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭连接 server
     */
    public void logout() {
        if (channelSftp != null) {
            if (channelSftp.isConnected()) {
                channelSftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件
     *
     * @param directory    上传到该目录
     * @param sftpFileName sftp端文件名
     * @param input        输入流
     * @throws SftpException SftpException
     */
    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException {
        try {
            channelSftp.cd(directory);
        } catch (SftpException e) {
            channelSftp.mkdir(directory);
            channelSftp.cd(directory);
        }
        channelSftp.put(input, sftpFileName, ChannelSftp.OVERWRITE);
    }

    /**
     * 上传单个文件
     *
     * @param directory  上传到sftp目录
     * @param uploadFile 要上传的文件,包括路径
     * @throws SftpException         SftpException
     * @throws FileNotFoundException FileNotFoundException
     */
    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException {
        File file = new File(uploadFile);
        upload(directory, file.getName(), new FileInputStream(file));
    }

    /**
     * 将byte[]上传到sftp，作为文件。注意:从String生成byte[]是，要指定字符集。
     *
     * @param directory    上传到sftp目录
     * @param sftpFileName 文件在sftp端的命名
     * @param byteArr      要上传的字节数组
     * @throws SftpException SftpException
     */
    public void upload(String directory, String sftpFileName, byte[] byteArr) throws SftpException {
        upload(directory, sftpFileName, new ByteArrayInputStream(byteArr));
    }

    /**
     * 将字符串按照指定的字符编码上传到sftp
     *
     * @param directory    上传到sftp目录
     * @param sftpFileName 文件在sftp端的命名
     * @param dataStr      待上传的数据
     * @param charsetName  sftp上的文件，按该字符编码保存
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     * @throws SftpException                SftpException
     */
    public void upload(String directory, String sftpFileName, String dataStr, String charsetName) throws UnsupportedEncodingException, SftpException {
        upload(directory, sftpFileName, new ByteArrayInputStream(dataStr.getBytes(charsetName)));
    }

    /**
     * 下载文件（保存到本地）
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @throws SftpException         SftpException
     * @throws FileNotFoundException FileNotFoundException
     */
    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException {
        if (directory != null && !"".equals(directory)) {
            channelSftp.cd(directory);
        }
        File file = new File(saveFile);
        channelSftp.get(downloadFile, new FileOutputStream(file));
    }

    /**
     * 下载文件（并以字节数组读取）
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件名
     * @return 字节数组
     * @throws SftpException SftpException
     * @throws IOException   IOException
     */
    public byte[] download(String directory, String downloadFile) throws SftpException, IOException {
        if (directory != null && !"".equals(directory)) {
            channelSftp.cd(directory);
        }
        InputStream is = channelSftp.get(downloadFile);
        return IOUtils.toByteArray(is);
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @throws SftpException SftpException
     */
    public void delete(String directory, String deleteFile) throws SftpException {
        channelSftp.cd(directory);
        channelSftp.rm(deleteFile);
    }

    /**
     * 列出目录下的文件
     *
     * @param directory 要列出的目录
     * @return Vector<?>
     * @throws SftpException SftpException
     */
    public Vector<?> listFiles(String directory) throws SftpException {
        return channelSftp.ls(directory);
    }
}