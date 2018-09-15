package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.Image;
import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PondsController {

    @Autowired
    private PondService pondService;

    private ArrayList<Pond> pondArrayList;

    @GetMapping("/ponds")
    public String getPondsPage(Model model) {

        pondArrayList = (ArrayList<Pond>) pondService.getAllPond();

        if (pondArrayList == null || pondArrayList.isEmpty()) {
            populateNews();
        }

        model.addAttribute("page_title", "Ponds");
        model.addAttribute("current_user", null);
        return "ponds";
    }

    public void populateNews() {
        ArrayList<Pond> ponds = new ArrayList<>();

        ponds.add(new Pond("name1", "add date1", "last updated1", new ArrayList<User>(), new ArrayList<Image>()));
        ponds.add(new Pond("name2", "add date2", "last updated2", new ArrayList<User>(), new ArrayList<Image>()));
        ponds.add(new Pond("name3", "add date3", "last updated3", new ArrayList<User>(), new ArrayList<Image>()));
        ponds.add(new Pond("name4", "add date4", "last updated4", new ArrayList<User>(), new ArrayList<Image>()));
        ponds.add(new Pond("name5", "add date5", "last updated5", new ArrayList<User>(), new ArrayList<Image>()));
        ponds.add(new Pond("name6", "add date6", "last updated6", new ArrayList<User>(), new ArrayList<Image>()));

        for (Pond in : ponds) {
            pondArrayList.add(in);
            pondService.createNewPond(in);
        }
    }
}
