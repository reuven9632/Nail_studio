package com.example.Nail_studio.branchoffice;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.client.ClientRepository;
import com.example.Nail_studio.feedback.Feedback;
import com.example.Nail_studio.feedback.FeedbackRepository;
import com.example.Nail_studio.options.Options;
import com.example.Nail_studio.options.OptionsRepository;
import com.example.Nail_studio.order.Orders;
import com.example.Nail_studio.order.OrderRepository;
import com.example.Nail_studio.role.Role;
import com.example.Nail_studio.specialist.Specialist;
import com.example.Nail_studio.specialist.SpecialistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class BranchOfficeConfiguration {

    /** Makes for test */
    @Bean(name = "BranchOfficeConfiguration__commandLineRunner-bean")
    public CommandLineRunner commandLineRunner(BranchOfficeRepository branchOfficeRepository,
                                               SpecialistRepository specialistRepository,
                                               OptionsRepository optionsRepository,
                                               ClientRepository clientRepository,
                                               OrderRepository orderRepository,
                                               FeedbackRepository feedbackRepository){
        return args -> {
            BranchOffice alonaNails = new BranchOffice("AlonaNails", "Vigodsky 8/7");
            Specialist alona = new Specialist("Alona", "AlonaS@gmail.com", 5, Role.ADMINISTRATOR);
            alonaNails.addSpecialist(alona);

            branchOfficeRepository.save(alonaNails);
            System.out.println("print alonaNails - " + alonaNails);



            Specialist igor = new Specialist("Igor", "IgorS@gmail.com", 2, Role.SPECIALIST);
            specialistRepository.save(igor);
            System.out.println("print igor - " + igor);
            System.out.println("print alonaNails - " + alonaNails);

            alonaNails.removeSpecialist(igor);


            Specialist dani = new Specialist("Dani", "DaniG@gmail.com", 8, Role.SPECIALIST);
            specialistRepository.save(dani);
            System.out.println("print dani - " + dani);

            alonaNails.addSpecialist(dani);
            branchOfficeRepository.save(alonaNails);








            Client emilSamaev = new Client("Emil", "Samaev", "EmilSamaev@gmail.com", "054-1234567", Role.CLIENT);
            clientRepository.save(emilSamaev);
            System.out.println(emilSamaev);

            Options option = new Options("some text of options");
            optionsRepository.save(option);

            Orders orders = new Orders(LocalDateTime.now(), false, option);
            orderRepository.save(orders);
            Orders orders2 = new Orders(LocalDateTime.now(), false, option);
            orderRepository.save(orders2);
//            optionsRepository.save(option);


            System.out.println(orders);
            System.out.println(option);


            Feedback someTextOfFeedback = new Feedback("some text of feedback", false, 4, false);
            feedbackRepository.save(someTextOfFeedback);
            System.out.println(someTextOfFeedback);





            Options option1 = new Options("some text of options", new Orders(LocalDateTime.now(), false));
            optionsRepository.save(option1);



            alonaNails.addOption(option1);
            branchOfficeRepository.save(alonaNails);
            optionsRepository.save(option1);


            System.out.println(option);


        };
    }

}
