package com.destiny.lodbase.common.response;

import lombok.Getter;

/**
 * 结果code码管理枚举类
 *
 * @author leeboyka
 * @date 2020/03/23 14:03
 */
@Getter
public enum ResultCodeEnum {

    //  响应成功
    SUCCESS(true, 1000, "成功"),

    //  未知错误
    UNKNOWN_ERROR(false, 2000, "未知错误"),

    //  参数错误
    PARAM_ERROR(false, 3000, "参数错误"),

    //  用户名或密码错误
    LOGIN_ERROR(false, 4000, "用户名或密码错误"),

    //  权限不足
    ACCESS_ERROR(false, 4001, "权限不足"),

    //  调用远程失败
    REMOTE_ERROR(false, 5000, "调用远程失败"),

    //  重复操作
    REPEAT_ERROR(false, 6000, "重复操作");


    /**
     * 响应是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;


    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


}
