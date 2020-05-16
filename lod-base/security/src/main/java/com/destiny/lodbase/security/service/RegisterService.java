package com.destiny.lodbase.security.service;

/**
 * @author lee
 */
public interface RegisterService {

    /**
     * 用户注册
     *
     * @param userName     用户名
     * @param userPassword 用户密码
     * @return 是否成功
     */
    int registerUser(String userName, String userPassword);
}
