package day18.dao;

import day18.Tweet;
import day18.User;
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