package Relations;

import Entinies.Instructor;
import Entinies.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1to1Bi {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

        //to insert item in table (can use a loop for a list)
        InstructorDetails details = session.get(InstructorDetails.class, 1);
        System.out.println(details);
        System.out.println(details.getInstructor());

        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();

    }
}
