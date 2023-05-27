package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;
    @Column(length = 50)
    private String toDoName;
    @Column(length = 100)
    private String toDoDetails;
    @Column(length = 50)
    private String toDoStatus;
    private Date dateCreated;
    private Date endDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public ToDo() {

    }

    public ToDo(String toDoName, String toDoDetails, String toDoStatus, Date dateCreated, Date endDate, User user, Course course) {
        this.toDoName = toDoName;
        this.toDoDetails = toDoDetails;
        this.toDoStatus = toDoStatus;
        this.dateCreated = dateCreated;
        this.endDate = endDate;
        this.user = user;
        this.course = course;
    }
}
