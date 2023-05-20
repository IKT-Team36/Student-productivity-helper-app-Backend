package mk.ukim.finki.studentproductivityhelperapp.model.dto;


import lombok.Data;


@Data
public class NoteDto {

    private String noteContent;
    private Long user;
    private Long course;

    public NoteDto(String noteContent, Long user, Long course) {
        this.noteContent = noteContent;
        this.user = user;
        this.course = course;
    }
}
