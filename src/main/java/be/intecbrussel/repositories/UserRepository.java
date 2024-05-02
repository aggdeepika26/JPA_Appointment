package be.intecbrussel.repositories;

import be.intecbrussel.model.Appointment;
import be.intecbrussel.model.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserRepository {
    public void createUser(EntityManager en, User user)
    {
        en.getTransaction().begin();
        en.persist(user);
        en.getTransaction().commit();
    }
    public Optional<User> findUser(EntityManager en, long id )
    {
        User optionalUser = en.find(User.class,id);
        return Optional.ofNullable(optionalUser);

    }


    public void updateUser(EntityManager en, User user)
    {
        en.getTransaction().begin();
        en.merge(user);
        en.getTransaction().commit();
    }
    public void deleteUser(EntityManager en, User user)
    {
        en.getTransaction().begin();
        en.remove(user);
        System.out.println("Record deleted");
        en.getTransaction().commit();
    }
}
