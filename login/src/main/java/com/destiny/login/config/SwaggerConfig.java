package com.destiny.login.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger ui config
 *
 * @author leeboyka
 * @date 2020/03/04 20:28
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${swagger.enable}")
    private boolean enableSwagger;


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Legend Of Destiny")
                .description("legend of destiny API")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("lee", "https://weibo.com/5993923898/", "13572081952@163.com"))
                .build();
    }


    @Bean
    public Docket createHnsApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.destiny.login.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("Login");
    }


    /**
     * swagger ui资源映射
     *
     * @param registry ViewControllerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * swagger-ui.html路径映射，浏览器中使用/api-docs访问
     *
     * @param registry ViewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api-docs", "/swagger-ui.html");
    }

}
