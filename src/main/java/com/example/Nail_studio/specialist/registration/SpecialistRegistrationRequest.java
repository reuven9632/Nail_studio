package com.example.Nail_studio.specialist.registration;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SpecialistRegistrationRequest {

    @Column(name = "name_specialist",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;


    @Column(name = "password",
            nullable = false,
            columnDefinition = "TEXT")
    private String password;


    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;


    @Column(name = "experience",
            nullable = true)
    private Integer experience;
}
