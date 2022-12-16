package com.example.Nail_studio.branchoffice;

import com.example.Nail_studio.options.Options;
import com.example.Nail_studio.specialist.Specialist;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "BranchOffice")
@Table(name = "branch_office")
public class BranchOffice {

    @Id
    @SequenceGenerator(name = "branchOffice__id_sequence",
                        sequenceName = "branchOffice__id_sequence",
                        allocationSize = 1)
    @GeneratedValue(generator = "branchOffice__id_sequence",
                    strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false)
    private Long id;


    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;


    @Column(name = "address",
            nullable = false,
            columnDefinition = "TEXT")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "branchOffice",
                cascade = /*CascadeType.ALL*/{CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE},
                orphanRemoval = true,
                fetch = FetchType.LAZY)
    private List<Specialist> specialists = new ArrayList<>();



    public BranchOffice(String name, String address) {
        this.name = name;
        this.address = address;
    }



    public void addSpecialist(Specialist specialist){
        this.specialists.add(specialist);
        specialist.setBranchOffice(this);
    }

    public void removeSpecialist(Specialist specialist){
        if (this.specialists.contains(specialist)){
            this.specialists.remove(specialist);
            specialist.setBranchOffice(null);
        }
    }


    @Override
    public String toString() {
        return "BranchOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
