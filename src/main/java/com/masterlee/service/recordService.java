package com.masterlee.service;

import com.masterlee.entity.record;
import com.masterlee.mapper.recordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recordService {
    @Autowired
    private recordMapper recordMapper;
    public List<record> selectAll(){
        return  recordMapper.selectAll();
    }
    public  boolean addRecord(record record){
        int i = recordMapper.insert(record);
        return  i==1? true:false;
    }
}
