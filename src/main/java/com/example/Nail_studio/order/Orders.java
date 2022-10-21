package com.example.Nail_studio.order;

import com.example.Nail_studio.options.Options;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Orders")
@Table(name = "orders")
public class Orders {

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



    public Orders(LocalDateTime createdAt, Boolean approved) {
        this.createdAt = createdAt;
        this.approved = approved;
    }

    public Orders(LocalDateTime createdAt, Boolean approved, Options options) {
        this.createdAt = createdAt;
        this.approved = approved;
        this.options = options;
        options.setOrders(this);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", approved=" + approved +
                ", options=" + options +
                '}';
    }
}
