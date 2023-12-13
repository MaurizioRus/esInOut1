package model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @ManyToMany
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public String getTitle() {
        return title;
    }
}