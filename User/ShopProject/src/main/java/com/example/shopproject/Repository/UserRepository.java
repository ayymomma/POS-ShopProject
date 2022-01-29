package com.example.shopproject.Repository;

import com.example.shopproject.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByToken(String token);
    boolean existsByName(String name);
    Optional<User> findByName(String name);
}
