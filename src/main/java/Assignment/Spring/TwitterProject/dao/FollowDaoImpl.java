package Assignment.Spring.TwitterProject.dao;
import Assignment.Spring.TwitterProject.Follow;
import Assignment.Spring.TwitterProject.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class FollowDaoImpl implements FollowDao {
    private Session session;
   public FollowDaoImpl(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Follow.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    @Override
    public List<Follow> readAll() {
      return   session.createQuery("from Follow", Follow.class).getResultList();
    }

    @Override
    public List<Follow> readByEmail(String email) {
        String hql = "from Follow where email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public void create(Follow follow) {
        Transaction transaction = session.beginTransaction();
        session.persist(follow);
        transaction.commit();
    }
}