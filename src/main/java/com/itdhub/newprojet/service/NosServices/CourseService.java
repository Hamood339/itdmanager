package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Course;
import com.itdhub.newprojet.repository.NosRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    // Constructeur pour ajouter des cours initiaux à la liste
   /* public CourseService() {
        courses.add(new Course(1L, "Java Programming", "Learn the basics of Java"));
        courses.add(new Course(2L, "Spring Boot", "Introduction to Spring Boot"));
        courses.add(new Course(3L, "React", "Learn how to build web applications with React"));
    }
   */
     //Récupère la liste de tous les cours. pour l'utilisation de repository
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> {course.add(course);});
        return courses;
    }
     /*Récupère un cours spécifique en fonction de l'ID.
     * @param id L'ID du cours à récupérer.
     * @return Un Optional contenant le cours s'il est trouvé, sinon un Optional vide.
     */
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    /**
     * Ajoute un nouveau cours à la liste.
     * @param course Le cours à ajouter.
     */
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    /**
     * Met à jour un cours existant en fonction de l'ID.
     * @param course Le cours mis à jour avec les nouvelles informations.
     * @param id L'ID du cours à mettre à jour.
     */
    public void  updateCourse(Course course, long id) {
        courseRepository.save(course);

    }

    /**
     * Supprime un cours en fonction de l'ID.
     * @param id L'ID du cours à supprimer.
     */
    public void deleteCourse(Long id) {
        // Retire de la liste le cours qui a cet ID
        courseRepository.deleteById(id);
    }
}
