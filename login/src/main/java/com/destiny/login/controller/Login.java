package com.destiny.login.controller;

import com.destiny.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录
 * @Author lee
 * @Date 2020/3/4 20:48
 */
@RestController
@Slf4j
@Api(value = "Login API", tags = "Login",description="登录")
public class Login {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "Login",notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "编号",dataType = "String",required = true,paramType = "query")
    })
    @RequestMapping(value = "/login",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public int halloWord(@RequestParam String code){
        return loginService.login(code);
    }
}
