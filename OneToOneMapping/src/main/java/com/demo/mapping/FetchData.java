package com.demo.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.mapping.modal.Answers;
import com.demo.mapping.modal.Questions;

public class FetchData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Questions ques = (Questions)session.get(Questions.class, 102);
		System.out.println(ques.getQuestion());
		
		Answers ans = ques.getAns();
		System.out.println(ans.getAnswer());
		
		session.close();
	    factory.close();	
	}

}
