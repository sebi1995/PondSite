package com.sebastian.PondSite.services;

import com.sebastian.PondSite.entities.News;
import com.sebastian.PondSite.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public void createNewNews(News news) {
        news.setIsHidden(0);
        newsRepository.save(news);
    }

    public void deleteNews(News news) {
        newsRepository.delete(news);
    }

    public void deleteAllNews() {
        newsRepository.deleteAll();
    }

    public void newsNews(News news) {
        newsRepository.save(news);
    }

    public News getNewsById(Integer id) {
        return newsRepository.findById(id).get();
    }

    public List<News> getAllNewsFiltered() {
        List<News> newsList = newsRepository.findAll();
        List<News> returnable = new ArrayList<>();
        if (newsList != null && newsList.size() > 0) {
            for (News news : newsList) {
                if (news.getIsHidden() == 0) {
                    returnable.add(news);
                }
            }
        }
        return returnable;
    }
}
