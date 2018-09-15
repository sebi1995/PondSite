package com.sebastian.PondSite.controllers;


import com.sebastian.PondSite.entities.News;
import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("page_title", "Home Page");
        model.addAttribute("current_user", new User("Welcome visitor!", null, null));
        model.addAttribute("site_updates", newsService.getAllNews());
        model.addAttribute("newUpdate", new News());
        return "index";
    }

    @PostMapping("/createupdate")
    public String newUpdate(@ModelAttribute News update, Model model) {
        newsService.createNewNews(update);
        return "redirect:/";
    }


}
