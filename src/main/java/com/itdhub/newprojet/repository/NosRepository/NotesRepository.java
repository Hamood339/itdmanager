package com.itdhub.newprojet.repository.NosRepository;

import com.itdhub.newprojet.domain.NosClasses.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByEtudiantId(Long etudiantId);

    // Vous pouvez ajouter d'autres méthodes de requête si nécessaire, par exemple :
    List<Notes> findByEtudiantIdAndMatiere(Long etudiantId, String matiere);
    List<Notes> findByEtudiantIdOrderByDateEvaluationDesc(Long etudiantId);
}
