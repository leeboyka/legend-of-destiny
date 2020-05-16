package com.destiny.lodbase.security.service;

import com.destiny.lodbase.common.service.UidService;
import com.destiny.lodbase.security.mapper.RegisterMapper;
import com.destiny.lodbase.security.pojo.Role;
import com.destiny.lodbase.security.pojo.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * @author lee
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UidService uidService;

    @Resource
    private RegisterMapper registerMapper;

    @Override
    public int registerUser(String userName, String userPassword) {

        if (isBlank(userName)) {
            return 1;
        }

        if (isBlank(userPassword)) {
            return 2;
        }


        // 密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

        User user = User.builder()
                .userId((int) uidService.getUid())
                .userName(userName)
                .userPassword(encoder.encode(userPassword))
                .userEnabled(true)
                .userLocked(false)
                .build();

        // 为用户添加基础角色
        Role role = Role.builder()
                .roleId(00)
                .roleName("普通用户")
                .build();

        registerMapper.insertUserCommonRole(user,role);

        return registerMapper.insertUser(user);
    }
}
