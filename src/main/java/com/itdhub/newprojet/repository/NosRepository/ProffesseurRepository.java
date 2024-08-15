package com.itdhub.newprojet.repository.NosRepository;

import com.itdhub.newprojet.domain.NosClasses.Proffesseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProffesseurRepository extends JpaRepository<Proffesseur, Long> {
    Optional<Proffesseur> findById(Long id);
    Proffesseur findByEmail(String email);
}
