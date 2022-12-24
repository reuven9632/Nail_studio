package com.example.Nail_studio.mail.mail_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService_v2 /*implements MailSender*/{

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String sendTo, String subject, String message){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(username);
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);
    }
}

