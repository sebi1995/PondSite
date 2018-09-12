package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.SiteUpdate;
import com.sebastian.PondSite.repositories.SiteUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteUpdateService {

    @Autowired
    private SiteUpdateRepository siteUpdateRepository;

    public List<SiteUpdate> getAllUpdates() {
        return (List<SiteUpdate>) siteUpdateRepository.findAll();
    }

    public void createNewUpdate(SiteUpdate update) {
        update.setIsHidden(0);
        siteUpdateRepository.save(update);
    }

    public void deleteUpdate(SiteUpdate update) {
        siteUpdateRepository.delete(update);
    }

    public void deleteAllUpdates() {
        siteUpdateRepository.deleteAll();
    }

    public void updateUpdate(SiteUpdate update) {
        siteUpdateRepository.save(update);
    }

    public SiteUpdate getUpdateById(Integer id) {
        return siteUpdateRepository.findById(id).get();
    }

    public List<SiteUpdate> getAllUpdatesFiltered() {
        List<SiteUpdate> updates = (List<SiteUpdate>) siteUpdateRepository.findAll();
        List<SiteUpdate> returnable = new ArrayList<>();
        if (updates != null && updates.size() > 0) {
            for (SiteUpdate update : updates) {
                if (update.getIsHidden() == 0) {
                    returnable.add(update);
                }
            }
        }
        return returnable;
    }
}
