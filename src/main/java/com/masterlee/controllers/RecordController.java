package com.masterlee.controllers;

import com.masterlee.entity.ProductRecord;
import com.masterlee.service.recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.masterlee.entity.responseResult;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    recordService recordService;
    @RequestMapping(value = "/select",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult selectAll(){

       List<ProductRecord> list = recordService.selectAll();
        responseResult<List<ProductRecord>> result = new responseResult<List<ProductRecord>>(list,true);
       return  result;
    } @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult add(ProductRecord record){
        boolean effect =  recordService.addRecord(record);
        responseResult<ProductRecord> result = new responseResult<ProductRecord>(record,effect);
        return  result;
    }

}
