package com.itdhub.newprojet.repository.NosRepository;
import com.itdhub.newprojet.domain.NosClasses.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    // Vous pouvez ajouter des requêtes personnalisées ici, si nécessaire
}

