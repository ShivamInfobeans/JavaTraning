//package day3;
//
//import static com.sun.xml.internal.ws.util.VersionUtil.compare;
//
//public class Student implements Comparable{
//    private String name;
//    private int rollNumber;
//
//    public Student(String name, int rollNumber) {
//        this.name = name;
//        this.rollNumber = rollNumber;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getRollNumber() {
//        return rollNumber;
//    }
//
//    public void setRollNumber(int rollNumber) {
//        this.rollNumber = rollNumber;
//    }
//
//    @Override
////    public int compareTo(Object o) {
////        Student student  = (Student) o;
////        return Integer.compare(rollNumber,student.getRollNumber());
////    }
//    // write a compareTo function which sorts the student array by name instead of roll number
//    public int compareTo(Object o) {
//        Student student  = (Student) o;
//        return String.CASE_INSENSITIVE_ORDER.compare(name, student.getName());
//    }
//}