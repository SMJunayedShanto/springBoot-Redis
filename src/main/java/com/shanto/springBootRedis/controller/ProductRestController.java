package com.shanto.springBootRedis.controller;

import com.shanto.springBootRedis.model.Product;
import com.shanto.springBootRedis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/save")
    public Product save(@RequestBody Product product){

        return productDao.save(product);
    }

    @GetMapping("/list")
    public List<Product> getAll(){

        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int id){

        return productDao.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {

        return productDao.deleteProduct(id);
    }
}
