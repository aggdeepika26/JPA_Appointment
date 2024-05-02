package be.intecbrussel.repositories;

import be.intecbrussel.connection.JPAUtil;
import be.intecbrussel.model.Appointment;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AppointmentRepository {
    public void createAppointment(EntityManager en, Appointment appointment)
    {
      en.getTransaction().begin();
      en.merge(appointment);       //persist() werkt niet detatch entity persist error geeft
      en.getTransaction().commit();
    }
    public Optional<Appointment> findAppointment(EntityManager en, long id )
    {
       Appointment optionalAppointment = en.find(Appointment.class,id);
        return Optional.ofNullable(optionalAppointment);

    }
    public void updateAppointment(EntityManager en, Appointment appointment)
    {
        en.getTransaction().begin();
        en.merge(appointment);
        en.getTransaction().commit();
    }
    public void deleteAppointment(EntityManager en, Appointment appointment)
    {
        en.getTransaction().begin();
        en.remove(appointment);
        System.out.println("Record deleted");
        en.getTransaction().commit();
    }












}
