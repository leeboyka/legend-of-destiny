package com.destiny.lodbase.common.controller;

import com.destiny.lodbase.common.response.Result;
import com.destiny.lodbase.common.response.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 */
@RestController
@Slf4j
@Api(value = "HomeView API", tags = "HomeView",description="首页")
@RequestMapping(value = "/home_view")
public class TestController {

    @ApiOperation(value = "test", notes = "test")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号", dataType = "String", required = true, paramType = "query")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Result halloWord(@RequestParam String code) {

        Result result = null;

        if ("T".equals(code)) {
            result = Result.success().data("ddd");
        }

        if ("F".equals(code)) {

            result = Result.setResult(ResultCodeEnum.LOGIN_ERROR);
        }
        return result;

    }
}
