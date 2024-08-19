package com.itdhub.newprojet.domain.NosClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Course {
    public Course(long l, String javaProgramming, String learnTheBasicsOfJava) {
    }

    public enum ModuleCourse {
     ANGLAIS,
     ENTREPRENARIAT,
     DEVELOPPEMENT_PERSONNEL,
     PICH,
     DROIT_DES_DONNEES_PERSONNELS,
     GRH,
     MANAGEMENT,
     COMPTABILITE_GENERAL,
     PROTECTION_DES_DONNEES_PERSONNELS,
     MONTAGE_VIDEOS,
     FINANCE,
     TRAITEMENT_IMAGE_AUDIO,
     DEVELOPPEMENT_FRONT_END,
     DEVELOPPEMENT_BACK_END,
     DESIGN_THINKING,
     METHODE_CAPSTONE,
     SCRUM_METHODE_AGILE,
     MARKETING_COMMUNICATION_DIGITAL,
     MARKETING_OPERATIONNELLE,
     RESEAUX_TELECOM_5G_IOT,
     UX_DESIGN,
 }
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private LocalDate startDate;

        private LocalDate endDate;

        private String classroom;
        private Course.ModuleCourse ModuleCourse;
        public Course(){
        }
public Course(long id,String title, LocalDate startDate, LocalDate endDate, String classroom, ModuleCourse moduleCourse){
            super();
            this.id=id;
            this.title=title;
            this.startDate=startDate;
            this.endDate=endDate;
            this.classroom=classroom;
            this.ModuleCourse=moduleCourse;
}
        // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Course.ModuleCourse getModuleCourse() {
        return ModuleCourse;
    }

    public void setModuleCourse(Course.ModuleCourse moduleCourse) {
        ModuleCourse = moduleCourse;
    }
}
