package com.shanto.springBootRedis.repository;

import com.shanto.springBootRedis.model.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";
    private RedisTemplate redisTemplate;

    public Product save(Product product){

        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);

        return product;
    }

    public List<Product> findAll(){

        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findById(int id){

        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id){

        redisTemplate.opsForHash().delete(HASH_KEY, id);

        return "Deleted product!";
    }
}
