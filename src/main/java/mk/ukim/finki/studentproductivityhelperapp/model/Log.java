package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`log`", schema = "dbo")
public class Log {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    @Column(length = 300)
    private String logContent;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Log() {

    }

    public Log(String logContent, User user, Course course) {
        this.logContent = logContent;
        this.user = user;
        this.course = course;
    }

    public Log(String logContent) {
        this.logContent = logContent;
    }
}
