package curso.input;

import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.output.CreateCourse;
import curso.output.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class RegisterCourse implements CreateCourse {
    private final Persistence persistence;

    public RegisterCourse(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public boolean createCourse (UUID id, String name, LocalDate date, Level lvl) throws ExceptionCourse {
        Course c = Course.Instance(id, name, date,lvl);

        if (persistence.searchCourse(c.getName())) {
            throw new ExceptionCourse("Ya existe curso con ese nombre");
        }
        return persistence.saveCourse(c);
        }
    }
