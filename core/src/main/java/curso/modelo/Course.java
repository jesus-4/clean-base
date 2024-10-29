package curso.modelo;

import curso.exception.ExceptionCourse;

import java.time.LocalDate;
import java.util.UUID;

public class Course {
    private UUID id;
    private String name;
    private LocalDate inscriptionDate;
    private Level level;
    private Course(UUID id, String name, LocalDate inscriptionDate, Level nivel) {
        this.id = id;
        this.name = name;
        this.inscriptionDate = inscriptionDate;
        this.level = nivel;
    }

    public static Course Instance(UUID id, String name, LocalDate inscriptionDate, Level level) throws ExceptionCourse {

      if (inscriptionDate == null || LocalDate.now().isAfter(inscriptionDate)) {
          throw new ExceptionCourse("La fecha es anterior al dia de hoy");
      }
      if (name == null || name.isEmpty()) {
          throw new ExceptionCourse("Error al Ingresar nombre");
      }
      if (id == null) {
          throw new ExceptionCourse("Error al ingresar el id");
      }
        return new Course(id, name, inscriptionDate, level);
    }

    public String getName() {
        return name;
    }
    public Level getLevel() {
        return level;
    }
    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }
    public UUID getId() {
        return id;
    }
}
