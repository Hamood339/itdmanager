package com.itdhub.newprojet.domain.NosClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Entity
@Transactional
public  class Etudiant {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private Date naissance=new Date();
    private String matricule;
    private String nationalite;

    public Etudiant(Long id, String nom, String prenom, String adresse, String email,Date naissance,String matricule,String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.naissance =naissance;
        this.matricule=matricule;
        this.nationalite=nationalite;
    }

    public Etudiant() {}

    public Etudiant(Long id, String diallo, String ahmad, String dakar, String mail, String s, String matricule, String senegalais) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
