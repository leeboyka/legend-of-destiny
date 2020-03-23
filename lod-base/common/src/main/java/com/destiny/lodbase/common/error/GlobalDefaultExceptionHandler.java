package com.destiny.lodbase.common.error;

import com.destiny.lodbase.common.response.Result;
import com.destiny.lodbase.common.response.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一业务异常处理类
 *
 * @author leeboyka
 * @date 2020/03/23 21:06
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler({BusinessException.class})

    public Result defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {

        return Result.setResult(ResultCodeEnum.UNKNOWN_ERROR);

    }
}
