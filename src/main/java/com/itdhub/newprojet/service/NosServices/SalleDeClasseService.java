package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.SalleDeClasse;
import com.itdhub.newprojet.repository.NosRepository.SalleDeClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalleDeClasseService {
@Autowired
    private SalleDeClasseRepository salleDeClasseRepository;
    /**
     * Récupère la liste de toutes les salles de classe.
     * @return Liste des objets SalleDeClasse.
     */
    public List<SalleDeClasse> getSallaDeClasses(){
        List<SalleDeClasse>salleDeClasses= new ArrayList<>();
        salleDeClasseRepository.findAll().forEach(salleDeClasse -> {salleDeClasses.add(salleDeClasse);});
        return salleDeClasses;
    }

    /**
     * Récupère une salle de classe spécifique par son ID.
     * @param id L'ID de la salle de classe à récupérer.
     * @return Un Optional contenant la salle de classe si elle est trouvée, sinon un Optional vide.
     */
    public SalleDeClasse getSalleDeClasse ( Long id) {
        return salleDeClasseRepository.findById(id).orElse(null);
    }
    public void addSalleDeClasse(SalleDeClasse salleDeClasse){
       salleDeClasseRepository.save(salleDeClasse);
    }
    /**
     * Met à jour une salle de classe existante par son ID.
     * @param salleDeClasse La salle de classe mise à jour avec les nouvelles informations.
     * @param id L'ID de la salle de classe à mettre à jour.
     */
    public void updateSalleDeClasse(SalleDeClasse salleDeClasse, Long id) {
        salleDeClasseRepository.save(salleDeClasse);
    }

    /**
     * Supprime une salle de classe par son ID.
     * @param id L'ID de la salle de classe à supprimer.
     */
    public void deleteSalleDeClasse(Long id) {
        // Retire de la liste la salle de classe qui a cet ID
        salleDeClasseRepository.deleteById(id);
    }
}
