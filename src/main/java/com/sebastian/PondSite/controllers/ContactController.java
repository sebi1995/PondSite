package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String getContactPage(Model model){
        model.addAttribute("page_title", "Contact us");
        model.addAttribute("current_user", new User("Sebastian M Zdroana", "psss", new ArrayList<>()));
        return "contact";
    }
}
