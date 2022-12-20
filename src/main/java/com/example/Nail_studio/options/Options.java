package com.example.Nail_studio.options;

import com.example.Nail_studio.order.Order;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Options")
@Table(name = "options")
public class Options {

    @Id
    @SequenceGenerator(name = "options_id_sequence",
                        sequenceName = "options_id_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "options_id_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "text",
            nullable = false,
            columnDefinition = "TEXT")
    private String text;


    // TODO: 12/20/2022      Chek why default injection das is not works
    @Column(name = "builded_nails",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean buildedNails;


    // TODO: 12/20/2022      Chek why default injection das not works
    @Column(name = "one_color",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean oneColor;


    // TODO: 12/20/2022      Chek why default injection das is not works
    @Column(name = "amount_of_one_color",
            columnDefinition = "integer default 10")
    private Integer amountOfOneColor;


    @Column(name = "gradient",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean gradient;


    @Column(name = "amount_of_gradient",
            columnDefinition = "INTEGER DEFAULT 0")
    private Integer amountOfGradient;


    @Column(name = "art_nails",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean artNails;


    @Column(name = "amount_of_art_nails",
            columnDefinition = "INTEGER DEFAULT 0")
    private Integer amountOfArtNails;


    @OneToOne(mappedBy = "options",
                orphanRemoval = true,
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH},
                fetch = FetchType.LAZY)         // TODO: 12/16/2022  check if need change to EAGER
    private Order order;



    public Options(String text) {
        this.text = text;
    }

    public Options(String text, Order order) {
        this.text = text;
        this.order = order;
        order.setOptions(this);
    }

    public Options(String text,
                   Boolean buildedNails,
                   Boolean oneColor,
                   Integer amountOfOneColor,
                   Boolean gradient,
                   Integer amountOfGradient,
                   Boolean artNails,
                   Integer amountOfArtNails,
                   Order order) {
        this.text = text;
        this.buildedNails = buildedNails;
        this.oneColor = oneColor;
        this.amountOfOneColor = amountOfOneColor;
        this.gradient = gradient;
        this.amountOfGradient = amountOfGradient;
        this.artNails = artNails;
        this.amountOfArtNails = amountOfArtNails;
        this.order = order;
        order.setOptions(this);
    }


    public void setOrder(Order order){
        this.order = order;
        order.setOptions(this);
    }


    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", buildedNails=" + buildedNails +
                ", oneColor=" + oneColor +
                ", amountOfOneColor=" + amountOfOneColor +
                ", gradient=" + gradient +
                ", amountOfGradient=" + amountOfGradient +
                ", artNails=" + artNails +
                ", amountOfArtNails=" + amountOfArtNails +
                '}';
    }
}
