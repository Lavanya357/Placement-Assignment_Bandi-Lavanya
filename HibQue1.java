package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;





public class HibQue1 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
        configuration.configure();
        
        // Create a SessionFactory using the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Open a new session
        Session session = sessionFactory.openSession();
        
        List<Student> student = session.createQuery("FROM Student", Student.class).list();
        
        // Display the retrieved data
        for (Student student1 : student) {
            System.out.println(student);
        }
        
        // Close the session and the session factory
        session.close();
        sessionFactory.close();

	}

}
