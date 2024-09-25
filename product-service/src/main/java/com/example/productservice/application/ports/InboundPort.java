package com.example.productservice.application.ports;

import com.example.productservice.domain.Product;

import java.util.List;
import java.util.Optional;

public interface InboundPort {
    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    Product createOrUpdateProduct(Product product,String region);
    void deleteProductById(String id);


;


}
