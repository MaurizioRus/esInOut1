package service;

import Repository.EventRepository;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long eventId, Event updatedEvent) {
        if (eventRepository.existsById(eventId)) {
            updatedEvent.setId(eventId);
            return eventRepository.save(updatedEvent);
        } else {
            return null;
        }
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
