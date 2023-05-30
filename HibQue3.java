package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class HibQue3 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Update data
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student student = session.get(Student.class, 10);
        student.setSage(18);
        
        session.update(student);
        
        transaction.commit();
        session.close();
        
        // Retrieve and display the updated data
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        
        student = session.get(Student.class, 10);
        System.out.println("Updated student: " + student.getSname() + ", Age: " + student.getSage());
        
        transaction.commit();
        session.close();
        
        // Clean up Hibernate resources
        sessionFactory.close();
        
        
	}

}
