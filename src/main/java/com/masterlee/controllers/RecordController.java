package com.masterlee.controllers;

import com.masterlee.entity.record;
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
       responseResult<List<record>> result = new responseResult<>();
       List<record> list = recordService.selectAll();
       result.setResponseData(list);
       return  result;
    } @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult add(record record){
        responseResult<record> result = new responseResult<>();
        boolean effect =  recordService.addRecord(record);
        result.setResponseStatus(effect);
        result.setResponseData(record);
        return  result;
    }

}
