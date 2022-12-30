package com.example.Nail_studio.token;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.specialist.Specialist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Token")
@Table(name = "token")
public class Token {

    @Id
    @SequenceGenerator(name = "token__id_sequence",
            sequenceName = "token__id_sequence",
            allocationSize = 1)
    @GeneratedValue(generator = "token__id_sequence",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "token",
            nullable = false)
    private String token;


    @Column(name = "createdAt",
            nullable = false)
    private LocalDateTime createdAt;


    @Column(name = "expiresAt",
            nullable = false)
    private LocalDateTime expiresAt;


    @Column(name = "confirmedAt",
            nullable = false)
    private LocalDateTime confirmedAt;


    /**
     * {@code specialist} - will be used just if we created this object
     */
    @ManyToOne
    @JoinColumn(name = "specialist_id",
            nullable = true)
    private Specialist specialist;


    /**
     * {@code client} - will be used just if we created this object
     */
    @ManyToOne
    @JoinColumn(name = "client_id",
            nullable = true)
    private Client client;



    public Token(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Specialist specialist) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.specialist = specialist;
    }

    public Token(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Client client) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.client = client;
    }
}
