package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Log {

    @Id
    private Long LogId;
    private Long LogContent;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Log() {

    }

    public Log(Long logId, Long logContent) {
        LogId = logId;
        LogContent = logContent;
    }
}
