package com.destiny.lodbase.common.pojo;

import com.destiny.lodbase.common.service.SftpService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;

/**
 *
 * @author lee
 */
@Getter
@Setter
public class SftpAuthority {

    @Resource
    private SftpService service;

    /**
     * SFTP 服务器ip或者主机名
     */
    private String host;

    /**
     * SFTP端口
     */
    private int port;

    /**
     * SFTP 登录用户名
     */
    private String username;

    /**
     * SFTP 登录密码
     */
    private String password;

    /**
     * SFTP 私钥密钥
     */
    private String privateKey;

    /**
     * 默认无参构造函数，使用数据库配置的服务信息
     */
    public SftpAuthority() {
        SftpAuthority authority = service.getDefaultSftpAuthority();
        this.host = authority.getHost();
        this.port = authority.getPort();
        this.username = authority.getUsername();
        this.password = authority.getPassword();
        this.privateKey = authority.getPrivateKey();
    }

    /**
     * 构造基于密码认证的sftp服务器对象
     *
     * @param username username
     * @param password password
     * @param host     host
     * @param port     port
     */
    public SftpAuthority(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * 构造基于秘钥认证的sftp对象
     *
     * @param host       host
     * @param port       port
     * @param username   username
     * @param privateKey privateKey
     */
    public SftpAuthority(String host, int port, String username, String privateKey) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.privateKey = privateKey;
    }

}
