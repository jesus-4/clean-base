package ar.edu.undec.adapter.data.bootstrap;

import ar.edu.undec.adapter.data.entity.CourseDTO;
import ar.edu.undec.adapter.data.mapper.Mapper;
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

    private Persistence persistence;
    private CreateCourse createCourse;

    @Autowired
    public CreateCourseController(Persistence persistence, CreateCourse createCourse) {
        this.persistence = persistence;
        this.createCourse = createCourse;
    }

    @PostMapping
    public ResponseEntity<?> createCourse (@RequestBody CourseDTO course) throws Exception {
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

}
