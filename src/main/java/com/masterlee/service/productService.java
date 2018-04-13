package com.masterlee.service;
import com.masterlee.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.masterlee.mapper.productMapper;

import java.util.HashMap;
import java.util.List;

@Service
public class productService {
    @Autowired
    private productMapper productMapper;
    public  String test(product product){
        productMapper.insert(product);
        return  "ok";
    }

    public  boolean addProduct(product product){
        int i = productMapper.insert(product);
        return  i==1? true:false;
    }

    public List<product> selectProduct(){
        return productMapper.selectAll();
    }
    public  boolean  updateProduct(product product){
        int i = productMapper.updateByPrimaryKey(product);
        return  i==1? true:false;
    }
    public  product selectProducById(Integer id){
        return  productMapper.selectByPrimaryKey(id);
    }
    public  boolean deleteProduct(Integer id )
    {
        int i = productMapper.deleteByPrimaryKey(id);
        return  i==1? true:false;
    }
    public  boolean removeProduct(HashMap map){
        int i = productMapper.removeByPrimaryKey(map);
        return i>0? true:false;
    }
}
