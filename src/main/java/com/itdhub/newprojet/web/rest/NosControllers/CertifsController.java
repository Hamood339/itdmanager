package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Certifications;
import com.itdhub.newprojet.service.NosServices.CertifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertifsController {

    @Autowired
    private CertifsService certifsService;

    @GetMapping("/api/certifs")
    public List<Certifications> getCertifs() {
        certifsService.getCertifs();
        return getCertifs();
    }

    @PostMapping( "/api/certifs")
    public void addCertifs(@RequestBody Certifications certifs) {
        certifsService.addCertifsByName();
    }

    @PutMapping("/api/certifs/{name}")
    public void updateCertifs(@RequestBody Certifications certifications, @PathVariable String name) {
        certifsService.updateCertifs(certifications, name);
    }
}
