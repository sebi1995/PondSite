package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import java.awt.print.Pageable;

@Controller
public class MainController {

    @Autowired
    private PondService pondService;

    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("pondList", pondService.readAllPonds());
        return "index";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
