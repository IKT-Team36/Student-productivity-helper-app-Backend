package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Topic;

import java.util.List;

public interface TopicService {

    public Topic getById(Long id);

    public List<Topic> getAll();

    public Topic create(Topic topic);

    public Topic edit(Long id, Topic topic);

    void delete(Topic topic);
}
