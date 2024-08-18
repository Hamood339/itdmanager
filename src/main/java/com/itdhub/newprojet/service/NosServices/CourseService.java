package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    // Liste simulée pour stocker les cours
    private List<Course> courses = new ArrayList<>();

    // Constructeur pour ajouter des cours initiaux à la liste
    public CourseService() {
        courses.add(new Course(1L, "Java Programming", "Learn the basics of Java"));
        courses.add(new Course(2L, "Spring Boot", "Introduction to Spring Boot"));
        courses.add(new Course(3L, "React", "Learn how to build web applications with React"));
    }

    /**
     * Récupère la liste de tous les cours.
     * @return Liste des objets Course.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Récupère un cours spécifique en fonction de l'ID.
     * @param id L'ID du cours à récupérer.
     * @return Un Optional contenant le cours s'il est trouvé, sinon un Optional vide.
     */
    public Optional<Course> getCourse(Long id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findFirst();
    }

    /**
     * Ajoute un nouveau cours à la liste.
     * @param course Le cours à ajouter.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Met à jour un cours existant en fonction de l'ID.
     * @param course Le cours mis à jour avec les nouvelles informations.
     * @param id L'ID du cours à mettre à jour.
     */
    public void updateCourse(Course course, Long id) {
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getId().equals(id)) {
                // Remplace l'ancien cours par le nouveau
                courses.set(i, course);
                return;
            }
        }
    }

    /**
     * Supprime un cours en fonction de l'ID.
     * @param id L'ID du cours à supprimer.
     */
    public void deleteCourse(Long id) {
        // Retire de la liste le cours qui a cet ID
        courses.removeIf(course -> course.getId().equals(id));
    }
}
