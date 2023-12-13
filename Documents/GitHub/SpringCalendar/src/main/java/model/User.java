package model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Calendar> calendars;

    @ManyToMany(mappedBy = "participants")
    private List<Event> eventsParticipated;

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
