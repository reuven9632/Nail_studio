package com.example.Nail_studio.branchoffice.registration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString   // TODO: 12/17/2022  check if this works for this Object
@Table(name = "registration")
@Entity(name = "Registration")
public class Registration {

    @SequenceGenerator(name = "registration_sequence",
                        sequenceName = "registration_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "registration_sequence")
    @Column(name = "id",
            nullable = false)
    @Id
    private Long id;

    @Column(name = "firstName",
            nullable = false)
    private String firstName;

    @Column(name = "lastName",
            nullable = false)
    private String lastName;


    public Registration(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
