package ar.edu.undec.adapter.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Level;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDTO {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("inscription_deadline")
    private LocalDate description;
    @JsonProperty("level")
    private Level level;

    public CourseDTO(UUID id, String name, LocalDate description, Level level) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
    }
    public UUID getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public LocalDate getDescription() {
        return this.description;
    }
    public Level getLevel() {
        return this.level;
    }

//    public static Couese
}
