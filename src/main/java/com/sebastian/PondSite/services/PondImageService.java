package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.PondImage;
import com.sebastian.PondSite.repositories.PondImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PondImageService {

    @Autowired
    private PondImageRepository pondImageRepository;

    public List<PondImage> getAllPondImages() {
        return (List<PondImage>) pondImageRepository.findAll();
    }

    public void createPondImage(PondImage pondImage) {
        pondImageRepository.save(pondImage);
    }
}
