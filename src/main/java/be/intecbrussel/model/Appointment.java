package be.intecbrussel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment_Info")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_Id")
    private long id;
    private String title;
    private String description;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    private User user;

    public Appointment()
    {

    }

    public Appointment(long id, String title, String description, LocalDate appointmentDate, LocalTime appointmentTime, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.user = user;
    }

    public Appointment(String title, String description, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.title = title;
        this.description = description;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Appointment(long id, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", user=" + user +
                '}';
    }
}

