package ar.edu.undec.adapter.data.config;

import curso.input.RegisterCourse;
import curso.usecase.CreateCourse;
import curso.usecase.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateCourse registerCourse(Persistence persistence) {
        return new RegisterCourse(persistence);
    }
}
