package com.example.Nail_studio.shipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Shipment")
@Table(name = "shipment")
public class Shipment {

    @Id
    @SequenceGenerator(name = "shipment_id_sequence",
                        sequenceName = "shipment_id_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "shipment_id_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "shipment_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime shipmentDate;


    @Column(name = "competed",
            nullable = false)
    private Boolean completed;


    public Shipment(LocalDateTime shipmentDate, Boolean completed) {
        this.shipmentDate = shipmentDate;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", shipmentDate=" + shipmentDate +
                ", completed=" + completed +
                '}';
    }
}
