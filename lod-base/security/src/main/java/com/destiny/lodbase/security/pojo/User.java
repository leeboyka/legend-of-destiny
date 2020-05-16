package com.destiny.lodbase.security.pojo;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lee
 */
@Data
@Builder
public class User implements UserDetails {

    private Integer userId;

    private String userName;

    private String userPassword;

    private Boolean userEnabled;

    private Boolean userLocked;

    private List<Role> roles;


    /**
     * 获取用户对象所具有的角色信息
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    /**
     * 获取用户对象的密码
     *
     * @return
     */
    @Override
    public String getPassword() {
        return userPassword;
    }

    /**
     * 获取用户对象用户名
     *
     * @return
     */
    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * 用户是否未过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否未锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !userLocked;
    }

    /**
     * 用户密码是否未过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否可用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return userEnabled;
    }

    private static final long serialVersionUID = 7407319515174625465L;

}
