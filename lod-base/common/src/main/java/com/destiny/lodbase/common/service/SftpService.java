package com.destiny.lodbase.common.service;

import com.destiny.lodbase.common.pojo.SftpAuthority;

/**
 * @description
 * @author: lenovo
 * @date: 2020/5/8 13:58
 * @version:
 * @modified By:
 */
public interface SftpService {

    /**
     * 从数据库获取默认SFTP服务信息
     * @return SftpAuthority
     */
    SftpAuthority getDefaultSftpAuthority();

}
