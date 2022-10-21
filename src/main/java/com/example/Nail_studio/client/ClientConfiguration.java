package com.example.Nail_studio.client;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {


    /** Makes for test */
    /*@Bean(name = "ClientConfiguration__commandLineRunner-bean")
    public CommandLineRunner commandLineRunner(ClientRepository clientRepository,
                                               OrderRepository orderRepository,
                                               OptionsRepository optionsRepository){
        return args -> {
            *//*Client emilSamaev = new Client("Emil", "Samaev", "EmilSamaev@gmail.com", "054-1234567", Role.CLIENT);
            clientRepository.save(emilSamaev);
            System.out.println(emilSamaev);

            Orders order = new Orders(LocalDateTime.now(), false);
            orderRepository.save(order);

            Options option = new Options("some text of options");
            optionsRepository.save(option);

            System.out.println(order);
            System.out.println(option);*//*
        };
    }*/
}
