package com.example.orderservice.adapters.driven.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "orderdb";  // Specify your database name here
    }

    @Override
    public MongoClient mongoClient() {

        String connectionString = "mongodb://localhost:27017";
        return MongoClients.create(connectionString);
    }


    /*@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }*/
}
