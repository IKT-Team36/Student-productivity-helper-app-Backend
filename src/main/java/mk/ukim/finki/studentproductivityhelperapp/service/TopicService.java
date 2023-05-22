package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.AttachmentDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.TopicDto;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    Optional<Topic> save(TopicDto topicDto);

    Optional<Topic> edit(Long topicId, TopicDto topicDto);


    void deleteById(Long topicId);
    List<Topic> listTopics();
    List<Topic> searchTopics(String topic);

    Optional<Topic> findById(Long topicId);
}
