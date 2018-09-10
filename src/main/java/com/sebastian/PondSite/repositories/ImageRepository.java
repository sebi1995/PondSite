package com.sebastian.PondSite.repositories;

import com.sebastian.PondSite.entities.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
