package com.sebastian.PondSite.controllers;

import com.sebastian.PondSite.entities.Image;
import com.sebastian.PondSite.entities.Pond;
import com.sebastian.PondSite.services.ImageService;
import com.sebastian.PondSite.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PondsController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images";

    @Autowired
    private PondService pondService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/ponds")
    public String greetingForm(Model model) {
        model.addAttribute("pondsList", pondService.readAllPonds());
        model.addAttribute("newPond", new Pond());
        return "ponds";
    }

    @PostMapping("/ponds")
    public String createNewPond(@RequestParam("files") MultipartFile[] files, @ModelAttribute Pond pond, Model model) {
        List<Image> images = new ArrayList<>();
        List<Pond> ponds = new ArrayList<>();
        ponds.add(pond);

        String thisPath = uploadDirectory + "/" + pond.getPond_name();

        File file = new File(thisPath);

        if (!file.exists()) {
            file.mkdir();
        }

        if (files.length > 0) {

            for (MultipartFile fileFromFiles : files) {
                Path filenameandpath = Paths.get(thisPath, fileFromFiles.getOriginalFilename());

                Image image = new Image(thisPath + "/" + filenameandpath.getFileName().toString(), ponds);
                image.setImage_content(filenameandpath.getFileName().toString());
                System.out.println(filenameandpath.getFileName().toString());
                System.out.println();
                //"/" + image.getImage_content().substring(((System.getProperty("user.dir") + "/src/main/resources/").length())))
                imageService.createImage(image, ponds);
                images.add(image);
                try {
                    Files.write(filenameandpath, fileFromFiles.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        pond.setPond_images(images);
        pondService.createPond(pond, images);
        model.addAttribute("newPond", new Pond());
        return "ponds";
    }
}
