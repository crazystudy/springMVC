package com.masterlee.mapper;

import com.masterlee.entity.product;

import java.util.List;

public interface productMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(product record);

    int insertSelective(product record);

    product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(product record);

    int updateByPrimaryKeyWithBLOBs(product record);

    int updateByPrimaryKey(product record);
    List<product> selectAll();
}