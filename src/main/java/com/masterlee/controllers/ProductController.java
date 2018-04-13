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

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    productService productService;
    @RequestMapping(value = "/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public responseResult addProduct (){

            responseResult<product> result;
            product product = new product();
            int random = new Random().nextInt(100);
            product.setName("测试商品"+random);
            product.setNumber(10);
            product.setCreatetime(new Date());
            //返回结果
            boolean effect =productService.addProduct(product);

            //失败,set=>code,message
            if (!effect){
                result = new responseResult<>("401","保存失败",effect);
            }
            //成功.return实体
            else {
                result = new responseResult<>(product,effect);
            }
            return  result;
    }

    @RequestMapping(value = "/select",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult selectAll(){
        responseResult<List<product>> result;

        try {
            List<product>  list = productService.selectProduct();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonstring =  objectMapper.writeValueAsString(list);
            result= new responseResult<List<product>>(list,true);
            return result;
        }
        catch (JsonProcessingException EX){
          result =new responseResult<>("401",EX.getMessage(),false);
            EX.printStackTrace();
            return result;
        }
    }
    @RequestMapping(value = "/update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult update(product product) {
        responseResult<product> result;
        boolean effect= productService.updateProduct(product);
        if (!effect){
            result = new responseResult<product>("401","保存失败",effect);
        }
        //成功.return实体
        else {
            result = new responseResult<product>(product,effect);
        }
        return result;
    }

    @RequestMapping(value = "/delete",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult delete(Integer productId,boolean status) {
        responseResult<String> result;
        HashMap map = new HashMap();
        map.put("id",36);
        map.put("ifdelete",true);
        boolean effect= productService.removeProduct(map);
        if (!effect){
            result = new responseResult<String>("401","保存失败",effect);
        }
        else {
            result = new responseResult<String>("删除成功",effect);
        }
        return result;
    }
}
