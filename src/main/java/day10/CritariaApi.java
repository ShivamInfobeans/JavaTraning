//package day10;
//
//import day9.Driver;
//import day9.Student;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.hibernate.Session;
//import Utils.Utility;
//
///*
//various ways to fetch data
//(i) session.get(Student.class,1) -> return you the student object
//(ii) HQL -> hibernate query language
//(iii) Hibernate criteria API
//
//criteria -> marks > 40
// HQL -> from Student
// SQL -> select * from student_records
// aggregate functions, where, groupby -> converted to Java functions.
//
//select * from student where marks > 90
//
//Q-)
//write a query which returns the records for the student with name student-1 or student-2
//Q-) Use an aggregate function like avg to find the average marks or sum function.
//Q-) write a groupby query using criteria api
//Q-) write a groupby clause that returns the name and count of records in the table for that particular name.
//
// */
//public class CritariaApi {
//    public static void main(String[] args) {
//        Session session = Utility.getSession();
//        CriteriaQuery<Student> critertiaQuery = betweenMethod(session);
//        // predicate means a condition that is evaluated to true or false
//// from Student where marks > 90
//        System.out.println(session.createQuery(critertiaQuery).getResultList());
//
//    }
//
//    private static CriteriaQuery<Student> betweenMethod(Session session) {
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> critertiaQuery = criteriaBuilder.createQuery(Student.class);
//        Root<Student> root = critertiaQuery.from(Student.class);
//        critertiaQuery.select(root).where(criteriaBuilder.between(root.get("marks"),10,20));
//        return critertiaQuery;
//    }
//    private static CriteriaQuery<Student> ltMethod(Session session) {
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> critertiaQuery = criteriaBuilder.createQuery(Student.class);
//        Root<Student> root = critertiaQuery.from(Student.class);
//        critertiaQuery.select(root).where(criteriaBuilder.lt(root.get("marks"),10));
//        return critertiaQuery;
//    }
//    private static CriteriaQuery<Student> gtMethod(Session session) {
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> critertiaQuery = criteriaBuilder.createQuery(Student.class);
//        Root<Student> root = critertiaQuery.from(Student.class);
//        critertiaQuery.select(root).where(criteriaBuilder.gt(root.get("marks"),90));
//        return critertiaQuery;
//    }
//
//    private static void selectQuery() {
//        Session session = Utility.getSession();
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> critertiaQuery = criteriaBuilder.createQuery(Student.class);
//        Root<Student> root = critertiaQuery.from(Student.class);
//        /*
//        root is like root of a tree.
//        Binary Trees in algorithm or in general what is a tree in a graph
//         */
//        critertiaQuery.select(root);
//        System.out.println(session.createQuery(critertiaQuery).getResultList());
//    }
//}