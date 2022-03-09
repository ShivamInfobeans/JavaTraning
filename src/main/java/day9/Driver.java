//package day9;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class Driver {
//    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addAnnotatedClass(Student.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Student student = new Student();
//        student.setName("student8");
//
//        session.persist(student);
//        transaction.commit();
//        session.close();
//
//
//    }
//}