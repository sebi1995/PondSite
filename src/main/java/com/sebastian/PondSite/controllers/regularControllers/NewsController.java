package com.sebastian.PondSite.controllers.regularControllers;

import com.sebastian.PondSite.entities.News;
import com.sebastian.PondSite.entities.User;
import com.sebastian.PondSite.services.NewsService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    private ArrayList<News> newsArrayList;

    @GetMapping("/news")
    public String newsPage(Model model) {

        newsArrayList = (ArrayList<News>) newsService.getAllNewsFiltered();

        if (newsArrayList == null || newsArrayList.isEmpty()) {
            populateNews();
        }

        model.addAttribute("page_title", "All news!");
        model.addAttribute("news_list", newsArrayList);
        model.addAttribute("current_user", null);
        return "normal_controls/view-all-news";
    }

    public void populateNews() {
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

        for (News in : news) {
            newsArrayList.add(in);
            newsService.createNewNews(in);
        }
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public String readNews(@PathVariable Integer id, Model model) {
        News news;
        Boolean lastNews = false;
        Boolean firstNews = false;

        if (id <= 1) {
            firstNews = true;
            news = newsArrayList.get(0);

        } else if (id >= newsArrayList.size()) {
            lastNews = true;
            news = newsArrayList.get(newsArrayList.size() - 1);

        } else {
            news = newsArrayList.get(id - 1);
        }

        news = (news == null) ? newsService.getNewsById(id) : news;

        model.addAttribute("news_post", news);
        model.addAttribute("page_title", "News: " + news.getDate());
        model.addAttribute("current_user", null);
        model.addAttribute("is_first_news", firstNews);
        model.addAttribute("is_last_news", lastNews);
        return "normal_controls/view-full-news";
    }


}
