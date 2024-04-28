package Relations;

import Entinies.Course;
import Entinies.Instructor;
import Entinies.InstructorDetails;
import Entinies.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainManytoMany {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory= new Configuration().configure("file.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // open session
        Session session = sessionFactory.openSession();
        // begin transaction
        session.beginTransaction();
        // do actions on db

        // add course from instructor to student
//        Student student = new Student("alaa", "hassan","alaa@gmail.com");
//        Instructor inst = session.get(Instructor.class,5);
//        Course course = new Course("water painting", inst);
//        student.addCourse(course);
//        session.persist(student);

        // add all courses of an instructor
//        Instructor inst = session.get(Instructor.class,2);
//        Student st = session.get(Student.class,1);
//        st.addCourses(inst.getCourses());
//        session.persist(st);


        // add student to course
        Instructor inst= session.get(Instructor.class,5);
        Course course= new Course("sculpturing", inst);
        Student st = new Student("nour","wael","nour@gmail.com");
        course.addStudent(st);
        session.persist(course);


        // commit transactions
        session.getTransaction().commit();
        // close session
        session.close();
        // close session factory
        sessionFactory.close();
    }
}
