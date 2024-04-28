package Relations;

import Entinies.Instructor;
import Entinies.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main1to1Uni {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

//        // to select
//        Instructor inst = session.get(Instructor.class,5);
//        System.out.println(inst);
//        Instructor inst1 = session.get(Instructor.class,6);
//        System.out.println(inst1);
//
//        // to insert
//        InstructorDetails details = new InstructorDetails("OmarGames","gaming");
//       // session.persist(details);
//        Instructor inst2 = new Instructor("omar", "alaa", "omar@gmail.com", details);
//        session.persist(inst2);
//
//        // to delete
//        Instructor inst3 = session.get(Instructor.class,6);
//        session.remove(inst3);
//
//        // to read all
//        List<Instructor> instructorsList = session.createQuery("from Instructor i", Instructor.class).getResultList();
//        instructorsList.forEach(i-> System.out.println(i));

        // fetch
        Instructor instructor = session.get(Instructor.class,5);
        System.out.println(instructor);
        System.out.println("----------------------------");
        System.out.println(instructor.getDetails());


        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();

    }
}
