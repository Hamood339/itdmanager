package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import com.itdhub.newprojet.repository.NosRepository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EtudiantService {

    Etudiant etudiant = new Etudiant();

    @Autowired
    EtudiantRepository etudiantRepository;
    private static ArrayList<Etudiant> etudiants = new ArrayList<>(
        Arrays.asList(
            new Etudiant(1, "Diallo", "Ahmad", "Dakar", "ahmadudu339@gmail.com"),
            new Etudiant(2, "Diop", "moussa ", "Dakar", "diop21@gmail.com"),
            new Etudiant(3, "sane", "malick", "Dakar", "sane45@gmail.com"),
            new Etudiant(4, "sene", "fatou", "Dakar", "fatou78@gmail.com")
        )

    );

    public List<Etudiant> getEtudiant() {

       // etudiantRepository.findAll();
        return etudiants;

    }

    public Etudiant getById(Long id) {
    //etudiantRepository.saveAll(etudiants);
        return etudiants.stream().filter(etudiants -> etudiants.getId() == id).findFirst().orElse(null);
    }

    public void deleteEtudiantById(Long id) {
        etudiants.removeIf(etudiants -> etudiants.getId() == id);
    }

    public Etudiant addEtudiant() {
        etudiants.add(etudiant);
      // etudiantRepository.saveAll(etudiants);
        return etudiant;
    }

    public Etudiant updateEtudiant(Etudiant etudiant, long id) {
        etudiants.forEach(etudiant1 -> {
            if (etudiant1.getId() == id) {
                etudiants.set(etudiants.indexOf(etudiant1), etudiant);
            }
        });
        return etudiant;
    }
}
