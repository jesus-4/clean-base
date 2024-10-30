package curso.usecase;

import curso.modelo.Course;
import curso.modelo.Level;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersistenceCourses implements Persistence {
    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    public boolean saveCourse(Course course) {
        return courses.add(course);
    }

    @Override
    public boolean existCourse(String name){
        return courses.stream().anyMatch(course -> course.getName().equals(name));
    }

    @Override
    public ArrayList<Course> getCoursesBylvl(Level lvl) {
        return courses.stream().filter(s-> s.getLevel().equals(lvl)).collect(Collectors.toCollection(ArrayList::new));
    }

}
