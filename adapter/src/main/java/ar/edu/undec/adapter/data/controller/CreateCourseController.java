package ar.edu.undec.adapter.data.controller;

import ar.edu.undec.adapter.data.entity.CourseDTO;
import curso.exception.ExceptionCourse;
import curso.usecase.CreateCourse;
import curso.usecase.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CreateCourseController {

    private CreateCourse createCourse;

    public CreateCourseController(@Qualifier("registerCourse") CreateCourse createCourse) {
        this.createCourse = createCourse;
    }

    @PostMapping
    public ResponseEntity<?> createCourse (@RequestBody CourseDTO course) throws ExceptionCourse {
        if (this.createCourse.createCourse(
                    course.getId(),
                    course.getName(),
                    course.getDescription(),
                    course.getLevel())) {

                return ResponseEntity.ok().build();
            }

            return ResponseEntity.badRequest().build();
        }
    }
