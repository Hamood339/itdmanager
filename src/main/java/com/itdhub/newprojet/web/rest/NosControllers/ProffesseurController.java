package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Proffesseur;
import com.itdhub.newprojet.service.NosServices.ProffesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProffesseurController {
    @Autowired
    ProffesseurService proffesseurService;
    @PostMapping("/proffesseur")
    public void proffesseur(@RequestBody Proffesseur proffesseur) {

        proffesseurService.creerProffesseur(proffesseur);
    }
    @GetMapping("/proffesseur/{email}")
    public Optional<Proffesseur> rechercheproffesseur(@PathVariable String email){
       Optional<Proffesseur> leProffTrouver= proffesseurService.rechercherProffesseur(email);
        return leProffTrouver;
    }

    @DeleteMapping("/proffesseur/{email}")
    public void supprimerProfesseur(@PathVariable String email) {
        proffesseurService.supprimerProffesseur(email);
    }

    @PutMapping("/proffesseur")
    public Proffesseur modifierProffesseur(@RequestBody Proffesseur proffesseur) {
        proffesseurService.modifierProffesseur(proffesseur);
        return proffesseur;
    }




}
