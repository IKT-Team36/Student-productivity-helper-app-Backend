package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.TopicDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.TopicNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.repository.TopicRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public TopicServiceImpl(TopicRepository topicRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Topic> save(TopicDto topicDto) {
        User user = this.userRepository.findById(topicDto.getUser()).orElseThrow(()->new UserNotFoundException(topicDto.getUser()));

        this.topicRepository.deleteByTopic(topicDto.getTopic());
        return Optional.of(this.topicRepository.save(new Topic(
                topicDto.getTopic(),topicDto.getContent(),user)));
    }

    @Override
    public Optional<Topic> edit(Long topicId, TopicDto topicDto) {
        Topic topic = this.topicRepository.findById(topicId).orElseThrow(()-> new TopicNotFoundException(topicId));
        topic.setTopic(topicDto.getTopic());
        topic.setContent(topicDto.getContent());
        User user = this.userRepository.findById(topicDto.getUser()).orElseThrow(()->new UserNotFoundException(topicDto.getUser()));
        topic.setUser(user);
        return Optional.of(this.topicRepository.save(topic));
    }

    @Override
    public void deleteById(Long topicId) {
        this.topicRepository.deleteById(topicId);
    }

    @Override
    public List<Topic> listTopics() {
        return this.topicRepository.findAll();
    }

    @Override
    public List<Topic> searchTopics(String topic) {
        return this.searchTopics(topic);
    }

    @Override
    public Optional<Topic> findById(Long topicId) {
        return this.topicRepository.findById(topicId);
    }
}
