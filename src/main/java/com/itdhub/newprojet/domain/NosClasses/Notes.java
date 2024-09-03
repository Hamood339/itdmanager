package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.*;



@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_matricule", nullable = false)
    private Etudiant etudiant;

    @Column(nullable = false)
    private String matiere;

    @Column(nullable = false)
    private Double notes;



    public Notes() {}


    public Long getId() {
        return id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public String getMatiere() {
        return matiere;
    }

    public Double getNotes() {
        return notes;
    }



}
