package controller;

import model.User;
import service.EventService;
import org.springframework.http.ResponseEntity;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId).orElse(null);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }


    @PostMapping("/{eventId}/invite")
    public ResponseEntity<String> inviteParticipants(@PathVariable Long eventId, @RequestBody List<Long> participantIds) {
        Event event = eventService.getEventById(eventId).orElse(null);

        if (event != null) {
            List<User> participants = userService.getAllUsersById(participantIds);

            if (participants.size() == participantIds.size()) {
                event.getParticipants().addAll(participants);
                eventService.createEvent(event);

                return ResponseEntity.ok("Inviti inviati con successo");
            } else {
                return ResponseEntity.badRequest().body("Uno o più utenti non esistono");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

