package com.destiny.login.service;

/**
 * @author lee
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param code String
     * @return int
     */
    int login(String code);
}
