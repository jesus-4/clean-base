package ar.edu.undec.adapter.data.config;

import curso.input.RegisterCourse;
import curso.usecase.CreateCourse;
import curso.usecase.Persistence;
import curso.usecase.PersistenceCourses;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean(name = "persistenceCourses")
    public Persistence persistence() {
        return new PersistenceCourses();
    }

    @Bean(name = "registerCourse")
    public CreateCourse registerCourse(@Qualifier("persistenceCourses") Persistence persistence) {
        return new RegisterCourse(persistence);
    }
}
