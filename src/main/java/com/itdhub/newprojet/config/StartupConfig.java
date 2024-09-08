package com.itdhub.newprojet.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StartupConfig {
    private final Logger log = LoggerFactory.getLogger(StartupConfig.class);
    private final ApplicationProperties applicationProperties;

    public StartupConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        // Récupère le chemin du répertoire d'uploads depuis les propriétés
        Path uploadPath = Paths.get(applicationProperties.getUploadDir());
        File uploadDir = new File(uploadPath.toString());

        // Vérifie si le répertoire d'uploads existe, sinon le crée
        if (!uploadDir.exists()) {
            if (uploadDir.mkdirs()) {
                log.info("Répertoire d'uploads créé : {}", uploadDir.getAbsolutePath());
            } else {
                log.error("Impossible de créer le répertoire d'uploads : {}", uploadDir.getAbsolutePath());
            }
        }
    }

}
