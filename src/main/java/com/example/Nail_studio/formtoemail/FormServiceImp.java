package com.example.Nail_studio.formtoemail;

import com.example.Nail_studio.mail.MailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@AllArgsConstructor
@Service
public class FormServiceImp implements FormService{

    private final MailSender mailSender;

    @Override
    public Model sendForm(Form form, String subject, Model model) {
        if (form != null)
            mailSender.send(form.getEmail(), subject, formBuilderEmail(form));
            // TODO: 11/28/2022 change   form.getEmail()   ->   on form.getSpecialistEmail
        model.addAttribute("addingSuccess", "added success");
        return model;
    }



    private String formBuilderEmail(Form form) {
        // TODO: 11/28/2022 create html form for email
        return "";
    }
}
