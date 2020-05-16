package com.destiny.lodbase.security.mapper;

import com.destiny.lodbase.security.pojo.Role;
import com.destiny.lodbase.security.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lee
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名查找用户
     * @param userName userName
     * @return User
     */
    User loadUserByUsername(String userName);

    /**
     * 通过用户id获取用户角色
     * @param id id
     * @return List<Role>
     */
    List<Role> getUserRolesByUid(Integer id);
}
