package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Topic", schema = "dbo")
public class Topic {

    @Id
    @Column(name = "topicId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long TopicId;
    @Column(name = "topic")
    private String Topic;
    @Column(name = "content")
    private String Content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_course_id")
    private Course course;

    public Topic() {

    }

    public Topic(Long topicId, String topic, String content) {
        TopicId = topicId;
        Topic = topic;
        Content = content;
    }
}
