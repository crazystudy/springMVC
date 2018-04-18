package com.masterlee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import  com.masterlee.service.productService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeContrllers {
    @Autowired
    productService productService;
    @RequestMapping("/test")
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response){/*
        product product = new product();
        product.setName("测试11");
        product.setNumber(1);
        product.setDescription("无");
        productService.test(product);*/
        return "hao";
    }
}