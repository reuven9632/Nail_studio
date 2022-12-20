package com.example.Nail_studio.registration;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.specialist.Specialist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private ClientRegistrationService clientRegistrationService;

    private SpecialistRegistrationService specialistRegistrationService;



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
    @PostMapping("/registration/client")
    public String registrationClient(@RequestBody Client client,
                                     Model model){
        if (!clientRegistrationService.addClient(client)){
            model.addAttribute("message", "unable to create client, client with the same name already exists");
            return "registration";
        }
        model.addAttribute("message", "client was added successfully!");
        return "redirect:/login";
    }

    // TODO: 12/20/2022  upgrade this code , has many same code
    @PostMapping("/registration/specialist")
    public String registrationSpecialist(@RequestBody Specialist specialist,
                                         Model model){
        if (!specialistRegistrationService.addSpecialist(specialist)) {
            model.addAttribute("message", "unable to create specialist, specialist with the same name already exists");
            return "registration";
        }
        model.addAttribute("message", "specialist was added successfully!");
        return "redirect:/login";
    }

    /**
     * {@link #activationClientToken(String, Model)}
     * <p>Accepts an external URL request, coming from a link in an email.
     *
     * <p>If the activation operation {@link #clientRegistrationService}{@code .activateClient()} is successful, it sends a message to the view about a positive result,
     * otherwise an activation error message
     */
    @GetMapping("/activate/{activationCode}")
    public String activationClientToken(@PathVariable("activationCode") String activationCode,
                                        Model model){
        if (!clientRegistrationService.activation(activationCode))
            model.addAttribute("message", "code is invalid, not activated");
        else
            model.addAttribute("message", "client was activated successfully!");
        return "login";
    }

    // TODO: 12/20/2022  upgrade this code , has many same code
    /**
     * {@link #activationClientToken(String, Model)}
     * <p>Accepts an external URL request, coming from a link in an email.
     *
     * <p>If the activation operation {@link #clientRegistrationService}{@code .activateClient()} is successful, it sends a message to the view about a positive result,
     * otherwise an activation error message
     */
    @GetMapping("/activate/{activationCode}")
    public String activationSpecialistToken(@PathVariable("activationCode") String activationCode, Model model){
        if (!specialistRegistrationService.activation(activationCode))
            model.addAttribute("message", "code is invalid, not activated");
        else
        model.addAttribute("message", "specialist was activated successfully!");
        return "login";
    }
}
