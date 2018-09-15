package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PondsController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/ponds")
    public String getPondsPage(Model model){

        

        model.addAttribute("page_title", "Ponds");
        model.addAttribute("image_list", imageService.getAllImages());
        model.addAttribute("current_user", new User());
        return "ponds";
    }
}
