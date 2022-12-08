package com.example.Nail_studio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//This controller just for test
//@RequestMapping(path = "api/v1/main")//do not work css -> somebody blocs url to load css
//@RestController//return string whats was write the same word -> not .html    on folder ../templates/..  !!
//@AllArgsConstructor
@Controller
public class MainController {


    //test of mainin.html on templates/..   do check header of frontend
    @GetMapping
    public String mainOfController(Model model){
        return "mainin";
    }


    //test of index.html on templates/app/..
    @GetMapping("/a")
    public String aaa(Model model){
        return "app/index";
    }


    //test of index.html on templates/..
    @GetMapping("/b")
    public String bbb(Model model){
        return "index";
    }


    //test of registration.html
    @GetMapping("/r")
    public String registrationTestHtml(Model model){
        return "registration";
    }

}

// TODO: 11/19/2022 remove this controller before deploy

