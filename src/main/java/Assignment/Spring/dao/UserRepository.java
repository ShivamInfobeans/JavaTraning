package Assignment.Spring.dao;

import Assignment.Spring.User;

public interface UserRepository {
    User get(int id);
    void add(User user);
    void update(User user);
    void remove(User user);
}