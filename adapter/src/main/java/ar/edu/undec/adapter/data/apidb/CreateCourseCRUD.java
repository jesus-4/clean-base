package ar.edu.undec.adapter.data.apidb;

import ar.edu.undec.adapter.data.entity.CourseData;

import curso.modelo.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository                              // clase entidad - tipo dato id
public interface CreateCourseCRUD extends CrudRepository<CourseData, UUID> {
    boolean findByName(String name);
    ArrayList<CourseData> findAllByLevel(Level level);
}
