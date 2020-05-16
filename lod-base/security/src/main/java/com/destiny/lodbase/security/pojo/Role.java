package com.destiny.lodbase.security.pojo;


import lombok.Builder;
import lombok.Data;

/**
 * @author lee
 */
@Data
@Builder
public class Role {
    private Integer roleId;
    private String roleName;
}
