//package day9;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import Utils.Utility;
//
//import java.util.List;
//
///*
//HQL - hibernate query language
//SQL - select * from student
//https://docs.jboss.org/hibernate/orm/6.0/javadocs/org/hibernate/Session.html
//
//Q1:
//write a function that prints out the sum of all values int the marks column.
//
//Q2:
//write a function that prints the number of rows which are having passing marks.
//or marks > 40
//
//
// */
//public class HqlExample {
//    public static void main(String[] args) {
//        pass();
//    }
//
//    private static void insertRecords() {
//        Session session = Utility.getSession();
//        String[] names = new String[]{"student-1","student-2","student-3","student-4"};
//        Transaction transaction = session.beginTransaction();
//        for(int i=0;i<100;i++){
//            Student student = new Student();
//            student.setName(names[(int)(Math.random()*4)]);
//            student.setMarks((int)(Math.random()*100));
//            session.persist(student);
//        }
//        transaction.commit();
//        session.close();
//    }
//
//    private static void fetchRecords(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        List<Student> studentList = session.createQuery("from Student",Student.class).getResultList();
//        System.out.println(studentList);
//    }
//    private static void fetchRecords2(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        Student student = session.get(Student.class,1);
//        System.out.println(student);
//    }
//    private static void fetchRecords3(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        List<Integer> objectList = session.createQuery("select marks from Student",Integer.class).getResultList();
//        System.out.println(objectList);
//    }
//    private static void aggregateFunctions(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        Long numberOfRecords = session.createQuery("select count(*) from Student",Long.class).getSingleResult();
//        System.out.println(numberOfRecords);
//    }
//    private static void aggregateFunctions2(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        Integer numberOfRecords = session.createQuery("select max(marks) from Student",Integer.class).getSingleResult();
//        System.out.println(numberOfRecords);
//    }
//    private static void sum(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        List<Integer> objectList = session.createQuery("select marks from Student",Integer.class).getResultList();
//       Integer sum=0;
//        for (Integer o1:objectList
//             ) {
//            sum=sum+o1;
//        }
//        System.out.println(sum);
//    }
//    private static void pass(){
//        Session session = Utility.getSession();
//        // you change the table name
//        // mysql server, postgres, MS SQL, Oracle Database
//        // the query is smaller
//        List<Object> objectList = session.createQuery("from Student where marks>40",Object.class).getResultList();
//        System.out.println(objectList);
//    }
//}