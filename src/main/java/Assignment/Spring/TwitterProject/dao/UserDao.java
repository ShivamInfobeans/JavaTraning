package Assignment.Spring.TwitterProject.dao;

import Assignment.Spring.TwitterProject.User;
import org.springframework.stereotype.Component;

import java.util.List;

/*
UserDAO -> USer Data access Object
Basically this interface is used to access data from the USer table

 */
@Component
public interface UserDao {
    List<User> readAll();
    void create(User user);
    User readById(int id);
    void update(User user);
    void delete(User user);
}