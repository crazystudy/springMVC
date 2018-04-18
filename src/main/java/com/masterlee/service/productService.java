package com.masterlee.service;
import com.masterlee.entity.Product;
import com.masterlee.entity.ProductRecord;
import com.masterlee.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class productService {
    @Autowired
    private ProductMapper productMapper;
    public  String test(Product product){
        productMapper.insert(product);
        return  "ok";
    }

    public  boolean addProduct(Product product){
        int i = productMapper.insert(product);
        return  i==1? true:false;
    }

    public List<Product> selectProduct(){
        return productMapper.selectAll();
    }
    public  boolean  updateProduct(Product product){
        int i = productMapper.updateByPrimaryKey(product);
        return  i==1? true:false;
    }
    public  Product selectProducById(String id){
        return  productMapper.selectByPrimaryKey(id);
    }
    public  boolean deleteProduct(String id )
    {
        int i = productMapper.deleteByPrimaryKey(id);
        return  i==1? true:false;
    }
    public  boolean removeProduct(HashMap map){
        int i = productMapper.removeByPrimaryKey(map);
        return i>0? true:false;
    }
}
