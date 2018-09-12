package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.Update;
import com.sebastian.PondSite.repositories.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteUpdateService {

    @Autowired
    private UpdateRepository updateRepository;

    public List<Update> getAllUpdates() {
        return (List<Update>) updateRepository.findAll();
    }

    public void createNewUpdate(Update update) {
        update.setIsHidden(0);
        updateRepository.save(update);
    }

    public void deleteUpdate(Update update) {
        updateRepository.delete(update);
    }

    public void deleteAllUpdates() {
        updateRepository.deleteAll();
    }

    public void updateUpdate(Update update) {
        updateRepository.save(update);
    }

    public Update getUpdateById(Integer id) {
        return updateRepository.findById(id).get();
    }

    public List<Update> getAllUpdatesFiltered() {
        List<Update> updates = (List<Update>) updateRepository.findAll();
        List<Update> returnable = new ArrayList<>();
        if (updates != null && updates.size() > 0) {
            for (Update update : updates) {
                if (update.getIsHidden() == 0) {
                    returnable.add(update);
                }
            }
        }
        return returnable;
    }
}
