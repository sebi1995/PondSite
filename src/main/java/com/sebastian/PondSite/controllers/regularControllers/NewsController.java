package com.sebastian.PondSite.controllers.regularControllers;

import com.sebastian.PondSite.entities.News;
import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String newsPage(Model model){

        List<News> newsList = newsService.getAllNews();

        if (newsList == null || newsList.isEmpty()){
            populateNews();
        }

        model.addAttribute("page_title", "All news!");
        model.addAttribute("news_list", newsList);
        model.addAttribute("current_user", null);
        return "normal_controls/view-all-news";
    }

    public void populateNews(){
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("this is test 1", "12/12/12", 0));
        news.add(new News("this is test 2", "12/12/12", 0));
        news.add(new News("this is test 3", "12/12/12", 0));
        news.add(new News("this is test 4", "12/12/12", 0));
        news.add(new News("this is test 5", "12/12/12", 0));
        news.add(new News("this is test 6", "12/12/12", 0));
        news.add(new News("this is test 7", "12/12/12", 0));
        news.add(new News("this is test 8", "12/12/12", 0));
        news.add(new News("this is test 9", "12/12/12", 0));
        news.add(new News("this is test 10", "12/12/12", 0));
        news.add(new News("this is test 11", "12/12/12", 0));

        for (News in : news             ) {
            newsService.createNewNews(in);
        }
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public String readNews(@PathVariable Integer id, Model model){
        News news = newsService.getNewsById(id);
        model.addAttribute("page_title", "News: " + news.getDate());
        model.addAttribute("news_post", news);
        model.addAttribute("current_user", new User("Welcome visitor!", null, null));
        return "normal_controls/view-full-news";
    }



}
