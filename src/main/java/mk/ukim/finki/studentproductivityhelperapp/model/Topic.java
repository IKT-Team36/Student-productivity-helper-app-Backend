package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    @Column(length = 100)
    private String topic;
    @Column(length = 150)
    private String content;
    @ManyToOne
    private User user;
    public Topic() {

    }

    public Topic(String topic, String content, User user) {
        this.topic = topic;
        this.content = content;
        this.user = user;
    }

    public Topic(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }
}
