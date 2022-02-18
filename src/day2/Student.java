package day2;
/*
Student, Course, Faculty
Association.
There is an association between the student class and the course class.
There is an association between the course class and student class.
 */

public class Student {
    private Course[] courses;
    private String name;
    private  String Address;
    Student(String _name,String Add)
    {
        name=_name;
        Address=Add;
    }
    private void addCourse(Course c){

    }
    public void print() {
        System.out.println("List of all students int the course");

        System.out.println(name);
    }
    public String getName(){
        return name;
    }
}