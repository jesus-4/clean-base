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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class UnitTestCourse {
    @Test
    public void instanceCourse_Assert() throws ExceptionCourse {
        Course c = Course.Instance(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);
        Assertions.assertNotNull(c);
    }
    @Test
    public void uploadCourse_Assert() throws ExceptionCourse {
        Persistence persistence = new PersistenceCourses();
        RegisterCourse registerCourse = new RegisterCourse(persistence);

        registerCourse.createCourse(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);

        Assertions.assertTrue(persistence.searchCourse("Matematicas"));
    }
//
    @Mock
    private Persistence persistence;

    @InjectMocks
    private RegisterCourse registerCourse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void firstTryMock() throws Exception {
        when(persistence.searchCourse("Matematicas")).thenReturn(true);
        boolean esperado = persistence.searchCourse("Matematicas");
        Assertions.assertTrue(esperado);
        verify(persistence,times(1)).searchCourse("Matematicas");
    }
}
