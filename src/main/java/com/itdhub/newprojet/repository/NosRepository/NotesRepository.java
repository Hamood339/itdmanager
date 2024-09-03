package com.itdhub.newprojet.repository.NosRepository;

import com.itdhub.newprojet.domain.NosClasses.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByEtudiantId(Long etudiantId);
   Notes findByMatiere(String matiere);


}
