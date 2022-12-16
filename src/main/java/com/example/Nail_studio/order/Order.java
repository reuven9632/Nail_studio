package com.example.Nail_studio.order;

import com.example.Nail_studio.client.Client;
import com.example.Nail_studio.feedback.Feedback;
import com.example.Nail_studio.options.Options;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence",
                        sequenceName = "order_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "order_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;


    @Column(name = "approved")
    private Boolean approved;


    @OneToOne
    @JoinColumn(name = "options_id",
                referencedColumnName = "id",
                nullable = false,
                foreignKey = @ForeignKey(name = "order__options_id_fk"))
    private Options options;


    @ManyToOne
    @JoinColumn(name = "client_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "order__client_id_fk"))
    private Client client;


    @JsonIgnore
    @OneToOne(mappedBy = "order",
                orphanRemoval = true,
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE},
                fetch = FetchType.EAGER)
    private Feedback feedback;



    public Order(LocalDateTime createdAt, Boolean approved) {
        this.createdAt = createdAt;
        this.approved = approved;
    }

    public Order(LocalDateTime createdAt, Boolean approved, Options options) {
        this.createdAt = createdAt;
        this.approved = approved;
        this.options = options;
        options.setOrder(this);
    }

    public Order(LocalDateTime createdAt, Boolean approved, Options options, Client client) {
        this.createdAt = createdAt;
        this.approved = approved;
        this.options = options;
        options.setOrder(this);
        this.client = client;
    }

    public Order(LocalDateTime createdAt, Boolean approved, Options options, Client client, Feedback feedback) {
        this.createdAt = createdAt;
        this.approved = approved;
        this.options = options;
        this.client = client;
        this.feedback = feedback;
    }
    
    
    
    public void addFeedback (Feedback feedback){
        this.feedback = feedback;
        feedback.setOrder(this);
    }
    
    public void removeFeedback(Feedback feedback){
        this.feedback = null;
        // TODO: 10/24/2022 check maybe do not need remove from feedback are Order 
        feedback.setOrder(null);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", approved=" + approved +
                ", options=" + options +
                '}';
    }
}
