package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Proffesseur;
import com.itdhub.newprojet.repository.NosRepository.ProffesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProffesseurService {
    @Autowired
    ProffesseurRepository proffesseurRepository;

    public void creerProffesseur(Proffesseur proffesseur) {
      Proffesseur proffesseurDansBDD= proffesseurRepository.findByEmail(proffesseur.getEmail());
         if (proffesseurDansBDD == null){
        proffesseurRepository.save(proffesseur);}

    }
    public Optional<Proffesseur> rechercherProffesseur(String email) {
        Optional<Proffesseur> leProffTrouver= Optional.ofNullable(proffesseurRepository.findByEmail(email));
        if(leProffTrouver.isPresent()){
            return leProffTrouver;
        }
        else
            return Optional.ofNullable(null);
    }
    public void supprimerProffesseur(String email){
        Optional<Proffesseur> leProfASupprimer= Optional.ofNullable(proffesseurRepository.findByEmail(email));
        if(leProfASupprimer.isPresent()){
            proffesseurRepository.delete(leProfASupprimer.get());
        }
           // proffesseurRepository.delete(proffesseurRepository.findByEmail(email).get());

    }
    public Proffesseur modifierProffesseur(Proffesseur proffesseur){
        Optional<Proffesseur> leProffVerificateur = Optional.ofNullable(proffesseurRepository.findByEmail(proffesseur.getEmail()));
        if(leProffVerificateur.isPresent()){
            leProffVerificateur.get().setNom(proffesseur.getNom());
            leProffVerificateur.get().setPrenom(proffesseur.getPrenom());
            leProffVerificateur.get().setEmail(proffesseur.getEmail());
            leProffVerificateur.get().setAge(proffesseur.getAge());
            leProffVerificateur.get().setTelephone(proffesseur.getTelephone());
            leProffVerificateur.get().setAdresse(proffesseur.getAdresse());
            proffesseurRepository.save(leProffVerificateur.get());
            return leProffVerificateur.get();
        }
        return null;

    }


}
