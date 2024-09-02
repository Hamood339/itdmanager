package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.EmploiDuTemps;
import com.itdhub.newprojet.service.NosServices.EmploiDuTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/")
public class EmploiDuTempsController {
    @Autowired
    EmploiDuTempsService emploiDuTempsService;

    @PostMapping("emploi/")
    public void creerEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps) {
        emploiDuTempsService.creerEmploiDuTemps(emploiDuTemps);
    }
}
