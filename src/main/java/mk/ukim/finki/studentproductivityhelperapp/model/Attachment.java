package mk.ukim.finki.studentproductivityhelperapp.model;



import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;
    @Column(length = 30)
    private String name;
    private ZonedDateTime date;
    @Column(length = 50)
    private String subject;
    @Column(length = 50)
    private String type;
    @Column(length = 500)
    private String byteContent;
    @ManyToOne
    private User user;
    public Attachment() {

    }

    public Attachment(String name, ZonedDateTime date, String subject, String type, String byteContent) {
        this.name = name;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.byteContent = byteContent;
    }

    public Attachment(String name, ZonedDateTime date, String subject, String type, String byteContent, User user) {
        this.name = name;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.byteContent = byteContent;
        this.user = user;
    }
}
