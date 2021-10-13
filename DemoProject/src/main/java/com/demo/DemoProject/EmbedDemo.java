package com.demo.DemoProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");      
        SessionFactory factory = cfg.buildSessionFactory();

       // Creating Certificate object
        Certificate certif = new Certificate();
        certif.setCourse("web development");
        certif.setDuration("6 months");
        
        // Creating student object
        Student student = new Student();
        student.setId(101);
        student.setName("Suchitra");
        student.setCity("Delhi");    
        student.setCerti(certif);
        
        // Creating Certificate object
        Certificate certif1 = new Certificate();
        certif1.setCourse("android");
        certif1.setDuration("2 months");
        
        // Creating student object
        Student student1 = new Student();
        student1.setId(102);
        student1.setName("Pragati");
        student1.setCity("Ghaziabad");   
        student1.setCerti(certif1);
        
        Session session = factory.openSession();
        
        Transaction txn = session.beginTransaction();
        session.save(student);
        session.save(student1);
        txn.commit();
        
        session.close();
        factory.close();
	}

}
