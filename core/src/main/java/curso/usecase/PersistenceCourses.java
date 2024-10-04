package curso.usecase;

import curso.modelo.Course;
import curso.output.Persistence;

import java.util.ArrayList;

public class PersistenceCourses implements Persistence {
    private ArrayList<Course> courses = new ArrayList<>();
    @Override
    public void saveCourse(Course course) {
        courses.add(course);
    }

    @Override
    public boolean searchCourse(String name){
        return courses.stream().anyMatch(course -> course.getName().equals(name));
    }

}
