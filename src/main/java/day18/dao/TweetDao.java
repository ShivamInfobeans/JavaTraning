package day18.dao;

import day18.Tweet;

import java.util.List;

public interface TweetDao {
    List<Tweet> readAll();
    void create(Tweet tweet);
    List<Tweet> fetchTweets(String email);
    void update(Tweet tweet);
    void delete(Tweet tweet);
}