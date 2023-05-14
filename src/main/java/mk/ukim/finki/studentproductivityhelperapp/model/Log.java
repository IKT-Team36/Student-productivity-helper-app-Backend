package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
