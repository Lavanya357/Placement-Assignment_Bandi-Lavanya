package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class HibQue2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
        configuration.configure();
        
        // Create a SessionFactory using the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Open a new session
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student student=new Student();
        student.setSid(10);
        student.setSaddress("MI");
        student.setSage(30);
        student.setSname("veena");
        
        session.save(student);
        
        transaction.commit();
        
        session.close();
        session = sessionFactory.openSession();

        // Retrieve all persons from the database
        List<Student> STDTAB = session.createQuery("FROM Student", Student.class).list();

        // Display the retrieved persons
        for (Student std : STDTAB) {
            System.out.println("ID: " + student.getSid() + ", Name: " + student.getSname());
        }

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();

	}

}
