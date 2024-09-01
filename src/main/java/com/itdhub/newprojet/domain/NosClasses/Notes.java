package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;

    @Column(nullable = false)
    private String matiere;

    @Column(nullable = false)
    private Double valeur;

    @Column(nullable = false)
    private LocalDate dateEvaluation;

    // Constructeur par défaut
    public Notes() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public String getMatiere() {
        return matiere;
    }

    public Double getValeur() {
        return valeur;
    }

    public LocalDate getDateEvaluation() {
        return dateEvaluation;
    }

    // Pas de setters pour garantir l'immutabilité des objets Note une fois créés
}
