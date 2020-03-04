package com.destiny.login.service;

import com.destiny.login.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录
 * @Author lee
 * @Date 2020/3/4 20:48
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public int login(String code) {
        return loginMapper.login(code);
    }

}
