package com.example.Nail_studio.formtoemail;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class FormController {

    private final FormServiceImp formServiceImp;

    @PostMapping(path = "/form_to_email")
    public String formToEmailController(Form form, Model model){
        formServiceImp.sendForm(form, "contact from client about nails",  model);
        // TODO: 11/28/2022 create on file html acardeon with choices any specialist want to use/ if any send to default email (of branchOffice)
        return "app/index";
    }
}
