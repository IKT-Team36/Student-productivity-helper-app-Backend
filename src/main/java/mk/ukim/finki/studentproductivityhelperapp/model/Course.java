package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CourseId;
    @Column(length = 60)
    private String Name;
    @Column(length = 30)
    private String Semester;
    @Column(length = 200)
    private String Description;
    @Column(length = 20)
    private String CourseStatus;

    @ManyToOne
    private User user;

    public Course() {

    }

}
