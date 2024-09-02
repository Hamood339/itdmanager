package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalleDeClasse {
    public enum typeDeSalle{
    SALLE_CONFERENCE,
    LABORATOIRE,
    SALLE_SEMINAIRE,
    COUR_EN_LIGNE
}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDeLaSalle;
    private int capciteDeLaSalle;
    private String typeDeSalle;
    public SalleDeClasse(){

    }
    public SalleDeClasse(Long id,String nomDeLaSalle, int capciteDeLaSalle, String typeDeSalle){
        super();
        this.id=id;
        this.nomDeLaSalle=nomDeLaSalle;
        this.capciteDeLaSalle=capciteDeLaSalle;
        this.typeDeSalle=typeDeSalle;
    }
    //GENERATE GETTER AND SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomDeLaSalle() {
        return nomDeLaSalle;
    }

    public void setNomDeLaSalle(String nomDeLaSalle) {
        this.nomDeLaSalle = nomDeLaSalle;
    }

    public int getCapciteDeLaSalle() {
        return capciteDeLaSalle;
    }

    public void setCapciteDeLaSalle(int capciteDeLaSalle) {
        this.capciteDeLaSalle = capciteDeLaSalle;
    }

    public String getTypeDeSalle() {
        return typeDeSalle;
    }

    public void setTypeDeSalle(String typeDeSalle) {
        this.typeDeSalle = typeDeSalle;
    }
}
