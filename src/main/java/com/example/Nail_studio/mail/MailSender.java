package com.example.Nail_studio.mail;

public interface MailSender {
    void send(String to, String subject, String text);
}

