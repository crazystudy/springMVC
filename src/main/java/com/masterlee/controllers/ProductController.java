package com.masterlee.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterlee.entity.Product;
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

            responseResult<Product> result;
        Product product = new Product();
            int random = new Random().nextInt(100);
            product.setName("测试商品"+random);
            product.setNumber(10);
            product.setCreateTime(new Date());
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
        responseResult<List<Product>> result;

        try {
            List<Product>  list = productService.selectProduct();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonstring =  objectMapper.writeValueAsString(list);
            result= new responseResult<List<Product>>(list,true);
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
    public  responseResult update(Product product) {
        responseResult<Product> result;
        boolean effect= productService.updateProduct(product);
        if (!effect){
            result = new responseResult<Product>("401","保存失败",effect);
        }
        //成功.return实体
        else {
            result = new responseResult<Product>(product,effect);
        }
        return result;
    }

    @RequestMapping(value = "/delete",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  responseResult delete(String productId,boolean status) {
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
