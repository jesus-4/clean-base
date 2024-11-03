package ar.edu.undec.adapter.data.UseCase;

import ar.edu.undec.adapter.data.apidb.CreateCourseCRUD;
import ar.edu.undec.adapter.data.mapper.Mapper;
import ar.edu.undec.adapter.data.entity.CourseData;
import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// En caso de usar de docker mapear puerto, mapear datos para asegurar la persistencia de los datos
@Repository
public class CreateCourseRepository implements Persistence{

    private CreateCourseCRUD createCourseCRUD;

    @Autowired
    CreateCourseRepository(CreateCourseCRUD createCourseCRUD) {
        this.createCourseCRUD = createCourseCRUD;
    }

    @Override
    public boolean saveCourse(Course course) throws ExceptionCourse {
            CourseData courseData = Mapper.dataModelMapper(course);

//            if (createCourseCRUD.findByName(course.getName()))
//                throw new ExceptionCourse("Course Already exist");

            return createCourseCRUD.save(courseData).getId() != null;
    }

    @Override
    public boolean existCourse(String name) {
        return createCourseCRUD.findByName(name);
    }

    @Override
    public ArrayList<Course> getCoursesBylvl(Level lvl) throws ExceptionCourse {
        ArrayList<Course> courses = new ArrayList<>();

        for (CourseData course : createCourseCRUD.findAllByLevel(lvl)) {
            courses.add(Mapper.coreModelMapper(course));
        }

        return courses;
    }
}
