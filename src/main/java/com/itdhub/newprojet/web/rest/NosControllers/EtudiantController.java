package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import com.itdhub.newprojet.repository.NosRepository.EtudiantRepository;
import com.itdhub.newprojet.service.NosServices.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Etudiant> getEtudiant() {
        return etudiantService.getEtudiant();
    }

    @GetMapping( "/{id}")
    public Etudiant getStudentById(@PathVariable long id) {
        return etudiantService.getById(id);
    }

  @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.addEtudiant();
        return ResponseEntity.ok(etudiant);
    }

    /* @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant saveEtudiant = etudiantRepository.save(etudiant);
        return new ResponseEntity<>(saveEtudiant, HttpStatus.CREATED);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable long id) {
        etudiantService.updateEtudiant(etudiant, id);
        return ResponseEntity.ok(etudiant);
    }
   /* @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        if (!etudiantRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etudiant.setId(Math.toIntExact(id)); // Assurez-vous que l'ID est bien défini
        Etudiant updateEtudiant = etudiantRepository.save(etudiant);
        return new ResponseEntity<>(updateEtudiant, HttpStatus.OK);
    }*/
    @DeleteMapping( "/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        etudiantService.deleteEtudiantById(id);
    }
}
