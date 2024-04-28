package Hibernate;

import Entinies.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

        // to delete
        Instructor inst = session.get(Instructor.class,4);
        session.remove(inst);

        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();
    }
}
