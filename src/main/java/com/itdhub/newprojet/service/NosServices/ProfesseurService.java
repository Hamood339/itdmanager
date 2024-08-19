package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Professeur;
import com.itdhub.newprojet.repository.NosRepository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesseurService {
    @Autowired
    ProfesseurRepository professeurRepository;

    public void creerProffesseur(Professeur professeur) {
      Professeur professeurDansBDD = professeurRepository.findByEmail(professeur.getEmail());
         if (professeurDansBDD == null){
        professeurRepository.save(professeur);}

    }
    public Optional<Professeur> rechercherProffesseur(String email) {
        Optional<Professeur> leProffTrouver= Optional.ofNullable(professeurRepository.findByEmail(email));
        if(leProffTrouver.isPresent()){
            return leProffTrouver;
        }
        else
            return Optional.ofNullable(null);
    }
    public void supprimerProffesseur(String email){
        Optional<Professeur> leProfASupprimer= Optional.ofNullable(professeurRepository.findByEmail(email));
        if(leProfASupprimer.isPresent()){
            professeurRepository.delete(leProfASupprimer.get());
        }
           // proffesseurRepository.delete(proffesseurRepository.findByEmail(email).get());

    }
    public Professeur modifierProffesseur(Professeur professeur){
        Optional<Professeur> leProfesseurTrouver = Optional.ofNullable(professeurRepository.findByEmail(professeur.getEmail()));
        if(leProfesseurTrouver.isPresent()){
            leProfesseurTrouver.get().setNom(professeur.getNom());
            leProfesseurTrouver.get().setPrenom(professeur.getPrenom());
            leProfesseurTrouver.get().setEmail(professeur.getEmail());
            leProfesseurTrouver.get().setAge(professeur.getAge());
            leProfesseurTrouver.get().setTelephone(professeur.getTelephone());
            leProfesseurTrouver.get().setAdresse(professeur.getAdresse());
            professeurRepository.save(leProfesseurTrouver.get());
            return leProfesseurTrouver.get();
        }
        return null;

    }


}
