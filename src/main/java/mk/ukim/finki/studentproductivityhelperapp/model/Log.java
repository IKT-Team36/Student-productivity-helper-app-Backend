package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`log`", schema = "dbo")
public class Log {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LogId;
    @Column(length = 300)
    private String LogContent;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Log() {

    }

    public Log(Long logId, Long logContent) {
        LogId = logId;
        LogContent = String.valueOf(logContent);
    }
}
