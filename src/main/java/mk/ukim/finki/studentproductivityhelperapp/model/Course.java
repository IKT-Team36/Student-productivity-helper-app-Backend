package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;


@Data
@Entity
public class Course {

    @Id
    private Long CourseId;
    private String Name;
    private String Semester;
    private String Description;
    private String CourseStatus;

    @ManyToOne
    private User user;
    @OneToMany
    private List<Topic> topics;
    @OneToMany
    private List<Event> events;
    @OneToMany
    private List<Log> logs;
    @OneToMany
    private List<Attachment> attachments;
    @OneToMany
    private List<Note> notes;
    @OneToMany
    private List<ToDo> toDos;
    @OneToMany
    private List<ChatGPT> chatGPTSummaryList;

    public Course() {

    }

    public Course(Long courseId, String name, String semester,
                  String description, String courseStatus) {
        CourseId = courseId;
        Name = name;
        Semester = semester;
        Description = description;
        CourseStatus = courseStatus;
    }
}
