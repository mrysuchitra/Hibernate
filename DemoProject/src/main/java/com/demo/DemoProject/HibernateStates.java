package com.demo.DemoProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateStates {

	public static void main(String[] args) {
		
		System.out.println("Project Started............");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Creating Student object
		Student student = new Student();
		student.setId(222);
		student.setName("Suchitra");
		student.setCity("New Delhi");
		student.setCerti(new Certificate("Hibernate Tutorial", "3 months"));
		// student :: Transient State
		
		Session session = factory.openSession();
		Transaction txn =  session.beginTransaction();
		session.save(student);	
		student.setName("Nirmal");
		// student :: Persistent State = inserted into database, associated with session object
		txn.commit();
		session.close();
		// student :: Detached state :: object removed from session
		
		student.setName("Chitra");
		System.out.println(student.getId() + " :: " + student.getName());
		factory.close();
	}

}
