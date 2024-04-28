package Relations;

import Entinies.Course;
import Entinies.Instructor;
import Entinies.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainManyto1 {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

//        Course course=new Course("deutsch");
//        Instructor instructor= session.get(Instructor.class,2);
//        course.setInstructor(instructor);
//        session.persist(course);

        Course course1=session.get(Course.class,10);
        System.out.println(course1);

        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();

    }
}
