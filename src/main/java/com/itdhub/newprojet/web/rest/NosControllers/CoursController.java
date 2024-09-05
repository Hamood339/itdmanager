package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Cours;
import com.itdhub.newprojet.repository.NosRepository.CoursRepository;
import com.itdhub.newprojet.service.NosServices.CoursService;
import com.itdhub.newprojet.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final Logger log = LoggerFactory.getLogger(CoursController.class);

    @Autowired
    private CoursService coursService;

    @Autowired
    private CoursRepository coursRepository;

    private static final String ENTITY_NAME = "cours";

    // Endpoint pour créer un nouveau cours
    @PostMapping("/create")
    public ResponseEntity<Cours> createCours(@RequestBody Cours cours) {
        log.debug("REST request to save Cours : {}", cours);
        if (cours.getId() != null) {
            throw new BadRequestAlertException("Un nouveau cours ne peut pas déjà avoir un ID", ENTITY_NAME, "idexists");
        }
        Cours result = coursRepository.save(cours);
        return ResponseEntity.ok().body(result);
    }

    // Endpoint pour récupérer tous les cours
    @GetMapping("/all")
    public List<Cours> getAllCours() {
        log.debug("REST request to get all Cours");
        return coursRepository.findAll();
    }

    // Endpoint pour récupérer un cours par ID
    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCours(@PathVariable Long id) {
        log.debug("REST request to get Cours : {}", id);
        Optional<Cours> cours = coursRepository.findById(id);
        return cours.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour mettre à jour un cours
    @PutMapping("/update/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long id, @RequestBody Cours cours) {
        log.debug("REST request to update Cours : {}", id);
        if (!coursRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cours.setId(id);
        Cours result = coursRepository.save(cours);
        return ResponseEntity.ok().body(result);
    }

    // Endpoint pour supprimer un cours
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable Long id) {
        log.debug("REST request to delete Cours : {}", id);
        coursRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour uploader un document pour un cours
    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.debug("REST request to upload document for Cours : {}", id);
        return ResponseEntity.ok().body(coursService.uploadDocument(id, file));
    }

    // Endpoint pour télécharger un document d'un cours
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        log.debug("REST request to download document for Cours : {}", id);
        Optional<byte[]> document = coursService.downloadDocument(id);
        return document.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour supprimer un document d'un cours
    @DeleteMapping("/{id}/deleteDocument")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.debug("REST request to delete document for Cours : {}", id);
        coursService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour mettre à jour le document d'un cours
    @PutMapping("/{id}/updateDocument")
    public ResponseEntity<String> updateDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.debug("REST request to update document for Cours : {}", id);
        return ResponseEntity.ok().body(coursService.updateDocument(id, file));
    }
}
