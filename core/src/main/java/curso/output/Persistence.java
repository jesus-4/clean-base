package curso.output;

import curso.modelo.Course;

public interface Persistence {
    void saveCourse(Course course);
    boolean searchCourse(String name);
}
