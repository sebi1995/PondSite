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

    public Pond getPondById(Integer id){
        return pondRepository.findById(id).get();
    }

    public List<Pond> getAllPonds(){
        return (List<Pond>) pondRepository.findAll();
    }

    public Pond newPond(Pond pond){
        return pondRepository.save(pond);
    }

    public void deletePond(Pond pond){
        pondRepository.delete(pond);
    }

    public Pond updatePond(Pond pond){
        return pondRepository.save(pond);
    }
}
