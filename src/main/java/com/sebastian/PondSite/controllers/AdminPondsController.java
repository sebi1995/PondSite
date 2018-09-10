package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPondsController {

    private final String defaultControllerPath = "/admin-pages/ponds-management";

    @Autowired
    private PondService pondService;

    @RequestMapping(value = defaultControllerPath, method = RequestMethod.GET)
    public String adminManager(Model model){
        model.addAttribute("pondList", pondService.readAllPonds());
//        model
        return "cpanel/admin-pages/ponds-management";
    }

//    @RequestMapping(value = defaultControllerPath+"", method = RequestMethod.GET)
//    public String getImages(){
//        return
//    }
}
