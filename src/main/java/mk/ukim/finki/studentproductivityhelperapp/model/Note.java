package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;
    @Column(length = 500)
    private String noteContent;
    private Date dateModified;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Note() {

    }

    public Note(String noteContent, Date dateModified) {
        this.noteContent = noteContent;
        this.dateModified = dateModified;
    }

    public Note(String noteContent, Date dateModified, User user, Course course) {
        this.noteContent = noteContent;
        this.dateModified = dateModified;
        this.user = user;
        this.course = course;
    }
}
