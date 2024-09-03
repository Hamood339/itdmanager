package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import com.itdhub.newprojet.repository.NosRepository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EtudiantService {

    Etudiant etudiant = new Etudiant();

    @Autowired
    EtudiantRepository etudiantRepository;
    private static ArrayList<Etudiant> etudiants = new ArrayList<>(
        Arrays.asList(
            new Etudiant(1L, "Diallo", "Ahmad", "Dakar", "ahmadudu339@gmail.com", "12/12/2002","ITD-LAB00"+id,"Senegalais"),
            new Etudiant(2L, "Diop", "moussa ", "Dakar", "diop21@gmail.com","12/12/2002","ITD-LAB00"+id,"Senegalais"),
            new Etudiant(3L, "sane", "malick", "Dakar", "sane45@gmail.com","12/12/2002","ITD-LAB00"+id,"Senegalais"),
            new Etudiant(4L, "sene", "fatou", "Dakar", "fatou78@gmail.com","12/12/2002","ITD-LAB00"+id,"Senegalais")
        )

    );

    public List<Etudiant> getEtudiant() {
        etudiants.add(etudiant);
       return etudiantRepository.saveAll(etudiants);
    }

    public Etudiant getById(Long id) {

        etudiants.stream().filter(etudiants -> etudiants.getId() == id).findFirst().orElse(null);
        etudiantRepository.saveAll(etudiants);
        return etudiant;
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
