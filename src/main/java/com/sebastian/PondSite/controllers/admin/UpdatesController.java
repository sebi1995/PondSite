package com.sebastian.PondSite.controllers.admin;

import com.sebastian.PondSite.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdatesController {

    @GetMapping("/manageupdates")
    public String getManageUpdatesPage(Model model) {
        model.addAttribute("page_title", "Manage updates");
        model.addAttribute("current_user", new User("Welcome visitor!", null, null));
        return "cpanel/manageupdates";
    }
}
