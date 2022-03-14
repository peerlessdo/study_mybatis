package com.atgg.mybatis.mapper;

import com.atgg.mybatis.pojo.User;

public interface UserMapper {

    int insertUser();

    int deleteUser();

    User selectUser();

    int updateUser();
}
