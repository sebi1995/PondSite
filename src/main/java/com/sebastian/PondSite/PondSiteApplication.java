package com.sebastian.PondSite;

import com.sebastian.PondSite.entities.News;
import com.sebastian.PondSite.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class PondSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PondSiteApplication.class, args);
    }
}
