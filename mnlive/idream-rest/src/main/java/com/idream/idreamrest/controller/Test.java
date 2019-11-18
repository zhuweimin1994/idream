package com.idream.idreamrest.controller;

import com.idream.idreamrest.Service.RestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    RestUserService restUserService;

    @RequestMapping("aa")
    public String test(){
        return restUserService.test();
    }


}
