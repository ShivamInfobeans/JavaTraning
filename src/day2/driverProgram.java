package day2;

public class driverProgram {
    public static void main(String[] args) {
        Student student1 = new Student("name-1","indore");
        Student student2 = new Student("name-2","indore");
        Student student3 = new Student("name-3","indore");
        Student student4 = new Student("name-4","indre");

        Course course = new Course("B.tech");
        Course course1 = new Course("B.E");

        course.addStudent(student1);
        course.addStudent(student2);
        course1.addStudent(student3);
        course1.addStudent(student4);

        System.out.println("Students enrolled in B.tch");
        course.print();





        System.out.println("Students enrolled in cours-2");
        course1.print();
        // course.addStudent


    }
}