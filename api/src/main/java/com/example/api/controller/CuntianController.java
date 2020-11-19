package com.example.api.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "村田接口")
@Controller
public class CuntianController {

    @GetMapping(value = "/cuntian/hello")
    @ResponseBody
    public String cuntian(){
        return "这是给cuntian提供的数据！";
    }
}
