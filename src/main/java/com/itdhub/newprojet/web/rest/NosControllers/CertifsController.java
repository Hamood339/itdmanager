package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Certifications;
import com.itdhub.newprojet.service.NosServices.CertifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifs")
public class CertifsController {

    @Autowired
    private CertifsService certifsService;

    @GetMapping
    public List<Certifications> getCertifs() {
       return certifsService.getCertifs();

    }

    @PostMapping
    public ResponseEntity<Certifications> addCertifs(@RequestBody Certifications certifs) {
        certifsService.addCertifsByName();
        return ResponseEntity.ok(certifs);
    }

    @PutMapping("/{encours}")
    public Certifications updateCertifs(@RequestBody Certifications certifications, @PathVariable boolean encours) {
        certifsService.updateCertifs(certifications, String.valueOf(encours));
        return certifications;
    }
}
