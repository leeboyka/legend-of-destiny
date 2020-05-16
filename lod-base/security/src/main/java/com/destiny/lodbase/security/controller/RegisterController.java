package com.destiny.lodbase.security.controller;

import com.destiny.lodbase.security.service.RegisterService;
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
 * @author lee
 */
@RestController
@Slf4j
@Api(value = "Register API", tags = "Register", description = "注册")
@RequestMapping(value = "/register")
public class RegisterController {


    @Resource
    private RegisterService registerService;


    @ApiOperation(value = "Register", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", dataType = "String", required = true, paramType = "query")
    })
    @RequestMapping(value = "/user_register", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object userRegister(@RequestParam String userName, @RequestParam String userPassword) {
        return registerService.registerUser(userName, userPassword);
    }
}
