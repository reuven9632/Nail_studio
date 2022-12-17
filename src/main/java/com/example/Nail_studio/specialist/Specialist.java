package com.example.Nail_studio.specialist;

import com.example.Nail_studio.branchoffice.BranchOffice;
import com.example.Nail_studio.role.Role;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Specialist")
@Table(name = "specialist",
        uniqueConstraints = @UniqueConstraint(name = "specialist__email_unique", columnNames = "email"))
public class Specialist {

    @Id
    @SequenceGenerator(name = "specialist__id_sequence",
                        sequenceName = "specialist__id_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "specialist__id_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "name_specialist",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;


    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;


    @Column(name = "experience",
            nullable = true)
    private Integer experience;


    @Enumerated(EnumType.STRING)
    @Column(name = "role",
            nullable = false)
    private Role role;


    @ManyToOne
    @JoinColumn(name = "branch_office_id",
                referencedColumnName = "id",
                /*nullable = false,*/
                foreignKey = @ForeignKey(name = "Specialist__branchOffice_id_fk"))
    private BranchOffice branchOffice;


    public Specialist(String name, String email, Integer experience, Role role) {
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.role = role;
    }

    public Specialist(String name, String email, Integer experience, Role role, BranchOffice branchOffice) {
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.role = role;
        this.branchOffice = branchOffice;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", experience=" + experience +
                ", role=" + role +
                '}';
    }
}
