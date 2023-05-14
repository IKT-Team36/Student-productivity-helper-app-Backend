package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class Topic {

    @Id
    private Long TopicId;
    private String Topic;
    private String Content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;

    public Topic() {

    }

    public Topic(Long topicId, String topic, String content) {
        TopicId = topicId;
        Topic = topic;
        Content = content;
    }
}
