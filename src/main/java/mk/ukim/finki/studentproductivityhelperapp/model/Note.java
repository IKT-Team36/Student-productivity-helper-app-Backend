package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NoteId;
    @Column(length = 500)
    private String NoteContent;
    private ZonedDateTime DateModified;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Note() {

    }

    public Note(Long noteId, String noteContent, ZonedDateTime dateModified) {
        NoteId = noteId;
        NoteContent = noteContent;
        DateModified = dateModified;
    }
}
