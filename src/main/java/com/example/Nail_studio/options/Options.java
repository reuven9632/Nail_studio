package com.example.Nail_studio.options;

import com.example.Nail_studio.branchoffice.BranchOffice;
import com.example.Nail_studio.order.Orders;
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

    /**Chek why default injection das is not works*/
    @Column(name = "builded_nails",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean buildedNails;


    /**Chek why default injection das is not works*/
    @Column(name = "one_color",
            columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean oneColor;


    /**Chek why default injection das is not works*/
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


    @ManyToOne
    @JoinColumn(name = "branch_office_id",
                referencedColumnName = "id",
                // TODO CREATE nullable = false,      before go to prodaction
                foreignKey = @ForeignKey(name = "options__branchOffice_id_fk"))
    private BranchOffice branchOffice;


    @OneToOne(mappedBy = "options",
                orphanRemoval = true,
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH},
                fetch = FetchType.LAZY)
    private Orders orders;


    public Options(String text) {
        this.text = text;
    }

    public Options(String text, Orders orders) {
        this.text = text;
        this.orders = orders;
        orders.setOptions(this);
    }

    public Options(String text, BranchOffice branchOffice, Orders orders) {
        this.text = text;
        this.branchOffice = branchOffice;
        this.orders = orders;
        orders.setOptions(this);
    }

    public Options(String text,
                   Boolean buildedNails,
                   Boolean oneColor,
                   Integer amountOfOneColor,
                   Boolean gradient,
                   Integer amountOfGradient,
                   Boolean artNails,
                   Integer amountOfArtNails,
                   BranchOffice branchOffice,
                   Orders orders) {
        this.text = text;
        this.buildedNails = buildedNails;
        this.oneColor = oneColor;
        this.amountOfOneColor = amountOfOneColor;
        this.gradient = gradient;
        this.amountOfGradient = amountOfGradient;
        this.artNails = artNails;
        this.amountOfArtNails = amountOfArtNails;
        this.branchOffice = branchOffice;
        this.orders = orders;
        orders.setOptions(this);
    }

    public void addToBranchOffice(BranchOffice branchOffice){
        this.branchOffice = branchOffice;
        this.branchOffice.getOptions().add(this);
    }

    public void removeOptionFromBranchOffice(BranchOffice branchOffice){
        this.branchOffice = null;
        this.branchOffice.getOptions().remove(this);
    }



    public void setOrders(Orders orders){
        this.orders = orders;
        orders.setOptions(this);
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
                ", branchOffice=" + branchOffice +
                '}';
    }
}
