package ar.edu.undec.adapter.data.entity;

import curso.modelo.Level;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Course")
public class CourseData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha Inscripcion")
    private LocalDate inscriptionDate;
    @Column(name = "nivel")
    private Level level;

//    @OneToMany
//    private InscriptionData inscription;
    public CourseData() {}

    public CourseData(UUID id, String name, LocalDate inscriptionDate, Level level) {
        this.id = id;
        this.name = name;
        this.inscriptionDate = inscriptionDate;
        this.level = level;
    }

    public UUID getId() {
        return id;
    }

    public CourseData setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseData setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public CourseData setInscriptionDate(LocalDate inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public CourseData setLevel(Level level) {
        this.level = level;
        return this;
    }
    public static CourseData fromDomain(CourseData courseData){
        return new CourseData(courseData.getId(), courseData.getName(), courseData.getInscriptionDate(), courseData.getLevel());
    }
}
