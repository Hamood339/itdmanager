package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Professeur;
import com.itdhub.newprojet.service.NosServices.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfesseurController {
    @Autowired
    ProfesseurService professeurService;
    @PostMapping("/professeur")
    public void proffesseur(@RequestBody Professeur professeur) {

        professeurService.creerProffesseur(professeur);
    }
    @GetMapping("/professeur/{email}")
    public Optional<Professeur> rechercheproffesseur(@PathVariable String email){
       Optional<Professeur> leProfesseurATrouver= professeurService.rechercherProffesseur(email);
        return leProfesseurATrouver;
    }

    @DeleteMapping("/professeur/{email}")
    public void supprimerProfesseur(@PathVariable String email) {
        professeurService.supprimerProffesseur(email);
    }

    @PutMapping("/professeur")
    public Professeur modifierProffesseur(@RequestBody Professeur professeur) {
        professeurService.modifierProffesseur(professeur);
        return professeur;
    }




}
