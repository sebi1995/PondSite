package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.PondImage;
import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private PondImageRepository pondImageRepository;

    public Image createImage(PondImage pondImage, List<Pond> ponds) {
        image.setPonds(pondImage);
        return imageRepository.save(image);
    }

    public Image readImage(int id) {
        return imageRepository.findById(id).get();
    }

    public Image updateImage(PondImage pondImage) {
        return imageRepository.save(pondImage);
    }

    public void deleteImage(PondImage pondImage) {
        imageRepository.delete(pondImage);
    }
}
