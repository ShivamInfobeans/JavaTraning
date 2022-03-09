//package day9;
//
//import Utils.Utility;
//import day8.Person1;
//import day8.PhoneNumber;
//import day9.Department;
//import day9.Employee;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class Department_Employee {
//
//
//        public static void main(String[] args) {
//
////            Session session = Utility.getSession("association.hbm.xml");
////            Transaction transaction = session.beginTransaction();
////            Department department= session.get(Department.class,2);
////            Employee employee = new Employee();
////            employee.setDepartment(department);
////            employee.setName("Shivam");
////            session.persist(employee);
////            transaction.commit();
////            session.close();
//
//            // addPersonAndPhoneNumber();
//            adddep();
//        }
//    private static void adddep() {
//        Session session = Utility.getSession("Department_Employee.hbm.xml");
//        Transaction transaction = session.beginTransaction();
//        Department department = new Department();
//        department.setName("Software Engineer");
////        Employee employee = new Employee();
////        employee.setName("Shivam");
////        employee.setDepartment(department);
//        session.persist(department);
//        transaction.commit();
//    }
//
//        private static void addPersonAndPhoneNumber() {
//            Session session = Utility.getSession("Department_Employee.hbm.xml");
//            Transaction transaction = session.beginTransaction();
//            Department department = new Department();
//            department.setName("Software Engineer");
//            Employee employee = new Employee();
//            employee.setName("Shivam");
//            employee.setDepartment(department);
//            session.persist(employee);
//            transaction.commit();
//        }
//    }
//
