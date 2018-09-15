package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PondService {

    @Autowired
    private PondRepository pondRepository;

    public List<Pond> getAllPond() {
        return pondRepository.findAll();
    }

    public void createNewPond(Pond pond) {
        pondRepository.save(pond);
    }

    public void deletePond(Pond pond) {
        pondRepository.delete(pond);
    }

    public void deleteAllPond() {
        pondRepository.deleteAll();
    }

    public void updatePond(Pond pond) {
        pondRepository.save(pond);
    }

    public Pond getPondById(Integer id) {
        return pondRepository.findById(id).get();
    }
}
