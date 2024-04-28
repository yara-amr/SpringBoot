package Hibernate;

import Entinies.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainSelect {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

        // to select element by id
        Instructor inst = session.get(Instructor.class,1);
        System.out.println(inst);

        // to select all data in table
        List<Instructor> instructorsList = session.createQuery("from Instructor i", Instructor.class).getResultList();
        instructorsList.forEach(i-> System.out.println(i));

        // to select with a condition
        List<Instructor> instructors = session.createQuery("from Instructor i WHERE i.firstName LIKE :pattern", Instructor.class)
                .setParameter("pattern", "a%").getResultList();
        instructors.forEach(i-> System.out.println(i));

        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();
    }
}
