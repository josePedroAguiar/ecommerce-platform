package com.example.productservice.application.ports;

import com.example.productservice.domain.Product;

import java.util.List;
import java.util.Optional;

public interface DrivingPort {
    List<Product> findAll();
    Optional<Product> findById(String id);
    Product save(Product product);
    void deleteById(String id);
    List<Product> findByName(String name);

    List<Product> findProductsByPriceRange(int minPrice, int maxPrice);
}