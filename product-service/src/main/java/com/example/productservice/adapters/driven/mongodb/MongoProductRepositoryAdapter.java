package com.example.productservice.adapters.driven.mongodb;

import com.example.productservice.domain.Product;
import com.example.productservice.application.ports.OutboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoProductRepositoryAdapter implements OutboundPort {

    @Autowired
    private MongoProductRepository mongoRepository;

    @Override
    public List<Product> findAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return mongoRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return mongoRepository.save(product);
    }

    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return mongoRepository.findByName(name);
    }

    @Override
    public List<Product> findProductsByPriceRange(int minPrice, int maxPrice) {
        return mongoRepository.findProductsByPriceRange(minPrice, maxPrice);
    }
}
