package ar.edu.undec.adapter.data.mapper;

import ar.edu.undec.adapter.data.entity.CourseData;
import curso.exception.ExceptionCourse;
import curso.modelo.Course;

public class Mapper {
    public static Course coreModelMapper(CourseData course) throws ExceptionCourse {
        return Course.Instance(course.getId(),course.getName(),course.getInscriptionDate(), course.getLevel());
    }
    public static CourseData dataModelMapper(Course course)  {
        return new CourseData(course.getId(),course.getName(),course.getInscriptionDate(), course.getLevel());
    }

}
