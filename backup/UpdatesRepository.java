package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatesRepository extends CrudRepository<Update, Integer> {
}
