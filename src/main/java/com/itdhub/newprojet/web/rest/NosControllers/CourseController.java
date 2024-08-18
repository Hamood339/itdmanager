package com.itdhub.newprojet.web.rest.NosControllers;

import com.itdhub.newprojet.domain.NosClasses.Course;
import com.itdhub.newprojet.service.NosServices.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private  CourseService courseService ;
    @RequestMapping(method = RequestMethod.GET, value = "/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @RequestMapping("/course/{id}")
    public Optional<Course> getCourses(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/course/{id}")
public void updateCourse(@RequestBody Course course, @PathVariable long id){
         courseService.updateCourse(course, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteCourse(@PathVariable Long id){
         courseService.deleteCourse(id);
    }
}

