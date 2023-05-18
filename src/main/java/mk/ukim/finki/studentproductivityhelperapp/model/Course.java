package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
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

    @ManyToOne
    private User user;

    public Course() {

    }

}
