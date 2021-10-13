package com.demo.DemoProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       
       Session session = factory.openSession();
       
       Student student = (Student)session.get(Student.class, 101);
       System.out.println(student);
       
       Student student1 = (Student)session.get(Student.class, 101);
       System.out.println(student1);
       
       Address add = (Address)session.load(Address.class, 2);
       System.out.println(add.getCity());
       
       Address add1 = (Address)session.load(Address.class, 2);
       System.out.println(add1);
       
       session.close();
       factory.close();

	}

}
