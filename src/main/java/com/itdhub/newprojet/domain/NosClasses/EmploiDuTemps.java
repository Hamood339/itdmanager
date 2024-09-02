package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    @Transient
    private Course cours;
    private int heureDebut;
    private int heureFin;

    public EmploiDuTemps() {
    }

    public EmploiDuTemps(String jour, Course cours, int heureDebut, int heureFin) {
        this.jour = jour;
        this.cours = cours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }


    public Course getCours() {
        return cours;
    }

    public void setCours(Course cours) {
        this.cours = cours;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
