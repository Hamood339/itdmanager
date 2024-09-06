package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.*;


@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;

    @Column(nullable = false)
    private String matiere;

    @Column(nullable = false)
    private Double note;

    @Column(name = "annee_academique")
    private String anneeAcademique;



    public Notes() {}

    public Notes(Etudiant etudiant, String matiere, Double note, String anneeAcademique) {
        this.etudiant = etudiant;
        this.matiere = matiere;
        this.note = note;
        this.anneeAcademique = anneeAcademique;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public String getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(String anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }
}
