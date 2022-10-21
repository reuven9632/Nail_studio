package com.example.Nail_studio.client;

import com.example.Nail_studio.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Client")
@Table(name = "client",
        uniqueConstraints = {@UniqueConstraint(name = "client__email_unique", columnNames = "email"),
                            @UniqueConstraint(name = "client__phone_unique", columnNames = "phone")})
public class Client {

    @Id
    @SequenceGenerator(name = "client_sequence",
                        sequenceName = "client_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "client_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String firstName;


    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String lastName;


    @Column(name = "email",
            nullable = false)
    private String email;


    @Column(name = "phone",
            nullable = false)
    private String phone;


    @Column(name = "role",
            nullable = false)
    private Role role;


    public Client(String firstName, String lastName, String email, String phone, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }
}
