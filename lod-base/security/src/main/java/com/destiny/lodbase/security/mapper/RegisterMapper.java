package com.destiny.lodbase.security.mapper;

import com.destiny.lodbase.security.pojo.Role;
import com.destiny.lodbase.security.pojo.User;

/**
 * @author lee
 */
public interface RegisterMapper {

    /**
     * 用户注册
     * @param user 用户信息
     * @return 是否成功
     */
    int insertUser(User user);

    /**
     * 未注册用户添加基础角色
     * @param user 用户信息
     * @param role 角色信息
     * @return 是否成功
     */
    int insertUserCommonRole(User user,Role role);
}
