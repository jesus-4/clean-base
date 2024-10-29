package ar.edu.undec.adapter.data.bootstrap;

import curso.usecase.CreateCourse;
import curso.usecase.Persistence;
import curso.usecase.PersistenceCourses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public Persistence CreateCourseInput(CreateCourse repository) {
        return new PersistenceCourses(repository);
    }
    @Bean
    public Persistence existCourseByName(Persistence repository) {
        return new PersistenceCourses(repository);
    }
}
