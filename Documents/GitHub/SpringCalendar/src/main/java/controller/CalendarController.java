package controller;

import service.CalendarService;
import model.Calendar;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @GetMapping
    public List<Calendar> getAllCalendars() {
        return calendarService.getAllCalendars();
    }

    @GetMapping("/{calendarId}")
    public Calendar getCalendarById(@PathVariable Long calendarId) {
        return calendarService.getCalendarById(calendarId).orElse(null);
    }

    @PostMapping
    public Calendar createCalendar(@RequestBody Calendar calendar) {
        return calendarService.createCalendar(calendar);
    }

    @PutMapping("/{calendarId}")
    public Calendar updateCalendar(@PathVariable Long calendarId, @RequestBody Calendar updatedCalendar) {
        return calendarService.updateCalendar(calendarId, updatedCalendar);
    }

    @DeleteMapping("/{calendarId}")
    public void deleteCalendar(@PathVariable Long calendarId) {
        calendarService.deleteCalendar(calendarId);
    }

    @PostMapping("/{calendarId}/events")
    public Event createEventForCalendar(@PathVariable Long calendarId, @RequestBody Event event) {
        Calendar calendar = calendarService.getCalendarById(calendarId).orElse(null);
        if (calendar != null) {
            event.setCalendar(calendar);
            EventController eventService = null;
            return eventService.createEvent(event);
        } else {
            return null;
        }
    }
}


