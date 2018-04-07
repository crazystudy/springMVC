package com.masterlee.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterlee.entity.product;
import com.masterlee.entity.responseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.masterlee.service.productService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    productService productService;
    @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public responseResult addProduct (){

            responseResult<product> result= new responseResult<>();
            product product = new product();
            int random = new Random().nextInt(100);
            product.setName("测试商品"+random);
            product.setNumber(10);
            product.setCreatetime(new Date());
            //返回结果
            boolean effect =productService.addProduct(product);
            result.setResponseStatus(effect);
            //失败,set=>code,message
            if (!effect){
                result.setErrorCode("4001");
                result.setErrorMessage("保存失败,请重试");
            }
            //成功.return实体
            else {
                result.setResponseData(product);
            }
            return  result;
    }

    @RequestMapping(value = "/select",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult selectAll(){
        responseResult<List<product>> result= new responseResult<>();

        try {
            List<product>  list = productService.selectProduct();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonstring =  objectMapper.writeValueAsString(list);
            result.setResponseData(list);
            return result;
        }
        catch (JsonProcessingException EX){
            result.setErrorCode("4001");
            result.setResponseStatus(false);
            result.setErrorMessage(EX.getMessage());
            EX.printStackTrace();
            return result;
        }
    }
    @RequestMapping(value = "/update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult update(product product) {
        responseResult<product> result= new responseResult<>();
        boolean effect= productService.updateProduct(product);
        result.setResponseStatus(effect);
        if (!effect){
            result.setErrorCode("4001");
            result.setErrorMessage("保存失败,请重试");
        }
        //成功.return实体
        else {
            result.setResponseData(product);
        }
        return result;
    }
    @RequestMapping(value = "/delete",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult delete(Integer productId) {
        responseResult<String> result= new responseResult<>();
        boolean effect= productService.deleteProduct(productId);
        result.setResponseStatus(effect);
        if (!effect){
            result.setErrorCode("4001");
            result.setErrorMessage("保存失败,请重试");
        }
        //成功.return实体
        else {
            result.setResponseData("删除成功");
        }
        return result;
    }
}
