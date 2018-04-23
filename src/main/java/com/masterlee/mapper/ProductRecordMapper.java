package com.masterlee.mapper;

import com.masterlee.entity.ProductRecord;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductRecord record);

    int insertSelective(ProductRecord record);

    ProductRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductRecord record);

    int updateByPrimaryKey(ProductRecord record);
    List<ProductRecord> selectAll();
}