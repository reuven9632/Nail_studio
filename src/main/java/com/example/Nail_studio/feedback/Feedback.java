package com.example.Nail_studio.feedback;

import com.example.Nail_studio.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Feedback")
@Table(name = "feedback")
public class Feedback {

    @Id
    @SequenceGenerator(name = "feedback_sequence",
                        sequenceName = "feedback_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "feedback_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "text",
            nullable = false,
            columnDefinition = "TEXT")
    private String text;


    @Column(name = "liked",
            nullable = false)
    private Boolean liked;


    @Column(name = "star",
            nullable = false)
    private Integer star;


    @Column(name = "hide",
            nullable = false)
    private Boolean hide;


    @OneToOne
    @JoinColumn(name = "order_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "feedback__order_id_fk"))
    private Order order;



    public Feedback(String text, Boolean liked, Integer star, Boolean hide) {
        this.text = text;
        this.liked = liked;
        this.star = star;
        this.hide = hide;
    }

    public Feedback(String text, Boolean liked, Integer star, Boolean hide, Order order) {
        this.text = text;
        this.liked = liked;
        this.star = star;
        this.hide = hide;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", liked=" + liked +
                ", star=" + star +
                ", hide=" + hide +
                '}';
    }
}
