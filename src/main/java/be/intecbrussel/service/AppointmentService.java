package be.intecbrussel.service;

import be.intecbrussel.connection.JPAUtil;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.repositories.AppointmentRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AppointmentService {
    private AppointmentRepository appointmentRepository = new AppointmentRepository();
    public void createAppointment(Appointment appointment)
    {
        EntityManager en = JPAUtil.getEntityManager();
        appointmentRepository.createAppointment(en,appointment);
        en.close();
    }
    public Optional<Appointment> findAppointment(long id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<Appointment> appointment = appointmentRepository.findAppointment(en,id);
        en.close();
        return appointment;
    }
    public void updateAppointment(Appointment appointment)

    {
        EntityManager en = JPAUtil.getEntityManager();
        long appointmentId = appointment.getId();
        Optional<Appointment> optionalAppointment = appointmentRepository.findAppointment(en,appointmentId);
        if(optionalAppointment.isEmpty())
        {
            en.close();
            return;
        }
        Appointment oldAppointment = optionalAppointment.get();
        oldAppointment.setAppointmentDate(oldAppointment.getAppointmentDate());
        oldAppointment.setAppointmentTime(oldAppointment.getAppointmentTime());
        appointmentRepository.updateAppointment(en,oldAppointment);
        en.close();
    }
    public void deleteAppointment(long id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<Appointment> appointment = appointmentRepository.findAppointment(en,id);
        if(appointment.isPresent()) {
            appointmentRepository.deleteAppointment(en,appointment.get());
        }
        else
        {
            System.out.println("Record not found");
        }
        en.close();
    }






}
