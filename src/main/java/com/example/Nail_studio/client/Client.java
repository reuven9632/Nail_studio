package com.example.Nail_studio.client;

import com.example.Nail_studio.order.Order;
import com.example.Nail_studio.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "password",
            nullable = false,
            columnDefinition = "TEXT")
    private String password;

    @Column(name = "email",
            nullable = false)
    private String email;


    @Column(name = "phone",
            nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",
            nullable = true)
    private Role role;

    @Column(name = "active",
            nullable = true)
    private Boolean active;

    @Column(name = "activation_code",
            nullable = true,
            columnDefinition = "TEXT")
    private String activationCode;

    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL/*{CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}*/,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Order> order = new ArrayList<>();


    public Client(String firstName, String lastName, String email, String phone, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public Client(String firstName, String lastName, String password, String email, String phone, Role role, String activationCode, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.activationCode = activationCode;
        this.active = active;
    }

    //todo check method addOrder    and    removeOrder
    public void addOrder(Order order) {
        this.order.add(order);
        order.setClient(this);
    }

    public void removeOrder(Order order){
        if (this.order.contains(order)){
            this.order.remove(order);
            order.setClient(null);
        }
    }

    public Boolean isActive(Boolean active){
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
                ", order=" + order +
                '}';
    }
}
