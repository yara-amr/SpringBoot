package Relations;

import Entinies.Course;
import Entinies.Instructor;
import Entinies.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1toMany {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db


//        // add courses and link to instructor
//        Instructor inst = session.get(Instructor.class,1);
//
//        Course c1 = new Course("hiphop", inst);
//        Course c2 = new Course("contemporary", inst);
//        Course c3 = new Course("house", inst);
//        Course c4 = new Course("freestyle", inst);
//
//        session.persist(c1);
//        session.persist(c2);
//        session.persist(c3);
//        session.persist(c4);
//
//        inst.getCourses().forEach(c-> System.out.println(c));

        Instructor inst = session.get(Instructor.class, 2);
        inst.getCourses().forEach(c-> System.out.println(c));

        Course course=new Course("english", inst);
        inst.addCourse(course);
        session.persist(inst);

        inst.getCourses().forEach(c-> System.out.println(c));

        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();
    }
}
