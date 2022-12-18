package com.example.Nail_studio.registration;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private RegistrationClientService registrationClientService;

    /**
     * Entrance to registration page
     */
    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";      // TODO: 12/17/2022 create registration view file html
    }

    /**
     *  Create {@code Client} from {@link RequestBody}
     *
     *  <p>If existing of {@code Client} object is successfully - sends message to view with a positive result, otherwise message with problem
     */
    @PostMapping("/registrationClient")
    public String registrationClient(@RequestBody Client client,
                                     Model model){
        if (!registrationClientService.addClient(client)){
            model.addAttribute("message", "unable to create client, client with the same name already exists");
            return "registration";  // TODO: 12/17/2022 make same view registration for client and specialist or individually
        }
        model.addAttribute("message", "client was added successfully!");
        return "redirect:/login";
    }


    /**
     * {@link #activationClientToken(String, Model)}
     * <p>Accepts an external URL request, coming from a link in an email.
     *
     * <p>If the activation operation {@link #registrationClientService}{@code .activateClient()} is successful, it sends a message to the view about a positive result,
     * otherwise an activation error message
     */
    @GetMapping("/activate/{activationCode}")
    public String activationClientToken(@PathVariable("activationCode") String activationCode,
                                        Model model){
        if (!registrationClientService.activateClient(activationCode))
            model.addAttribute("message", "code is invalid, not activated");

        model.addAttribute("message", "client was activated successfully!");
        return "login";
    }
}
