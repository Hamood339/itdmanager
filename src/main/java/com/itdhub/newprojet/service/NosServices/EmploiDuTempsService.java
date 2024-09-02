package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Course;
import com.itdhub.newprojet.domain.NosClasses.EmploiDuTemps;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@Service
public class EmploiDuTempsService {
    public void creerEmploiDuTemps(EmploiDuTemps emploiDuTemp) {
        Calendar emploiDuTemps = Calendar.getInstance();
        emploiDuTemps.set(Calendar.DAY_OF_WEEK, convertirJour(emploiDuTemp.getJour()));
        emploiDuTemps.set(Calendar.HOUR_OF_DAY, emploiDuTemp.getHeureDebut());
        emploiDuTemps.set(Calendar.MINUTE,0);
        Calendar finEmploiDuTemps = (Calendar) emploiDuTemps.clone();
        finEmploiDuTemps.set(Calendar.HOUR_OF_DAY,emploiDuTemp.getHeureDebut());

        System.out.println("Emploi du temps pour " + emploiDuTemp.getJour() + " - " + emploiDuTemp.getCours().getTitle() + " : De " + emploiDuTemps.getTime() + " à " + finEmploiDuTemps.getTime());



    }
    private int convertirJour(String jour) {
        switch (jour.toLowerCase()) {
            case "lundi":
                return Calendar.MONDAY;
            case "mardi":
                return Calendar.TUESDAY;
            case "mercredi":
                return Calendar.WEDNESDAY;
            case "jeudi":
                return Calendar.THURSDAY;
            case "vendredi":
                return Calendar.FRIDAY;
            case "samedi":
                return Calendar.SATURDAY;
            case "dimanche":
                return Calendar.SUNDAY;
            default:
                return -1;


        }
    }

}
