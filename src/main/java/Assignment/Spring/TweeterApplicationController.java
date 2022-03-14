package Assignment.Spring;

import Assignment.Spring.dao.TweetDao;
import Assignment.Spring.dao.TweetDaoImpl;
import Assignment.Spring.dao.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/*
POJO - Plain old Java Object
The Database operations and other logic are all there in this
single controller. DAO Pattern 457550 hans vahini school
DAO - Data access object
DAO Pattern  is to decouple the logic of database from the controller.
Its good design practice to separate the Database logic and remaining controller logic
or take out the databse related operations out of the controller.

Benefits
(i) It avoid duplicate code
(ii) Code resuability
(iii) Database related operations are put in a separate class of their own.
So any changes to Dao classes don't affect the classes that use it
(iv) Decouples the Database logic with other logic

Ex:
(i) Do the same for Tweet or other Entity classes you have made
Remove the session variable from the Controller
and fix errors.
Find out all the code which deals with database and move them to a separate class

(ii) Try to make a single Dao interface and make the
UserDaoImpl , TweetDaoImpl implement this single interface.
(If you have other name apart from user or tweet use appropriately)
 */
@Component
@RestController
public class TweeterApplicationController {
    private Map<String, User> userProfile = new HashMap<>();
    private Map<String, Tweet> tw = new HashMap<>();

    private Map<String, List<Tweet>> tweets = new HashMap<>();
    private Map<String, List<String>> following = new HashMap<>();
    private UserDao userDao;
    private TweetDao tweetDao=new TweetDaoImpl();;

    public TweeterApplicationController(TweetDao tweetDao, UserDao userDao) {
        List<User> list = userDao.readAll();
        for (User user : list) {
            userProfile.put(user.getEmail(), user);
        }
        List<Tweet> list1 = tweetDao.readAll();
        for (Tweet tweet: list1)
        {
            tw.put(tweet.getEmail(), tweet);
        }
        System.out.println("ssssssssssssssssssssssss"+tw);
    }

    /*
    Template Engine -> Mustache, JSP, Thymeleaf
     */
    @GetMapping("/displayUserDetails")
    public ModelAndView getUserDetails() {
        ModelAndView modelAndView = new ModelAndView("users");
        if (userProfile.isEmpty())
            allAccDetails();
        List<User> users = new ArrayList<>();
        for (Map.Entry entry : userProfile.entrySet()) {
            users.add((User) entry.getValue());
        }
        System.out.println("aaaaaa"+users);
        modelAndView.getModel().put("users", users);
        return modelAndView;
    }

    @GetMapping("/loginForm")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/getTweets")
    public ModelAndView getTweets(@RequestParam String email) {
        if (!tw.containsKey(email)) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return errorMessageModelAndView("You haven't posted any tweet yet!");
        }
            List<Tweet> tweetList = tweetDao.fetchTweets(email);
        ModelAndView modelAndView = new ModelAndView("tweets");
        System.out.println(tweetList);
        modelAndView.getModel().put("Tweet",tweetList);
        //modelAndView.getModel().put("name",tweetList.get(0).getName());

        return modelAndView;

//    public ModelAndView getTweets(@RequestParam String email) {
//        System.out.println("TRwhadndjshdswd"+email);
//        List<Tweet> tweetList = tweetDao.fetchTweets(email);
//        ModelAndView modelAndView = new ModelAndView("tweets");
//        modelAndView.getModel().put("tweet", tweetList);
//        modelAndView.getModel().put("name", tweetList);
//
//        return modelAndView;

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView login(@RequestBody MultiValueMap<String, String> formData) {
        if (!isUserValid(formData)) {
            return errorMessageModelAndView("Wrong credentials");
        }
        System.out.println("aaaaaaaaaa");
        ModelAndView modelAndView = new ModelAndView("Profile");
        String email = formData.get("email").get(0);
        String name = userProfile.get(email).getName();
        modelAndView.getModel().put("name", name);
        modelAndView.getModel().put("email", email);
        return modelAndView;
    }


