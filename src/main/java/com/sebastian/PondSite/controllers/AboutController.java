package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAboutPage(Model model){
        model.addAttribute("page_title", "About us");
        model.addAttribute("current_user", new User("Welcome visitor!", null, null));
        return "about";
    }
}
