package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "course", schema = "dbo")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(length = 60)
    private String name;
    @Column(length = 30)
    private String semester;
    @Column(length = 200)
    private String description;
    @Column(length = 20)
    private String courseStatus;

    @Column(columnDefinition = "TINYINT", length = 1)
    private int isDeleted = 0;

    @ManyToOne
    private User user;

    public Course() {

    }

    public Course(String name, String semester, String description, String courseStatus, User user) {
        this.name = name;
        this.semester = semester;
        this.description = description;
        this.courseStatus = courseStatus;
        this.user = user;
    }
}
