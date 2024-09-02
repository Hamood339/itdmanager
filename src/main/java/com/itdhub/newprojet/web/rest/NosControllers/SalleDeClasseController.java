package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.SalleDeClasse;
import com.itdhub.newprojet.service.NosServices.SalleDeClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/salleDeClasse")
public class SalleDeClasseController {
    @Autowired
    private SalleDeClasseService salleDeClasseService;

    @RequestMapping(method = GET, value = "/salleDeClasses")
    public List<SalleDeClasse> getSalleDeClasses() {
        return salleDeClasseService.getSallaDeClasses();
    }
    @RequestMapping("/salleDeClasse/{id}")
    public SalleDeClasse getSalleDeClasseById(@PathVariable Long id) {
        return salleDeClasseService.getSalleDeClasse(id);
    }
    @RequestMapping(method = POST, value = "/salleDeClasse")
    public void addSalleDeClasse(@RequestBody SalleDeClasse salleDeClasse) {
         salleDeClasseService.addSalleDeClasse(salleDeClasse);
    }

    @RequestMapping(method = PUT,value = "salleDeClasse/{id}")
    public void updateSalleDeClasse(@RequestBody SalleDeClasse salleDeClasse, @PathVariable long id ){
        salleDeClasseService.updateSalleDeClasse(salleDeClasse, id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value ="/salleDeClasse/{id}")
    public void deleteSalleDeClasse(@PathVariable Long id) {
        salleDeClasseService.deleteSalleDeClasse(id);
    }
}
