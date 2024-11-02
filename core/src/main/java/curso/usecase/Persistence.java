package curso.usecase;

import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;

import java.util.ArrayList;

public interface Persistence {
    boolean saveCourse(Course course);
    boolean existCourse(String name);
    ArrayList<Course> getCoursesBylvl(Level lvl) throws ExceptionCourse;
}
