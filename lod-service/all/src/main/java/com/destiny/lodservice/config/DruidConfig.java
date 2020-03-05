package com.destiny.lodservice.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DruidConfig
 * @Description Druid监控配置类
 * @Author lee
 * @Date 2020/3/5 21:43
 */
@Configuration
public class DruidConfig {

    /**
     * 注册 Servlet 组件
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //servletRegistrationBean提供的类进行注册
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //添加初始化参数initParams
        //servletRegistrationBean.addInitParameter("allow", "192.168.1.3"); //白名单
        //servletRegistrationBean.addInitParameter("deny", "192.168.1.3"); //黑名单;与白名单共存时,deny优先于allow
        //登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername", "leeboyka");
        servletRegistrationBean.addInitParameter("loginPassword", "lang13572081952");
        //能否重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册Filter组件
     */
    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则，验证所有请求
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的信息格式，对 *.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/* 不进行验证
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
