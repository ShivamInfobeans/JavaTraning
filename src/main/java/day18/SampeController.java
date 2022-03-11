package day18;

import day18.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampeController {
    @Autowired
    private UserDao userDao;


    @GetMapping("/testing")
    public void test(){
        userDao.readAll();

    }
}