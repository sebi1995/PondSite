package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.PondImage;
import com.sebastian.PondSite.services.PondImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PondsController {

    @Autowired
    private PondImageService pondImageService;

    @GetMapping("/ponds")
    public String getPondsPage(Model model){
        model.addAttribute("page_title", "Ponds");
        model.addAttribute("image_list", pondImageService.getAllPondImages());
        return "ponds";
    }
}
