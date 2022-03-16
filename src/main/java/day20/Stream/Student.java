package day20.Stream;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int marks;
   public static List<Integer> l1=new ArrayList<>();
    public int getMarks() {
        return marks;
    }
public Student(){}
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Student(int marks) {
        l1.add(marks);
        this.marks = marks;
    }
}
