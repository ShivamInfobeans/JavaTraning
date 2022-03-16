package Assignment.Spring.TwitterProject.dao;

import Assignment.Spring.TwitterProject.Tweet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class TweetDaoImpl implements TweetDao {

    private Session session;

    public TweetDaoImpl(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Tweet.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public List<Tweet> readAll() {
        return session.createQuery("from Tweet", Tweet.class).getResultList();

    }

    @Override
    public void create(Tweet tweet) {
        Transaction transaction = session.beginTransaction();
        session.persist(tweet);
        transaction.commit();
    }

    @Override
    public  List<Tweet> fetchTweets(String email) {
        String hql = "from Tweet where email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return query.getResultList();

    }

    @Override
    public void update(Tweet tweet) {

    }

    @Override
    public void delete(Tweet tweet) {

    }
}