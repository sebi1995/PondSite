package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.Pond;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PondRepository extends CrudRepository<Pond, Integer> {
}
