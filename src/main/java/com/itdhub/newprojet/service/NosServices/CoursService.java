package com.itdhub.newprojet.service.NosServices;
import com.itdhub.newprojet.domain.NosClasses.Cours;
import com.itdhub.newprojet.repository.NosRepository.CoursRepository;
import com.itdhub.newprojet.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class CoursService {

    private final Logger log = LoggerFactory.getLogger(CoursService.class);

    private final CoursRepository coursRepository;

    @Value("${application.upload-dir}")
    private String uploadDir;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public String uploadDocument(Long coursId, MultipartFile file) {
        log.debug("Request to upload document for Cours : {}", coursId);

        if (file.isEmpty()) {
            throw new BadRequestAlertException("Le fichier est vide", "cours", "fileempty");
        }

        Optional<Cours> coursOpt = coursRepository.findById(coursId);
        if (!coursOpt.isPresent()) {
            throw new BadRequestAlertException("Cours introuvable", "cours", "idnotfound");
        }

        Cours cours = coursOpt.get();

        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            file.transferTo(filePath.toFile());

            cours.setDocumentPath(filePath.toString());
            coursRepository.save(cours);

            return "Fichier uploadé avec succès : " + file.getOriginalFilename();
        } catch (IOException e) {
            log.error("Erreur lors de l'upload du fichier", e);
            throw new BadRequestAlertException("Erreur d'upload", "cours", "uploaderror");
        }
    }

    public Optional<byte[]> downloadDocument(Long coursId) {
        log.debug("Request to download document for Cours : {}", coursId);

        Optional<Cours> coursOpt = coursRepository.findById(coursId);
        if (!coursOpt.isPresent() || coursOpt.get().getDocumentPath() == null) {
            return Optional.empty();
        }

        Cours cours = coursOpt.get();

        try {
            Path path = Paths.get(cours.getDocumentPath());
            byte[] document = Files.readAllBytes(path);
            return Optional.of(document);
        } catch (IOException e) {
            log.error("Erreur lors du téléchargement du fichier", e);
            return Optional.empty();
        }
    }

    public void deleteDocument(Long coursId) {
        log.debug("Request to delete document for Cours : {}", coursId);

        Optional<Cours> coursOpt = coursRepository.findById(coursId);
        if (!coursOpt.isPresent() || coursOpt.get().getDocumentPath() == null) {
            throw new BadRequestAlertException("Document non trouvé", "cours", "filenotfound");
        }

        Cours cours = coursOpt.get();

        try {
            Path path = Paths.get(cours.getDocumentPath());
            Files.deleteIfExists(path);
            cours.setDocumentPath(null);
            coursRepository.save(cours);
        } catch (IOException e) {
            log.error("Erreur lors de la suppression du fichier", e);
            throw new BadRequestAlertException("Erreur de suppression", "cours", "deleteerror");
        }
    }

    public String updateDocument(Long coursId, MultipartFile file) {
        log.debug("Request to update document for Cours : {}", coursId);

        if (file.isEmpty()) {
            throw new BadRequestAlertException("Le fichier est vide", "cours", "fileempty");
        }

        Optional<Cours> coursOpt = coursRepository.findById(coursId);
        if (!coursOpt.isPresent()) {
            throw new BadRequestAlertException("Cours introuvable", "cours", "idnotfound");
        }

        Cours cours = coursOpt.get();

        try {
            // Supprimer l'ancien fichier
            if (cours.getDocumentPath() != null) {
                Path oldPath = Paths.get(cours.getDocumentPath());
                Files.deleteIfExists(oldPath);
            }

            // Enregistrer le nouveau fichier
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            file.transferTo(filePath.toFile());

            // Mettre à jour le chemin du document
            cours.setDocumentPath(filePath.toString());
            coursRepository.save(cours);

            return "Fichier mis à jour avec succès : " + file.getOriginalFilename();
        } catch (IOException e) {
            log.error("Erreur lors de la mise à jour du fichier", e);
            throw new BadRequestAlertException("Erreur de mise à jour", "cours", "updateerror");
        }
    }
}

