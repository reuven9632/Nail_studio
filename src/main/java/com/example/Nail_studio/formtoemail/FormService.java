package com.example.Nail_studio.formtoemail;

import org.springframework.ui.Model;

public interface FormService {

    Model sendForm(Form form, String subject, Model model);
}
