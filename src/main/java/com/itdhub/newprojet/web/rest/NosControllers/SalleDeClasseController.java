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

    @RequestMapping(method = GET, value = "/salleDeClasse")
    public List<SalleDeClasse> getsalleDeClasses() {
        return salleDeClasseService.getSalleDeClasses();
    }
    @RequestMapping("/salleDeClasse/{id}")
    public ResponseEntity<SalleDeClasse> getSalleDeClassesById(@PathVariable Long id) {
        Optional<SalleDeClasse> salleDeClasses = salleDeClasseService.findById(id);
        return salleDeClasses.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = POST, value = "/salleDeClasse")
    public void createSalleDeClasse(@RequestBody SalleDeClasse salleDeClasse) {
         salleDeClasseService.save(salleDeClasse);
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
