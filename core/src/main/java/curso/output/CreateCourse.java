package curso.output;

import curso.modelo.Level;

import java.time.LocalDate;
import java.util.UUID;

public interface CreateCourse {
    boolean createCourse(UUID id, String name, LocalDate date, Level level) throws Exception;
}
