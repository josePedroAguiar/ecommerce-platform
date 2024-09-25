package com.example.productservice.adapters.driven.mongodb;

import com.example.productservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name);

    @Query("{ 'price' : { $gt: ?0, $lt: ?1 } }")
    List<Product> findProductsByPriceRange(int minPrice, int maxPrice);
}
