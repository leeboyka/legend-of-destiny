package com.destiny.login.config;

import com.destiny.login.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author l_xj <l_xj@winning.com.cn>
 * @date 2020/8/7 10:19
 */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        interceptorRegistry.addInterceptor(myInterceptor)
                // addPathPatterns("/**") 表示拦截所有的请求，
                .addPathPatterns("/**");
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外
        // .excludePathPatterns("/login", "/register");
    }

}
