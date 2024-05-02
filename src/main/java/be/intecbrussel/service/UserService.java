package be.intecbrussel.service;

import be.intecbrussel.connection.JPAUtil;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.model.User;
import be.intecbrussel.repositories.UserRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    public void createUser(User user)
    {
        EntityManager en = JPAUtil.getEntityManager();
        userRepository.createUser(en,user);
        en.close();
    }

    public Optional<User> findUser(long id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<User> user = userRepository.findUser(en,id);
        en.close();
        return user;
    }
    public void updateUser(User user)

    {
        EntityManager en = JPAUtil.getEntityManager();
        long userId = user.getUserId();
        Optional<User> optionalUser = userRepository.findUser(en,userId);
        if(optionalUser.isEmpty())
        {
            en.close();
            return;
        }
        User oldUser = optionalUser.get();
        oldUser.setFirstName(oldUser.getFirstName());
        oldUser.setLastName(oldUser.getLastName());
        userRepository.updateUser(en,oldUser);
        en.close();
    }
    public void deleteUser(long id)
    {
        EntityManager en = JPAUtil.getEntityManager();
        Optional<User> user = userRepository.findUser(en,id);
        if(user.isPresent()) {
            userRepository.deleteUser(en,user.get());
        }
        else
        {
            System.out.println("Record not found");
        }
        en.close();
    }
}
