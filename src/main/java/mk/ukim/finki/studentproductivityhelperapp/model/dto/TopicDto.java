package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.studentproductivityhelperapp.model.User;

@Data
public class TopicDto {

    private Long topicId;

    private String topic;

    private String content;

    private Long user;

    public TopicDto() {

    }

    public TopicDto(String topic, String content, Long user) {
        this.topic = topic;
        this.content = content;
        this.user = user;
    }
}
