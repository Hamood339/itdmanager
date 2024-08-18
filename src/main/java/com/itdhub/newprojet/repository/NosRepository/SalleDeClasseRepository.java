package com.itdhub.newprojet.repository.NosRepository;

import com.itdhub.newprojet.domain.NosClasses.SalleDeClasse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalleDeClasseRepository extends JpaRepository<SalleDeClasse, Long> {
    Optional<SalleDeClasse> findById(Long aLong);
}
