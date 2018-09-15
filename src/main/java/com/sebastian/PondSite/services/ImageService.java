package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.Image;
import com.sebastian.PondSite.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return (List<Image>) imageRepository.findAll();
    }

    public void createImage(Image image) {
        imageRepository.save(image);
    }
}
