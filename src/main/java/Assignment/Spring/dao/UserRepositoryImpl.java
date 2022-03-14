package Assignment.Spring.dao;

import Assignment.Spring.Tweet;
import Assignment.Spring.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private UserDao userDao;
    @Autowired
    private TweetDao tweetDao;
    @Override
    public User get(int id) {
        User user = userDao.readById(id);
        List<Tweet> tweetList=tweetDao.fetchTweets(user.getEmail());
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }
}