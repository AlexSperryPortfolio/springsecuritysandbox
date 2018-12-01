package com.springsecurity.sandbox.repositories;

import com.springsecurity.sandbox.domain.Authority;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
