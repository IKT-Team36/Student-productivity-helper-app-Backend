package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "Note", schema = "dbo")
public class Note {

    @Id
    @Column(name = "noteId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long NoteId;
    @Column(name = "noteContent")
    private String NoteContent;
    @Column(name = "dateModified")
    private ZonedDateTime DateModified;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_course_id")
    private Course course;
    public Note() {

    }

    public Note(String noteContent, ZonedDateTime dateModified) {
        this.NoteContent = noteContent;
        this.DateModified = dateModified;
    }

    public Note(String noteContent, ZonedDateTime dateModified, User user, Course course) {
        this.NoteContent = noteContent;
        this.DateModified = dateModified;
        this.user = user;
        this.course = course;
    }
}
