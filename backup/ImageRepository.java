package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.PondImage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<PondImage, Integer> {
}
