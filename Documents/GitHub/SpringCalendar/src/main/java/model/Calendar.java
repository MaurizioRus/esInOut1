package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "calendar")
    private List<Event> events;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

}

