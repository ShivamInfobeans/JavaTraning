package Assignment.Spring.TwitterProject.dao;
import Assignment.Spring.TwitterProject.Follow;

import java.util.List;

public interface FollowDao {
    List<Follow> readAll();
    void create(Follow follow);
    List<Follow> readByEmail(String email);
}