package com.sebastian.PondSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("page_title", "About us");
        model.addAttribute("current_user", null);
        return "about";
    }
}
