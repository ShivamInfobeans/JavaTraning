package day20;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tweet {
    /*
    without using properties file
    (i) Modify the code
    (ii) push the code to github
    (iii) Compile the project
    (iv) Deploy the application again


    With using properties file
    (i) Modify the properties file and restart the application
     */
    private String url="adasdad";
    @Value("${logging.directory}")
    private String loggingDirectory;

}