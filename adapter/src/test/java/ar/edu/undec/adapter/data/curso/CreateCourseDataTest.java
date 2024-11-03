package ar.edu.undec.adapter.data.curso;

import ar.edu.undec.adapter.data.UseCase.CreateCourseRepository;
import ar.edu.undec.adapter.data.apidb.CreateCourseCRUD;
import ar.edu.undec.adapter.data.entity.CourseData;
import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.CreateCourse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCourseDataTest {

    @Mock
    CreateCourseCRUD crud;
    @InjectMocks
    CreateCourseRepository createCourseRepository;

    @Test
    public void CreateCourse_CourseSavedSuccessfully() throws ExceptionCourse {
        Course theCourse= Course.Instance(UUID.randomUUID(),"name", LocalDate.MAX, Level.Inicial);
        when(crud.save(any(CourseData.class))).thenReturn(new CourseData().setId(UUID.randomUUID()));
        boolean result= createCourseRepository.saveCourse(theCourse);
        Assertions.assertTrue(result);
    }
    @Test
    public void saveCourse_DBException_ReturnFalse() throws ExceptionCourse {
        Course theCourse= Course.Instance(UUID.randomUUID(),"name", LocalDate.MAX, Level.Inicial);
        when(crud.save(any(CourseData.class))).thenThrow(RuntimeException.class);
        boolean result= createCourseRepository.saveCourse(theCourse);
        Assertions.assertFalse(result);
    }

}
