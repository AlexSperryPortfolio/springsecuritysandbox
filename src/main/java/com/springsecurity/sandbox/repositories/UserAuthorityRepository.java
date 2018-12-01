package com.springsecurity.sandbox.repositories;

import com.springsecurity.sandbox.domain.UserAuthority;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {
}
