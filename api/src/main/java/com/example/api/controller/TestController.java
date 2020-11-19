package com.example.api.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "用户管理相关接口")
//@RestController
@Controller
public class TestController {

//    @RequestMapping("/hello")
//    @ApiOperation("hello")
//    @ApiImplicitParam(name = "name", value = "姓名", defaultValue = "LP", required = true)
//    public String sayHello() {
//        return "hello";
//    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/liangpan/hello")
    @ResponseBody
    public String liangpan(){
        return "liangpan";
    }

}
