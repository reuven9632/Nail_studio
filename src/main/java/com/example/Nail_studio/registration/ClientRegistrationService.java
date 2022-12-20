package com.example.Nail_studio.registration;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.client.ClientRepository;
import com.example.Nail_studio.mail.MailSenderService;
import com.example.Nail_studio.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ClientRegistrationService {

    private ClientRepository clientRepository;
    private MailSenderService mailSenderService;



    /**
     * @param client
     *        response from view @RegistrationController
     *
     * @return  {@code true} -  adding client successful, {@code false} -  adding client abort
     *
     * @version  1.0
     */
    public boolean addClient(Client client) {
        if (clientRepository.findByEmail(client.getEmail()) != null)
            return false;

        client.setActive(false);
        client.setRole(Role.CLIENT);
        client.setActivationCode(UUID.randomUUID().toString());
        clientRepository.save(client);

        String message = String.format("Hello %s  \n" +
                                        "go to link: http://localhost:8081/activate/%s",
                                        client.getFirstName(),
                                        client.getActivationCode());
        mailSenderService.send(client.getEmail(), "Activation code", message);
        return true;
    }

    /**
     * @param activationCode
     *        {@code URL} reference from mail message
     * @return {@code true} -  client activation successful,  {@code false} -  client activation abort
     *
     * @version  1.0
     */
    public boolean activation(String activationCode) {
        Client client = clientRepository.findByActivationCode(activationCode);

        if (client == null)
            return false;

        client.setActivationCode(null);
        client.setActive(true);
        clientRepository.save(client);
        return true;
    }
}
