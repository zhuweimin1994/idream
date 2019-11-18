package com.idream.userservice.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.idream.idreamapi.service.UserService;
import com.idream.userservice.dao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Userdao userdao;
    @Override
    public String test() {
        return userdao.test();
    }
}
