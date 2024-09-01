package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.NotificationMail;
import com.itdhub.newprojet.service.NosServices.NotificationException;
import com.itdhub.newprojet.service.NosServices.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/notifications")
    public class NotificationController {

        private final NotificationService notificationService;

        @Autowired
        public NotificationController(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        @PostMapping("/email")
        public ResponseEntity<String> sendEmail(@RequestBody NotificationMail notificationMail) {
            try {
                NotificationService.NotificationMail(notificationMail);
                return ResponseEntity.ok("Email envoyé avec succès");
            } catch (NotificationException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'envoi de l'email : " + e.getMessage());
            }
        }

        @PostMapping("/sms")
        public ResponseEntity<String> sendSMS(@RequestParam String phoneNumber, @RequestParam String message) {
            try {
                notificationService.sendSMS(phoneNumber, message);
                return ResponseEntity.ok("SMS envoyé avec succès");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'envoi du SMS : " + e.getMessage());
            }
        }
    }

