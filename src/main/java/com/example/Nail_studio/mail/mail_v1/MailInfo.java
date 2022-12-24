package com.example.Nail_studio.mail.mail_v1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mail")
@Configuration
public class MailInfo {

    private String host;
    private String username;
    private String password;
    private int port;
    private String protocol;
    private String debug;
}
