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
    SUCCESS(true, "SUCCESS", "成功"),

    //  未知错误
    UNKNOWN_ERROR(false, "UNKNOWN_ERROR", "未知错误"),

    //  参数错误
    PARAM_ERROR(false, "PARAM_ERROR", "参数错误"),

    //  用户名或密码错误
    LOGIN_ERROR(false, "LOGIN_ERROR", "用户名或密码错误"),

    //  权限不足
    ACCESS_ERROR(false, "ACCESS_ERROR", "权限不足"),

    //  调用远程失败
    REMOTE_ERROR(false, "REMOTE_ERROR", "调用远程失败"),

    //  数据库异常
    DATABASE_ERROR(false,"DATABASE_ERROR", "数据库异常"),

    //  重复操作
    REPEAT_ERROR(false, "REPEAT_ERROR", "重复操作");


    /**
     * 响应是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private String status;

    /**
     * 响应信息
     */
    private String message;


    ResultCodeEnum(boolean success, String status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }


}
