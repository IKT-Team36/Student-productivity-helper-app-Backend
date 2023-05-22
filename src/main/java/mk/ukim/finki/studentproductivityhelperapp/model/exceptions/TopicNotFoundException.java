package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class TopicNotFoundException extends RuntimeException{
    public TopicNotFoundException(Long topicId) {
        super(String.format("Topic with topic_id: %s already exists", topicId));
    }
}
