package curso.output;

import curso.modelo.Course;
import curso.modelo.Level;

import java.util.ArrayList;

public interface Persistence {
    boolean saveCourse(Course course);
    boolean searchCourse(String name);
    ArrayList<Course> getCoursesBylvl(Level lvl);
}
