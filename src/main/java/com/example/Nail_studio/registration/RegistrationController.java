package com.example.Nail_studio.registration;

import com.example.Nail_studio.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private RegistrationClientService registrationClientService;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";      // TODO: 12/17/2022 create registration view file html
    }
    
    @PostMapping("/registrationClient")
    public String registrationClient(Client client, Model model){
        registrationClientService.addClient(client);
        return "registration/registrationClient";   // TODO: 12/17/2022 make same view registration for client and specialist or individually
    }
}
