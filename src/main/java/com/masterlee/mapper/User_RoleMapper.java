package com.masterlee.mapper;

import com.masterlee.entity.User_Role;

public interface User_RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(User_Role record);

    int insertSelective(User_Role record);

    User_Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);
}