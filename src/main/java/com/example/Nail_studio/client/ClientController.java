package com.example.Nail_studio.client;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(path = "api/v1/client")
@RestController
public class ClientController {

    private final ClientRepository clientRepository;


    @GetMapping(path = "/registration")
    public String registration(Model model){
        model.addAttribute("client", new Client());//to delete!!!
        return "registration";
    }


    @PostMapping(path = "/registration")
    public String addClient(@RequestBody Client client){
        //todo  create clientRegistration
        return "login";
    }

}
