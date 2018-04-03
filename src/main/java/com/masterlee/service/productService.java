package com.masterlee.service;
import com.masterlee.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.masterlee.mapper.productMapper;
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
        System.out.print(i);
        return  true;
    }

    public List<product> selectProduct(){
        return productMapper.selectAll();
    }
    public  int  updateProduct(product product){
        return  productMapper.updateByPrimaryKey(product);
    }
    public  product selectProducById(Integer id){
        return  productMapper.selectByPrimaryKey(id);
    }
}
