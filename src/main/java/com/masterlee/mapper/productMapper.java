package com.masterlee.mapper;

import com.masterlee.entity.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    List<Product> selectAll();
    int removeByPrimaryKey(HashMap map);
}