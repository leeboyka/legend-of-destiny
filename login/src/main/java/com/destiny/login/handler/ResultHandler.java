package com.destiny.login.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author l_xj <l_xj@winning.com.cn>
 * @date 2020/8/6 13:51
 */
@ControllerAdvice
public class ResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 标记名称, 常量提出分装到常量类中
     */
    public static final String RESULT_ANNOTATION = "RESULT-ANNOTATION";


    /**
     * 请求是否包含了注解标记
     * 1、若包含：进行结果封装
     * 2、若不包含：无需封装，直接返回
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converter) {
        ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttribute != null;
        HttpServletRequest httpServletRequest = servletRequestAttribute.getRequest();

        // 尝试获取包装标记
        Object resultAnnotation = httpServletRequest.getAttribute(RESULT_ANNOTATION);
        return resultAnnotation != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof Error) {
            System.out.println("失败时进入包装方法！");
            return "ERROR";
        }
        System.out.println("成功时进入包装方法！");
        return "SUCCESS";
    }

    /**
     * 将系统中的异常分装到错误信息的统一返回中，以便在上面的方法中： o instanceof Error
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleRuntimeException(Exception e){
        System.out.println("程序异常时进入包装方法！");
        return "UNEXPECTED_ERROR";
    }
}
