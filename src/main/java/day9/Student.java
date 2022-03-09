//package day9;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//
///*
//annotations are meta data information
//Notes or comments on what this class is about
//WE can either use annotations or xml for persistence
//
//Unless you mark a class to be processed by hibernate it won't process it.
//hibernate is ORM it's about mapping classes to tables
//annotations ->
// (i) annotation name
// (ii) annotation property
// property defines the same annotation, think of it as a modifier.
//
//Output of - show create table
// CREATE TABLE `student_records` (
//   `student_id` int NOT NULL AUTO_INCREMENT,
//   `student_name` varchar(255) DEFAULT NULL,
//   PRIMARY KEY (`student_id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//
//CREATE TABLE `student_records` (
//   `student_id` int NOT NULL AUTO_INCREMENT,
//   `student_name` varchar(100) NOT NULL,
//   PRIMARY KEY (`student_id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//
//Q1
//Use a custom generator and plug it into this Student class
//
//Q2:
//(i) create a Person class and map it to person_records table
// (ii) provide an autogeneration strategy for the Id column
// (iii) For the name column -> varchar(200) not null
// (iv) boolean isHired -> false
//  columnDefinition="not null" // exact query or statment that would be used in mysql
//  default
//
// */
//@Entity
//@Table(name = "student_record")
//public class Student {
//    //    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "student_id")
//    private int id;
//    @Column(name = "student_name", nullable = false, length = 100)
//    private String name;
//    private int marks;
//
//
//    public Student(int id, String name, int marks) {
//        this.id = id;
//        this.name = name;
//        this.marks = marks;
//    }
//
//    public Student() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getMarks() {
//        return marks;
//    }
//
//    public void setMarks(int marks) {
//        this.marks = marks;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", marks=" + marks +
//                '}';
//    }
//}