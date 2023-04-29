package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
