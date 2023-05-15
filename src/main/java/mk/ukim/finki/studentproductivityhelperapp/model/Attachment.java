package mk.ukim.finki.studentproductivityhelperapp.model;



import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttachmentId;
    @Column(length = 30)
    private String Name;
    private ZonedDateTime Date;
    @Column(length = 50)
    private String Subject;
    @Column(length = 50)
    private String Type;
    @Column(length = 500)
    private String ByteContent;
    @ManyToOne
    private User user;
    public Attachment() {

    }

    public Attachment(Long attachmentId, String name, ZonedDateTime date,
                      String subject, String type, String byteContent) {
        AttachmentId = attachmentId;
        Name = name;
        Date = date;
        Subject = subject;
        Type = type;
        ByteContent = byteContent;
    }
}
