package com.destiny.lodbase.common.response;

import lombok.Data;

/**
 * 统一返回结果类
 *
 * @author leeboyka
 * @date 2020/03/23 17:03
 */
@Data
public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    private Result() {
    }

    public static Result success() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static Result failure() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        result.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        result.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return result;
    }

    public static Result setResult(ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        result.setSuccess(resultCodeEnum.getSuccess());
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public Result data(Object data) {
        this.setData(data);
        return this;
    }

}
