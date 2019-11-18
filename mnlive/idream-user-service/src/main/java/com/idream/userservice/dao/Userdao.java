package com.idream.userservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Userdao {
    @Select("select 1 ")
    String test();
}
