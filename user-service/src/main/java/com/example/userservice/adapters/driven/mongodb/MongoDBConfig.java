package com.example.userservice.adapters.driven.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "userdb";
    }

    @Override
    public MongoClient mongoClient() {

        String connectionString = "mongodb://localhost:27017";
        return MongoClients.create(connectionString);
    }

}