package com.destiny.lodbase.common.error;

/**
 * 业务异常
 *
 * @author leeboyka
 * @date 2020/03/23 20:54
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
