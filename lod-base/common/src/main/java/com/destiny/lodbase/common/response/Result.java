package com.destiny.lodbase.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果类
 *
 * @author leeboyka
 * @date 2020/03/23 17:03
 */
@Data
public class Result implements Serializable {

    private Boolean success;

    private String status;

    private String message;

    private Object data;

    private Result() {
    }

    /**
     * 成功时返回结果
     *
     * @return Result
     */
    public static Result success() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 失败时返回结果
     *
     * @return Result
     */
    public static Result failure() {
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        result.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        result.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return result;
    }

    /**
     * 设置返回结果
     *
     * @param resultCodeEnum ResultCodeEnum
     * @return Result
     */
    public static Result setResult(ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        result.setSuccess(resultCodeEnum.getSuccess());
        result.setStatus(resultCodeEnum.getStatus());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 返回结果中数据设置
     * @param data 结果中返回的数据
     * @return Result
     */
    public Result data(Object data) {
        this.setData(data);
        return this;
    }

    private static final long serialVersionUID = 8979432098347989854L;

}
