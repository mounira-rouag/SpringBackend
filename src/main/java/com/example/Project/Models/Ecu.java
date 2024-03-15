package com.example.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="`ECU`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ecu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`IdEcu`")
    private int idEcu;
    @Column(name = "`NomEcu`")
    private  String nomEcu;
    @Column(name = "`TypeInj`")
    private String  typeInj;
    @Column(name = "`PhraseTypeInj`")
    private String phraseTypeInj;
    @JsonIgnore
    @OneToMany(mappedBy = "ecu")
    private List<Dev> dev;

    @ManyToOne
    @JoinColumn(name = "`IdFamille`")
    private Famille famille;

}