    private ModelAndView errorMessageModelAndView(String message) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.getModel().put("message", message);
        return modelAndView;
    }

    private boolean isUserValid(MultiValueMap<String, String> map) {
        String email = map.get("email").get(0);
        String password = map.get("password").get(0);
        User user = userProfile.get(email);
        if (user.getPassword().equals(password))
            return true;
        return false;
    }


    //    User can create an account  -->POST
    @PostMapping("/create")
    @ResponseBody
    private ResponseEntity<String> createUser(@RequestBody User user) {
        ResponseEntity<String> responseEntity = null;
        if (userProfile.containsKey(user.getEmail())) {
            responseEntity = new ResponseEntity<>("User already registered!",
                    HttpStatus.BAD_REQUEST);
        } else {
            String email = user.getEmail();
            userDao.create(user);
            userProfile.put(email, user);
            responseEntity = new ResponseEntity<>("User account created successfully!", HttpStatus.OK);
        }
        return responseEntity;
    }

    //    User can all account details --> GET
    @GetMapping("/fetchUsers")
    @ResponseBody
    Map<String, User> allAccDetails() {
        return userProfile;
    }

    //    User can fetch particular account details --> GET
    @GetMapping("/getDetails")
    @ResponseBody
    private ResponseEntity<User> getAccDetails(@RequestParam String email, String password) {
        ResponseEntity<User> responseEntity = null;
        if (userProfile.containsKey(email)) {
            if (userProfile.get(email).getPassword().equals(password))
                responseEntity = new ResponseEntity<>(userProfile.get(email), HttpStatus.OK);
            else {
                responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                System.out.println("Wrong Password");
            }
        } else {
            responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            System.out.println("User is not registered");
        }
        return responseEntity;
    }

    //    User can update account details  -->PUT
    @PutMapping("/update")
    @ResponseBody
    private ResponseEntity<String> updateRecord(@RequestBody User user) {
        String email = user.getEmail();
        String updatedName = user.getName();
        String password = user.getPassword();
        ResponseEntity<String> responseEntity = null;
        if (password.equals(userProfile.get(email).getPassword())) {
            if (containsInvalidChars(updatedName)) {
                responseEntity = new ResponseEntity<>("name contains invalid characters",
                        HttpStatus.BAD_REQUEST);
            } else if (userProfile.containsKey(email)) {
                String currName = userProfile.get(email).getName();
                if (currName.equals(updatedName)) {
                    responseEntity = new ResponseEntity<>("No change rquired",
                            HttpStatus.OK);
                } else {
                    userProfile.get(email).setName(updatedName);
                    //write update query here
                    responseEntity = new ResponseEntity<>("update successful",
                            HttpStatus.OK);
                }
            } else {
                responseEntity = new ResponseEntity<>("User doesn't exist",
                        HttpStatus.NOT_FOUND);
            }
        } else {
            responseEntity = new ResponseEntity<>("Wrong password",
                    HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    private boolean containsInvalidChars(String name) {
        // name contains any numbers or +-
        return false;
    }


    //    User can delete account  -->DELETE
    @DeleteMapping("/delete")
    @ResponseBody
    private ResponseEntity<String> deleteRecord(@RequestParam String email, String password) {
        ResponseEntity<String> responseEntity = null;
        if (userProfile.containsKey(email)) {
            if (userProfile.get(email).getPassword().equals(password)) {
                //write delete query here
                responseEntity = new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
                userProfile.remove(email);
            } else {
                responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                System.out.println("Wrong Password");
            }
        } else {
            responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            System.out.println("User is not registered");
        }
        return responseEntity;
    }

    //User can create tweet -->POST
    @PostMapping("/createTweet")
    @ResponseBody
    ResponseEntity<String> createTweet(@RequestBody Tweet tweet, @RequestParam String password) {
        ResponseEntity<String> responseEntity = null;
        String email = tweet.getEmail();
        if (userProfile.containsKey(email)) {
            if (userProfile.get(email).getPassword().equals(password)) {
                if (tweets.containsKey(email))
                    tweets.get(email).add(tweet);
                else {
                    List<Tweet> list = new ArrayList<>();
                    list.add(tweet);
                    tweets.put(email, list);
                }
                tweetDao.create(tweet);
                responseEntity = new ResponseEntity<>("Tweet added successfully", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>("Wrong Password", HttpStatus.BAD_REQUEST);
            }
        } else {
            responseEntity = new ResponseEntity<>("User is not registered", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //user can see all tweets
    @GetMapping("/fetchTweets")
    @ResponseBody
    Map<String, List<Tweet>> fetchTweets() {
        List<Tweet> list = tweetDao.readAll();
        for (Tweet tweet : list) {
            if (tweets.containsKey(tweet.getEmail())) {
                tweets.get(tweet.getEmail()).add(tweet);
            } else {
                List<Tweet> tweetList = new ArrayList<>();
                tweetList.add(tweet);
                tweets.put(tweet.getEmail(), tweetList);
            }
        }
        return tweets;
    }

    //user can see tweets from a particular account
    @GetMapping("/fetchTweetsOfUser")
    @ResponseBody
    List<Tweet> fetchTweetsOfUser(@RequestParam String email) {
        return tweets.get(email);
    }

    //user can follow another user
    @PostMapping("/followUser")
    @ResponseBody
    private ResponseEntity<String> followUsers(@RequestParam String email, String userEmail) {
        ResponseEntity<String> responseEntity = null;
        if (!userProfile.containsKey(email)) {
            responseEntity = new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        if (userEmail.equals(email)) {
            responseEntity = new ResponseEntity<>("You can't follow yourself", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        if (userProfile.get(userEmail) != null) {
            if (following.containsKey(email)) {
                following.get(email).add(userEmail);
            } else {
                List<String> list = new ArrayList<>();
                list.add(userEmail);
                following.put(email, list);
            }
            responseEntity = new ResponseEntity<>("User " + userEmail + " followed successfully"
                    , HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("User you are following doesn't exist"
                    , HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //to view following of a user
    @GetMapping("/follow")
    @ResponseBody
    private List<String> following(@RequestParam String email) {
        if (following.containsKey(email))
            return following.get(email);
        else
            return Arrays.asList("User doesn't follow anyone");
    }

}