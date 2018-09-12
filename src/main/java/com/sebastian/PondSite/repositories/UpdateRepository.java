package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.SiteUpdate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepository extends CrudRepository<SiteUpdate, Integer> {

}
