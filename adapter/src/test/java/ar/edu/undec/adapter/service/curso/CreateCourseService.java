package ar.edu.undec.adapter.service.curso;

import ar.edu.undec.adapter.data.controller.CreateCourseController;
import ar.edu.undec.adapter.data.entity.CourseDTO;
import curso.exception.ExceptionCourse;
import curso.modelo.Level;
import curso.usecase.CreateCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCourseService {
    @Mock
    CreateCourse input;
    @InjectMocks
    CreateCourseController controller;

    @Test
    public void CreateCourse_CourseSaved_Return200() throws ExceptionCourse {
        //Arrange
        UUID tmpId = UUID.randomUUID();
        when(input.createCourse(tmpId, "name", LocalDate.MAX, Level.Inicial)).thenReturn(true);
//        when(input.createCourse(UUID.randomUUID(), "name", LocalDate.MAX, Level.Inicial)).thenReturn(true);

//        CourseDTO theCourse= new CourseDTO(UUID.randomUUID(),"name", LocalDate.MAX, Level.Inicial);
        CourseDTO theCourse= new CourseDTO(tmpId,"name", LocalDate.MAX, Level.Inicial);

        //Act
        ResponseEntity<?> result = controller.createCourse(theCourse);

        //Assert
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }
    @Test
    public void CreateCourse_CourseSaved_Return400() throws ExceptionCourse {
        //Arrange
        UUID tmpId = UUID.randomUUID();
        when(input.createCourse(tmpId, "name", LocalDate.MAX, Level.Inicial)).thenThrow(new ExceptionCourse("Ya existe curso con ese nombre"));
//        when(input.createCourse(UUID.randomUUID(), "name", LocalDate.MAX, Level.Inicial)).thenThrow(new ExceptionCourse("Course name already exist"));
//        CourseDTO theCourse= new CourseDTO(UUID.randomUUID(),"name", LocalDate.MAX, Level.Inicial);
        CourseDTO theCourse= new CourseDTO(tmpId,"name", LocalDate.MAX, Level.Inicial);

        //Act
        ResponseEntity<?> result = controller.createCourse(theCourse);

        //Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());

    }
    @Test
    public void CreateCourse_CourseNotSaved_Return500() throws ExceptionCourse {
        //Arrange
        UUID tmpId = UUID.randomUUID();
        when(input.createCourse(tmpId, "name", LocalDate.MAX, Level.Inicial)).thenReturn(false);
//        when(input.createCourse(UUID.randomUUID(), "name", LocalDate.MAX, Level.Inicial)).thenThrow(new ExceptionCourse("Course name already exist"));
//        CourseDTO theCourse= new CourseDTO(UUID.randomUUID(),"name", LocalDate.MAX, Level.Inicial);
        CourseDTO theCourse= new CourseDTO(tmpId,"name", LocalDate.MAX, Level.Inicial);

        //Act
        ResponseEntity<?> result = controller.createCourse(theCourse);

        //Assert
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());

    }

}
