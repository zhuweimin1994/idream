package com.idream.idreamrest.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import com.idream.idreamapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class RestUserService {

    @Reference
    UserService userService;


    public String test(){
        return userService.test();
    }

}
