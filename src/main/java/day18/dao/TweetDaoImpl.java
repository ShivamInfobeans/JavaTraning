package day18.dao;

import day18.Tweet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class TweetDaoImpl implements TweetDao {
    @Autowired
    private Session session;

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
    public List<Tweet> fetchTweets(String email) {
        String hql = "from Tweet where email = :email";
        Query query = session.createQuery(hql, Tweet.class);
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