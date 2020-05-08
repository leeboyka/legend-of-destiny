package com.destiny.lodbase.common.service;

import com.destiny.lodbase.common.pojo.SftpAuthority;

/**
 *
 * @author lee
 */
public interface SftpService {

    /**
     * 从数据库获取默认SFTP服务信息
     * @return SftpAuthority
     */
    SftpAuthority getDefaultSftpAuthority();

}
