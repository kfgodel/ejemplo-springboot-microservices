package com.example.authservice.clients;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthClientRepository extends MongoRepository<AuthClientDetails, String> {

    Optional<AuthClientDetails> findByClientId(String clientId);

}