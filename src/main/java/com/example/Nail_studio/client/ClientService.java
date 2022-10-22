package com.example.Nail_studio.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public Boolean validation(Client client){
//        TODO    make real validation
        return true;
    }
}
