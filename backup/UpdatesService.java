package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.Update;
import com.sebastian.PondSite.repositories.UpdatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatesService {

    @Autowired
    private UpdatesRepository updatesRepository;

    public List<Update> getAllUpdates(){
        return (List<Update>) updatesRepository.findAll();
    }

    public void createNewUpdate(Update update){
        updatesRepository.save(update);
    }

    public void deleteUpdate(Update update){
        updatesRepository.delete(update);
    }
}
