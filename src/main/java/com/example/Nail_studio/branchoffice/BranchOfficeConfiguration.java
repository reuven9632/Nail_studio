package com.example.Nail_studio.branchoffice;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.client.ClientRepository;
import com.example.Nail_studio.client.ClientValidator;
import com.example.Nail_studio.feedback.Feedback;
import com.example.Nail_studio.feedback.FeedbackRepository;
import com.example.Nail_studio.options.Options;
import com.example.Nail_studio.options.OptionsRepository;
import com.example.Nail_studio.order.Order;
import com.example.Nail_studio.order.OrderRepository;
import com.example.Nail_studio.role.Role;
import com.example.Nail_studio.shipment.Shipment;
import com.example.Nail_studio.shipment.ShipmentRepository;
import com.example.Nail_studio.specialist.Specialist;
import com.example.Nail_studio.specialist.SpecialistRepository;
import com.example.Nail_studio.validator.ValidatorResult;
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
                                               FeedbackRepository feedbackRepository,
                                               ShipmentRepository shipmentRepository){
        return args -> {
            /**Check BranchOffice*/
            BranchOffice alonaNails = new BranchOffice("AlonaNails", "Vigodsky 8/7");
            Specialist alona = new Specialist("Alona", "AlonaS@gmail.com", 5, Role.ADMINISTRATOR);
            alonaNails.addSpecialist(alona);

            branchOfficeRepository.save(alonaNails);
            System.out.println("print alonaNails - " + alonaNails);




            /**Check Specialist*/
            Specialist igor = new Specialist("Igor", "IgorS@gmail.com", 2, Role.SPECIALIST);
            specialistRepository.save(igor);
            System.out.println("print igor - " + igor);
            System.out.println("print alonaNails - " + alonaNails);
            // TODO: 10/24/2022 check maybe do not need do   ->   alonaNails.removeSpecialist(igor);
            alonaNails.removeSpecialist(igor);


            Specialist dani = new Specialist("Dani", "DaniG@gmail.com", 8, Role.SPECIALIST);
            specialistRepository.save(dani);
            System.out.println("print dani - " + dani);

            alonaNails.addSpecialist(dani);
            branchOfficeRepository.save(alonaNails);




            /** Check Options/Order  */
            Options option = new Options("some text of options");
            optionsRepository.save(option);
            Options option2 = new Options("some text of options 2 ", alonaNails);
            optionsRepository.save(option2);
            Options option3 = new Options("some text of options 3 ", alonaNails);
            optionsRepository.save(option3);

            Order order = new Order(LocalDateTime.now(), false, option);
            orderRepository.save(order);
            Order order2 = new Order(LocalDateTime.now(), false, option2);
            orderRepository.save(order2);




            /** Check Client/Order */
            Client emilSamaev = new Client("Emil", "Samaev", "EmilSamaev@gmail.com", "054-1234568", Role.CLIENT);
            clientRepository.save(emilSamaev);
            System.out.println(emilSamaev);

            emilSamaev.addOrder(order2);
            clientRepository.save(emilSamaev);
            System.out.println(emilSamaev);

            Order order1 = new Order(LocalDateTime.now(), false, option3);
            orderRepository.save(order1);
            Client sara = new Client("Sara",
                                    "Kohan",
                                    "SaraKohan@gmail.com",
                                    "054-1234567",
                                    Role.CLIENT);
            clientRepository.save(sara);
            sara.addOrder(order1);
            orderRepository.save(order1);

            System.out.println(sara);
            System.out.println(order);
            System.out.println(option);




            /** Check Feedback/Order */
            Feedback someTextOfFeedback = new Feedback("some text of feedback", false, 4, false);
            feedbackRepository.save(someTextOfFeedback);
            System.out.println(someTextOfFeedback);

            order.addFeedback(someTextOfFeedback);
            orderRepository.save(order);
            System.out.println(order);




            /** Check Options/BranchOffice */
            Options option1 = new Options("some text of options", new Order(LocalDateTime.now(), false));
            optionsRepository.save(option1);


            alonaNails.addOption(option1);
            branchOfficeRepository.save(alonaNails);
            optionsRepository.save(option1);

            System.out.println(option);




            /** Check ValidatorResult */
            ValidatorResult result = ClientValidator.allValidations().apply(emilSamaev);
            System.out.println("result of validating " + emilSamaev.getFirstName() + " : " + result);




            /**Check shipment*/
            Shipment shipment = new Shipment(LocalDateTime.now(), false);
            shipmentRepository.save(shipment);
            System.out.println(shipment);
        };
    }

}
