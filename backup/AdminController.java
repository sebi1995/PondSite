package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private PondService pondService;

    @RequestMapping(name = "/admin")
    public String adminIndex(){
        return "cpanel/adminIndex";
    }

}
