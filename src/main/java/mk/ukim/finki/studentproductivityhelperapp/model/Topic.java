package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TopicId;
    @Column(length = 100)
    private String Topic;
    @Column(length = 150)
    private String Content;
    @ManyToOne
    private User user;
    public Topic() {

    }

    public Topic(Long topicId, String topic, String content) {
        TopicId = topicId;
        Topic = topic;
        Content = content;
    }
}
