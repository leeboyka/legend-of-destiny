package com.destiny.lodbase.security.mapper;

import com.destiny.lodbase.security.controller.Role;
import com.destiny.lodbase.security.controller.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    User loadUserByUsername(String userName);

    /**
     * 通过用户id获取用户角色
     * @param id
     * @return
     */
    List<Role> getUserRolesByUid(Integer id);
}
