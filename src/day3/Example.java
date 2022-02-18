package day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Example {
    public static void main(String[] args) {
        Date date1 = new Date(2022,1,1);
        Date date2 = new Date(2022,3,1);
        System.out.println(date1.compareTo(date2));
        // -1 <0 date1 occurs before date2
        String[] states = {"karnataka", "haryana","maharashtra","arunachal"};
        Arrays.sort(states); // String class implements compareTo method.
        for(String state: states)
            System.out.println(state);
        Student[] students = {new Student("name-1",100), new Student("name-2",200), new Student("name-3",150),
                new Student("name-4",1)};
        Arrays.sort(students);
        for(Student student:students)
            System.out.println(student.getName() + ", "+student.getRollNumber());
    }
}