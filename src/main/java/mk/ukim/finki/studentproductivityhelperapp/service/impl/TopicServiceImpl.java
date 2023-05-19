package mk.ukim.finki.studentproductivityhelperapp.service.impl;


import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import mk.ukim.finki.studentproductivityhelperapp.repositoryNote.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements mk.ukim.finki.studentproductivityhelperapp.service.TopicService {

    @Autowired
    private TopicRepository topicRepository;


    @Override
    public Topic getById(Long id) {
        return this.topicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
    }

    @Override
    public List<Topic> getAll() {
        return this.topicRepository.findAll();
    }

    @Override
    public Topic create(Topic Topic) {
        return this.topicRepository.save(Topic);
    }

    @Override
    public Topic edit(Long id, Topic Topic) {
        return null;
    }

    @Override
    public void delete(Topic Topic) {
        this.topicRepository.delete(Topic);
    }
}
