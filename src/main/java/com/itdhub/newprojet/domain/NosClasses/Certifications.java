package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Certifications {
    Long id;
    boolean encours;
    String name;
    Etudiant etudiant;



    public Certifications(Etudiant etudiant, String name, boolean encours) {
        this.id = id;
        this.etudiant = etudiant;
        this.name = name;
        this.encours = encours;
    }

    public Certifications() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getEtudiant(Etudiant etudiant) {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public boolean isEncours() {
        return encours;
    }

    public void setEncours(boolean encours) {
        this.encours = encours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
