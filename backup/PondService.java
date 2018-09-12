package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.PondImage;
import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PondService {

    @Autowired
    private PondRepository pondRepository;

    public Pond createPond(Pond pond, List<PondImage> pondImages) {
        pond.setPond_images(pondImages);
        return pondRepository.save(pond);
    }

    public Pond readPond(int id) {
        return pondRepository.findById(id).get();
    }

    public List<Pond> readAllPonds() {
        return (List<Pond>) pondRepository.findAll();
    }

    public Pond updatePond(Pond pond) {
        return pondRepository.save(pond);
    }

    public void deletePond(Pond pond) {
        pondRepository.delete(pond);
    }


}
