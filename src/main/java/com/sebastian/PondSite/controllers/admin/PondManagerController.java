package com.sebastian.PondSite.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PondManagerController {

    @GetMapping("/deletePond/{id}")
    private String deletePond(@PathVariable int id, Model model) {
        System.out.println(id);
//        model.addAttribute("current_user", new User("Sebastian M Zdroana", "", new ArrayList<>()));
        return "cpanel/showponds";
    }
}
