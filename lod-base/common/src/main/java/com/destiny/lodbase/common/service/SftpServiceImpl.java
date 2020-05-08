package com.destiny.lodbase.common.service;

import com.destiny.lodbase.common.pojo.SftpAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author lee
 */
@Service
public class SftpServiceImpl implements SftpService {
    @Override
    public SftpAuthority getDefaultSftpAuthority() {
        // todo 连接数据库，获取配置服务器信息
        return null;
    }
}
