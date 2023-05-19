package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "ToDo", schema = "dbo")
public class ToDo {

    @Id
    @Column(name = "toDoId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long ToDoId;
    @Column(name = "toDoName")
    private String ToDoName;
    @Column(name = "toDoDetails")
    private String ToDoDetails;
    @Column(name = "toDoStatus")
    private String ToDoStatus;
    @Column(name = "dateCreated")
    private ZonedDateTime DateCreated;
    @Column(name = "endDate")
    private ZonedDateTime EndDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_course_id")
    private Course course;
    public ToDo() {

    }

    public ToDo(Long toDoId, String toDoName, String toDoDetails, String toDoStatus,
                ZonedDateTime dateCreated, ZonedDateTime endDate) {
        ToDoId = toDoId;
        ToDoName = toDoName;
        ToDoDetails = toDoDetails;
        ToDoStatus = toDoStatus;
        DateCreated = dateCreated;
        EndDate = endDate;
    }
}
