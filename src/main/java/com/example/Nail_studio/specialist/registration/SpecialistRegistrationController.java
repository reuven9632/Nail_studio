package com.example.Nail_studio.specialist.registration;

import com.example.Nail_studio.specialist.Specialist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class SpecialistRegistrationController {

    private SpecialistRegistrationService specialistRegistrationService;



    // TODO: 12/20/2022  upgrade this code , has many same code
    /**
     *  Create {@code Specialist} from {@link RequestBody}
     *
     *  <p>If existing of {@code Specialist} object is successfully - sends message to view with a positive result, otherwise message with problem
     */
    @PostMapping("/registration/specialist")
    public String registrationSpecialist(@RequestBody SpecialistRegistrationRequest request,
                                         Model model){
        if (!specialistRegistrationService.addSpecialist(request)) {
            model.addAttribute("message", "unable to create specialist, specialist with the same name already exists");
            return "registration";
        }
        model.addAttribute("message", "specialist was added successfully!");
        return "redirect:/login";
    }


    // TODO: 12/20/2022  upgrade this code , has many same code with ClientRegistrationController
    /**
     * {@link #activationSpecialistToken(String, Model)}
     * <p>Accepts an external URL request, coming from a link in an email.
     *
     * <p>If the activation operation {@link #specialistRegistrationService}{@code .activateClient()} is successful, it sends a message to the view about a positive result,
     * otherwise an activation error message
     */
    @GetMapping("/activate/specialist/{activationCode}")
    public String activationSpecialistToken(@PathVariable("activationCode") String activationCode, Model model){
        if (!specialistRegistrationService.activation(activationCode))
            model.addAttribute("message", "code is invalid, not activated");
        else
            model.addAttribute("message", "specialist was activated successfully!");
        return "login";
    }
}
