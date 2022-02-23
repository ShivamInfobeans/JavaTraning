package day7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
Hibernate - ORM
ORM -> Object relational mapping
Person object, I want to store this person object in a table.
Person is a class , save this object
It will automatically insert the person object  into a table.

We define a person class and create an object of it
hibernate will map this object to the mysql table.
ORM

// persistence -> storage
JPA -> Java persistence API
       (Jakarta persistence API) <-- 2021

JPA is part o java library and it provides a set of interface
Hibernate provides implementation of those interfaces.
JPA providers
Hibernate is one example of JPA provider.
Another example of JPA provider is EclipseLink

we need to provide it details
 */
public class Main {

    public static void main(String[] args) {
        // create person table
        // insert into person values(1,"name-1","address-1")
        Person person = new Person(1, "name-1", "address-1");
        // To convert it to a SQL statement
        // hibernate needs to know which table are we inserting data in.
        // and what are the data types.
        // mapping the object fields to the table columns
        // class is mapped to a table
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Person.class);
        configuration.addResource("Person.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
        /*
        Configurations are done using
        (i) XML
        (ii) Annotations
         */

    }
}