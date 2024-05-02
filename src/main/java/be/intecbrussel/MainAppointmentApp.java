package be.intecbrussel;

import be.intecbrussel.model.Appointment;
import be.intecbrussel.model.User;
import be.intecbrussel.service.AppointmentService;
import be.intecbrussel.service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class MainAppointmentApp {
    public static void main(String[] args) {
        AppointmentService appointmentService = new AppointmentService();
        UserService userService = new UserService();

        Appointment appointment1 = new Appointment("Title1","Description1", LocalDate.of(2024,5,10), LocalTime.of(10,00));
        Appointment appointment2 = new Appointment("Title2","Description2", LocalDate.of(2024,5,10), LocalTime.of(11,00));
        Appointment appointment3 = new Appointment("Title3","Description3", LocalDate.of(2024,5,10), LocalTime.of(13,00));
        Appointment appointment4 = new Appointment("Title4","Description4", LocalDate.of(2024,5,10), LocalTime.of(15,00));
        Appointment appointment5 = new Appointment("Title5","Description5", LocalDate.of(2024,5,10), LocalTime.of(13,00));
        Appointment appointment6 = new Appointment("Title6","Description6", LocalDate.of(2024,5,10), LocalTime.of(15,00));

        User user1 = new User("U1_F_Name","U1_L_Name");
        User user2 = new User("U2_F_Name","U2_L_Name");
        User user3 = new User("U3_F_Name","U3_L_Name");
        User user4 = new User("U4_F_Name","U4_L_Name");
        User user5 = new User("U5_F_Name","U5_L_Name");
        User user6 = new User("U6_F_Name","U6_L_Name");


        //set appointment with user(onetoone relationship)
        appointment1.setUser(user2);
        appointment2.setUser(user3);
        appointment3.setUser(user4);
        appointment4.setUser(user1);
        appointment5.setUser(user5);
        appointment6.setUser(user6);


        // Create User
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);


        //create an appointment
        appointmentService.createAppointment(appointment1);
        appointmentService.createAppointment(appointment2);
        appointmentService.createAppointment(appointment3);
        appointmentService.createAppointment(appointment4);
        appointmentService.createAppointment(appointment5);
        appointmentService.createAppointment(appointment6);

        //Find Appointment

        Optional<Appointment> appointment = appointmentService.findAppointment(1);
        if (appointment.isPresent())
        {
            System.out.println(appointment.get());
        }
        else
        {
            System.out.println("No appointment with this id");
        }


        //Find User
        Optional<User> user = userService.findUser(1);
        if (user.isPresent())
        {
            System.out.println(user.get());
        }
        else
        {
            System.out.println("No user with this id");
        }

        //Update Appointment

        Appointment newAppointmentDate = new Appointment(3,LocalDate.of(2024,5,15),LocalTime.of(14,0));
        appointmentService.updateAppointment(newAppointmentDate);

        //Update User
         User newUserNaam = new User(3,"Raj","Sharma");
         userService.updateUser(newUserNaam);


        //Delete Appointment
        appointmentService.deleteAppointment(4);


        //Delete User(I can not delete from child class)
        // userService.deleteUser(4);











    }
}
