package com.example.Nail_studio.point;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Point")
@Table(name = "point")
public class Point {

    @Id
    @SequenceGenerator(name = "point_id_sequence",
                        sequenceName = "point_id_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "point_id_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "amount",
            nullable = false)
    private Integer amount;


    // TODO: 10/25/2022     create @OneToOne relationShip with Client.class



    public Point(Integer amount) {
        this.amount = amount;
    }



    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
