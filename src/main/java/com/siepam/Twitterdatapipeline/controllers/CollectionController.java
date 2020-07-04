package com.siepam.Twitterdatapipeline.controllers;

import com.siepam.Twitterdatapipeline.collecting.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CollectionController {

    @GetMapping("/")
    public String greeting(Model model) {

        model.addAttribute("title", "Главная страница");
        return "home";
    }

}