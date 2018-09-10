package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.Image;
import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.repositories.ImageRepository;
import com.sebastian.PondSite.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image createImage(Image image, List<Pond> ponds) {
        image.setPonds(ponds);
        return imageRepository.save(image);
    }

    public Image readImage(int id) {
        return imageRepository.findById(id).get();
    }

    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }

    public void deleteImage(Image image) {
        imageRepository.delete(image);
    }
}
