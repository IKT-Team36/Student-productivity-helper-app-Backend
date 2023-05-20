package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.Event;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.EventDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.EventNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserIdDoesNotExistException;
import mk.ukim.finki.studentproductivityhelperapp.repository.CourseRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.EventRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.of(this.eventRepository.getReferenceById(id));
    }

    @Override
    public Optional<Event> save(EventDto eventDto) {
        User user = this.userRepository.findById(eventDto.getUser())
                .orElseThrow(() -> new UserIdDoesNotExistException(eventDto.getUser()));
        Course course = this.courseRepository.findById(eventDto.getCourse())
                .orElseThrow(() -> new CourseNotFoundException(eventDto.getCourse()));
        Event event = new Event(eventDto.getEventName(), eventDto.getEventLocation(), eventDto.getEventDate(),
                user, course);
        System.out.println(event);
        this.eventRepository.save(event);
        return Optional.of(event);
    }

    @Override
    public Optional<Event> edit(Long id, EventDto eventDto) {
        Event event = this.eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        event.setEventDate(eventDto.getEventDate());
        event.setEventLocation(eventDto.getEventLocation());
        this.eventRepository.save(event);
        return Optional.of(event);
    }

    @Override
    public void delete(Long id) {
        Event event = this.eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        this.eventRepository.delete(event);
    }
}
