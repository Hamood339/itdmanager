package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Certifications;
import com.itdhub.newprojet.domain.NosClasses.Etudiant;
import com.itdhub.newprojet.repository.NosRepository.CertificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CertifsService {

    @Autowired
    CertificationsRepository certificationsRepository;

    Certifications certifications = new Certifications(new Etudiant(), "certifsName", true);


    private static ArrayList<Certifications> certifs = new ArrayList<>(
        Arrays.asList(
            new Certifications(new Etudiant(),"IBM",false),
            new Certifications(new Etudiant(),"RedHat",true),
            new Certifications(new Etudiant(),"CISCO",false)
        )
    );

    public List<Certifications> getCertifs() {
      // certificationsRepository.saveAll(certifs);
        return certifs;
    }

    public Certifications addCertifsByName() {
        certifs.add(new Certifications(new Etudiant(), "CertifsName", true));
       certificationsRepository.save(new Certifications(new Etudiant(), "CertifsName", true));
        return new Certifications();
    }

    public Certifications updateCertifs(Certifications certifications, String name) {
        certifs.forEach(certifications1 -> {
            if (certifications1.getName() == name) {
                certifs.set(certifs.indexOf(certifications1), certifications);
            }
        });
       // certificationsRepository.save(certifications);
        return certifications;
    }

}
