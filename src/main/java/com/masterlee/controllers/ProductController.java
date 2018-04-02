package com.masterlee.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterlee.entity.product;
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
    @RequestMapping("/add")
    @ResponseBody
    public  String  addProduct (){
        try {
            product product = new product();
            int random = new Random().nextInt(100);
            product.setName("测试商品"+random);
            product.setNumber(10);
            product.setCreatetime(new Date());
           productService.addProduct(product);
            List<product>  list = productService.selectProduct();

            ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.writeValue(System.out,list);
            return System.out.toString();
        }catch (JsonProcessingException EX){

            EX.printStackTrace();
            return EX.getMessage();
        }catch (IOException ex)
        {
            return  ex.getMessage();
        }

    }
}
