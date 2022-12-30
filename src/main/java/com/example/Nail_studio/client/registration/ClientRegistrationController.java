package com.example.Nail_studio.client.registration;


import com.example.Nail_studio.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class ClientRegistrationController {

    private ClientRegistrationService clientRegistrationService;



    /**
     *  Create {@code Client} from {@link RequestBody}
     *
     *  <p>If existing of {@code Client} object is successfully - sends message to view with a positive result, otherwise message with problem
     */
    @PostMapping("/registration/client")
    public String registrationClient(@RequestBody Client client,
                                     Model model){
        boolean addClient = clientRegistrationService.addClient(client);
        if (!addClient){
            model.addAttribute("message", "unable to create client, client with the same name already exists");
            return "registration";
        }
        model.addAttribute("message", "client was added successfully!");
        return "redirect:/login";
    }


    /**
     * {@link #activationClientToken(String, Model)}
     * <p>Accepts an external URL request, coming from a link in an email.
     *
     * <p>If the activation operation {@link #clientRegistrationService}{@code .activateClient()} is successful, it sends a message to the view about a positive result,
     * otherwise an activation error message
     */
    @GetMapping("/activate/client/{activationCode}")
    public String activationClientToken(@PathVariable("activationCode") String activationCode,
                                        Model model){
        if (!clientRegistrationService.activation(activationCode))
            model.addAttribute("message", "code is invalid, not activated");
        else
            model.addAttribute("message", "client was activated successfully!");
        return "login";
    }
}
