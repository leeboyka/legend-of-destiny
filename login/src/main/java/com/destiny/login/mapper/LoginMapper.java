package com.destiny.login.mapper;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录
 * @Author lee
 * @Date 2020/3/4 20:48
 */
public interface LoginMapper {

    /**
     * 登录
     *
     * @param code Sting
     * @return int
     */
    int login(String code);
}
