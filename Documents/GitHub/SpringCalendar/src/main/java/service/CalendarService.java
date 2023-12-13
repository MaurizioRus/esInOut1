package service;
import Repository.CalendarRepository;
import model.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    public Optional<Calendar> getCalendarById(Long calendarId) {
        return calendarRepository.findById(calendarId);
    }

    public Calendar createCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Calendar updateCalendar(Long calendarId, Calendar updatedCalendar) {
        if (calendarRepository.existsById(calendarId)) {
            updatedCalendar.setId(calendarId);
            return calendarRepository.save(updatedCalendar);
        } else {
            return null;
        }
    }

    public void deleteCalendar(Long calendarId) {
        calendarRepository.deleteById(calendarId);
    }
}
