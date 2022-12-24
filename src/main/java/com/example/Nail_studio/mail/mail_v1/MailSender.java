package com.example.Nail_studio.mail.mail_v1;

public interface MailSender {
    void send(String to, String subject, String text);
}

