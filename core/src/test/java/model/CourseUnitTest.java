package model;

import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.PersistenceCourses;
import curso.input.RegisterCourse;
import curso.output.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseUnitTest {
    @Mock
    private Persistence persistence;

    private RegisterCourse registerCourse;

    @BeforeEach
    public void setUp() {
       registerCourse= new RegisterCourse(persistence);
    }

    @Test
    public void instanceCourse_Assert() throws ExceptionCourse {
        Course c = Course.Instance(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);
        Assertions.assertNotNull(c);
    }
    @Test
    public void instanceCourse_Fail() throws ExceptionCourse {
        Assertions.assertThrows(ExceptionCourse.class, () ->registerCourse.createCourse(UUID.randomUUID(),"", LocalDate.of(2024, 11, 10), Level.Avanzado));
    }
    @Test
    public void uploadCourse_Assert() throws ExceptionCourse {
        Persistence persistence = new PersistenceCourses();
        RegisterCourse registerCourse = new RegisterCourse(persistence);

        registerCourse.createCourse(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);

        Assertions.assertTrue(persistence.searchCourse("Matematicas"));
    }

    @Test
    public void uploadCourse_Fail(){
        when(persistence.searchCourse("Matematicas")).thenReturn(true);
        ExceptionCourse ex = Assertions.assertThrows(ExceptionCourse.class, () ->registerCourse.createCourse(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado));
        Assertions.assertEquals("Ya existe curso con ese nombre", ex.getMessage());
    }

    @Test
    public void CourseExistTest() throws Exception {
        when(persistence.searchCourse("Matematicas")).thenReturn(true);
        boolean esperado = persistence.searchCourse("Matematicas");
        Assertions.assertTrue(esperado);
        verify(persistence,times(1)).searchCourse("Matematicas");
    }

}
