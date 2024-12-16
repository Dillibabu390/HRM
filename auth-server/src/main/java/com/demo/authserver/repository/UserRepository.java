package com.demo.authserver.repository;


import com.demo.authserver.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,Integer> {
    Optional<UserEntity> findByName(String username);
}
