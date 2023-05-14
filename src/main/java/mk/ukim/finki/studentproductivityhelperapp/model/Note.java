package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Data
@Entity
public class Note {

    @Id
    private Long NoteId;
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
