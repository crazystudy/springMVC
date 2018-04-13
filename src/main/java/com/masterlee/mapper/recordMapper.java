package com.masterlee.mapper;

import com.masterlee.entity.record;

import java.util.HashMap;
import java.util.List;

public interface recordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(record record);

    int insertSelective(record record);

    record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(record record);

    int updateByPrimaryKey(record record);
    List<record> selectAll();
}