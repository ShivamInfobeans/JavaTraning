package day20;

public class TweetNotFoundException extends Throwable {
    public TweetNotFoundException()
    {
        System.out.println("Tweet Not Found");
            }
}