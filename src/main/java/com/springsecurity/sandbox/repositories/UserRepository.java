package com.springsecurity.sandbox.repositories;

import com.springsecurity.sandbox.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);
}
