package com.masterlee.mapper;

import com.masterlee.entity.ProductRecord;

import java.util.List;

public interface ProductRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductRecord record);

    int insertSelective(ProductRecord record);

    ProductRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductRecord record);

    int updateByPrimaryKey(ProductRecord record);
    List<ProductRecord> selectAll();
}