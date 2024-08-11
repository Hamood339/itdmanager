package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import com.itdhub.newprojet.service.NosServices.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/api/etudiant")
    public List<Etudiant> getEtudiant() {
        return etudiantService.getEtudiant();
    }

    @GetMapping( "/api/etudiant/{id}")
    public Etudiant getStudentById(@PathVariable long id) {
        return etudiantService.getById(id);
    }

    @DeleteMapping( "/api/etudiant/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        etudiantService.deleteEtudiantById(id);
    }

    @PostMapping( "/api/etudiant")
    public void addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.addEtudiant();
    }

    @PutMapping("/api/etudiant/{id}")
    public void updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable long id) {
        etudiantService.updateEtudiant(etudiant, id);
    }
}
