package com.destiny.login.interceptor;

import com.destiny.login.annotation.MyInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author l_xj <l_xj@winning.com.cn>
 * @date 2020/8/6 13:28
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 标记名称，常量提出分装到常量类中
     */
    public static final String RESULT_ANNOTATION = "RESULT-ANNOTATION";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();

            // 注解在类上（controller）
            if (clazz.isAnnotationPresent(MyInfo.class)) {
                request.setAttribute(RESULT_ANNOTATION, clazz.getAnnotation(MyInfo.class));
            }
            // 注解在方法上
            else if (method.isAnnotationPresent(MyInfo.class)) {
                request.setAttribute(RESULT_ANNOTATION, method.getAnnotation(MyInfo.class));
            }
        }

        return true;
    }
}
