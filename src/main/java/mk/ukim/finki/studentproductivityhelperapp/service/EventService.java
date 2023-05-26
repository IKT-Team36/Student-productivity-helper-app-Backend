package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Event;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();
    Optional<Event> findById(Long id);
    Optional<Event> save(EventDto eventDto);
    Optional<Event> edit(Long id, EventDto eventDto);
    void delete(Long id);
}
