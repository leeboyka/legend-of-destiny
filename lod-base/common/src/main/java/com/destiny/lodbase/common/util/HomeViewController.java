package com.destiny.lodbase.common.util;

import com.destiny.lodbase.common.service.UidService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeboyka
 */
@RestController
@Slf4j
@Api(value = "HomeView API", tags = "HomeView", description = "首页")
@RequestMapping(value = "/home_view")
public class HomeViewController {

    @Resource
    UidService uidService;

    @ApiOperation(value = "hallo word", notes = "“hallo word”；正确请求编号为“2020”")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号", dataType = "String", required = true, paramType = "query")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object halloWord(@RequestParam String code) {
        List<Map<Long, String>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            Long uid = uidService.getUid();
            map.put(uid, uidService.parseUid(uid));
            res.add(map);
        }
        return res;
    }

}
