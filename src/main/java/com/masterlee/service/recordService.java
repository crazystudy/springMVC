package com.masterlee.service;

import com.masterlee.entity.ProductRecord;
import com.masterlee.mapper.ProductRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recordService {
    @Autowired
    private ProductRecordMapper productRecordMapper;
    public List<ProductRecord> selectAll(){
        return  productRecordMapper.selectAll();
    }
    public  boolean addRecord(ProductRecord record){
        int i = productRecordMapper.insert(record);
        return  i==1? true:false;
    }
}
