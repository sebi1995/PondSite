package com.sebastian.PondSite.controllers.admin;

import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class CPanelController {

    @Autowired
    private PondService pondService;

    @GetMapping("/addPond")
    public String getManageUpdatesPage(Model model){
        model.addAttribute("page_title", "Manage updates");
        model.addAttribute("current_user", new User("Sebastian M Zdroana", "", new ArrayList<>()));
        return "cpanel/addpond";
    }

    @GetMapping("/getAllPonds")
    public String getAllPonds(Model model){
        model.addAttribute("page_title", "Manage updates");
        model.addAttribute("current_user", new User("Sebastian M Zdroana", "", new ArrayList<>()));
        model.addAttribute("ponds_list", pondService.getAllPonds());
        return "cpanel/showponds";
    }
}
