package com.itdhub.newprojet.repository.NosRepository;

import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
