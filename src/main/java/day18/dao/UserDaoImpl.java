package day18.dao;

import day18.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private Session session;

    @Override
    public List<User> readAll() {
        return session.createQuery("from users", User.class).getResultList();
    }

    @Override
    public void create(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public User readById(int id) {
        Query query = session.createQuery("from users where id=:id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();

    }

    @Override
    public void update(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(User user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}