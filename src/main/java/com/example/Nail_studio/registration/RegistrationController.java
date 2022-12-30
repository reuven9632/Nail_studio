package com.example.Nail_studio.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    /**
     * Entrance to registration page
     */
    @GetMapping("/registration")
    public String registration(Model model){
        // TODO: 12/17/2022 create registration view file html
        return "registration";
    }
}
