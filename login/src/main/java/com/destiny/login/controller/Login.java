package com.destiny.login.controller;

import com.destiny.login.annotation.MyGetMapping;
import com.destiny.login.annotation.MyInfo;
import com.destiny.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录
 * @Author lee
 * @Date 2020/3/4 20:48
 */
@RestController
@Slf4j
@Api(value = "Login API", tags = "Login")
public class Login {

    @Resource
    private LoginService loginService;

    @MyInfo
    @ApiOperation(value = "Login",notes = "登录")
    @MyGetMapping("/login")
    public Object halloWord(@RequestBody String code){
        System.out.println("登录方法");
        return loginService.login(code);
    }
}
