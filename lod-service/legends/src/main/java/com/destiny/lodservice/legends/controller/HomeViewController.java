package com.destiny.lodservice.legends.controller;

import com.destiny.lodservice.legends.service.HomeViewService;
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
 * @author leeboyka
 */
@RestController
@Slf4j
@Api(value = "HomeView API", tags = "HomeView",description="首页")
@RequestMapping(value = "/home_view")
public class HomeViewController {

    @Resource
    private HomeViewService homeViewService;

    @ApiOperation(value = "hallo word",notes = "“hallo word”；正确请求编号为“2020”")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "编号",dataType = "String",required = true,paramType = "query")
    })
    @RequestMapping(value = "/page",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String halloWord(@RequestParam String code){
        return homeViewService.showHallo(code);
    }

}
