//package day8;
//
//import day8.Product1;
//import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import javax.management.Query;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//(i) Create a new class Student(id,name,rollno,university) and insert some entries into it using
//the increment generator. (4-5)
//(ii) write a separate statement to Query all the records in the Student table and fetch them in a list.
//and print out the result.
//(iii) write your own CustomIdGenerator which generates a random 5 digit number
//
//(iv) create a new class Car with the following properties:
//Integer id, Double speed, String name, Float horsePower, Character maker,
//Boolean isHatchBack, Long carNumber
//I have included all the primitive data types/wrapper
//
//(v) Create a Student class
//Integer id;
//List<Integer> marks;
//There is direct mapping available between a List and any table column
//example marks = [10, 20, 30]
//Store it as a comma separated string in the table.
//new Student(10,Arrays.asList(10,20,30))
//In the Student table there should be 2 colmsn id and marks
//id-> int
//marks-> varchar
//you need to convert the List<Integer> to a String
//String s = "10, 20,30" and store this string in the table instead of the List<Integer>
//setMarks and getMarks <-- modify these two methods
//setMarks(String marks)  <-- convert String to a list of integer
//String getMarks() -> convert the list to String
//
// */
///*
//Note:
//*) If you want to give wrapper classes instead of the primitive data types
// you need to provide the fully qualified class name.
// Like for Integer you should specify - java.lang.Integer
//
//C - create <--created a table and inserted data into it
//R - read <-- createQuery("from {table-name}")
//U - update <--
//D - delete <--
//
//Q--) Create a table Product with
//id,
//name,
//amount
//User hibernate CRUD operations to do the following:
//1) Insert dummy data into it
//    (i) include data with amount <0
//    (ii) include data with amount = 1 ,2 3
//    (iii) include data with amount = 100, 200, 300
//2) print all the entries which has amount > 100
//3) update the entries which has amount < 0 to amount =10
//4) delete all entries which has amount <10
//    and print out the entries
// */
//public class CrudExample {
//    public static void main(String[] args) {
//      //  insertData();
//abc();
//    }
//    // R
//    private static void readExample() {
//        Session session = getSession();
//        List<Product1> product1List = session.createQuery("from Product1 P where P.amount<100",Product1.class).getResultList();
//
//        System.out.println(product1List);
//    }
//    private  static  void abc()
//    {
//        Session session = getSession();
//        Product1 product;
//        List<Product1> product1List = session.createQuery("from Product1 P where P.amount<100",Product1.class).getResultList();
//        Transaction transaction = session.beginTransaction();
//        for (Product1 product1: product1List ) {
//            product1.setName("name");
//            product1.setAmount(10);
//            session.persist(product1);
//        }
//        System.out.println(product1List);
//        transaction.commit();
//        session.close();
//    }
//
//    // D
//    private static void deleteExample() {
//        Session session = getSession();
//        Transaction transaction=session.beginTransaction();
//        Product1 product = new Product1();
//        product.setId(1);
//        session.remove(product);
//        transaction.commit();
//    }
//    // C
//    private static void insertData() {
//        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
//        Product1 product = new Product1(100,"name-1");
//        Product1 product1 = new Product1(200,"name-2");
//        Product1 product2 = new Product1(-100,"name-2");
//        Product1 product3 = new Product1(-200,"name-2");
//        Product1 product4 = new Product1(10,"name-2");
//        Product1 product5 = new Product1(20,"name-2");
//        session.persist(product);
//        session.persist(product1);
//        session.persist(product2);
//        session.persist(product3);
//        session.persist(product4);
//        session.persist(product5);
//        transaction.commit();
//    }
//    // U
//    private static void updateExample(){
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addResource("Product1.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Product1 product =session.get(Product1.class,1);
//        product.setName("name-updated");
//        product.setAmount(10);
//        session.persist(product);
//        transaction.commit();
//        session.close();
//    }
//    private static Session getSession(){
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addResource("Product1.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        return session;
//    }
//
//
//
//
//}