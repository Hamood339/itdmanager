package com.itdhub.newprojet.domain.NosClasses;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

    @Entity
    @Table(name = "cours")
    public class Cours implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "nom", nullable = false)
        private String nom;

        @Column(name = "description")
        private String description;

        @Column(name = "document_path")
        private String documentPath;  // Ajoutez ce champ pour stocker le chemin du document

        // Getters et Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDocumentPath() {
            return documentPath;
        }

        public void setDocumentPath(String documentPath) {
            this.documentPath = documentPath;
        }

        // Méthodes equals, hashCode, toString...
    }
