package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
