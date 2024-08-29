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

    // Liste simulée pour stocker les salles de classe
    private List<SalleDeClasse> salleDeClasses = new ArrayList<>();

    // Constructeur pour ajouter des salles de classe initiales à la liste
    public SalleDeClasseService() {
        salleDeClasses.add(new SalleDeClasse(1L, "Salle A", 30));
        salleDeClasses.add(new SalleDeClasse(2L, "Salle B", 25));
        salleDeClasses.add(new SalleDeClasse(3L, "Salle C", 40));
    }

    /**
     * Récupère la liste de toutes les salles de classe.
     * @return Liste des objets SalleDeClasse.
     */
    public List<SalleDeClasse> getSalleDeClasses() {
        return salleDeClasses;
    }

    /**
     * Récupère une salle de classe spécifique par son ID.
     * @param id L'ID de la salle de classe à récupérer.
     * @return Un Optional contenant la salle de classe si elle est trouvée, sinon un Optional vide.
     */
    public Optional<SalleDeClasse> findById(Long id) {
        return salleDeClasses.stream().filter(salle -> salle.getId().equals(id)).findFirst();
    }

    /**
     * Sauvegarde une nouvelle salle de classe.
     * @param salleDeClasse La salle de classe à ajouter.
     */
    public void save(SalleDeClasse salleDeClasse) {
        salleDeClasses.add(salleDeClasse);
    }

    /**
     * Met à jour une salle de classe existante par son ID.
     * @param salleDeClasse La salle de classe mise à jour avec les nouvelles informations.
     * @param id L'ID de la salle de classe à mettre à jour.
     */
    public void updateSalleDeClasse(SalleDeClasse salleDeClasse, Long id) {
        for (int i = 0; i < salleDeClasses.size(); i++) {
            SalleDeClasse s = salleDeClasses.get(i);
            if (s.getId().equals(id)) {
                // Remplace l'ancienne salle de classe par la nouvelle
                salleDeClasses.set(i, salleDeClasse);
                return;
            }
        }
    }

    /**
     * Supprime une salle de classe par son ID.
     * @param id L'ID de la salle de classe à supprimer.
     */
    public void deleteSalleDeClasse(Long id) {
        // Retire de la liste la salle de classe qui a cet ID
        salleDeClasses.removeIf(salle -> salle.getId().equals(id));
    }
}
