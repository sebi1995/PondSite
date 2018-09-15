package com.sebastian.PondSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        model.addAttribute("page_title", "Contact us");
        model.addAttribute("current_user", null);
        return "contact";
    }
}
