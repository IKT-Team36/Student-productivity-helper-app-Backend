package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;
    @Column(length = 500)
    private String noteContent;
    private ZonedDateTime dateModified;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Note() {

    }

    public Note(String noteContent, ZonedDateTime dateModified) {
        this.noteContent = noteContent;
        this.dateModified = dateModified;
    }

    public Note(String noteContent, ZonedDateTime dateModified, User user, Course course) {
        this.noteContent = noteContent;
        this.dateModified = dateModified;
        this.user = user;
        this.course = course;
    }
}
