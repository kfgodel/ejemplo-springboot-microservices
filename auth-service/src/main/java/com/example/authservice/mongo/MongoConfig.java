package com.example.authservice.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.authservice.clients", "com.example.authservice.users"})
public class MongoConfig {

}