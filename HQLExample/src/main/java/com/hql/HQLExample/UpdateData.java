package com.hql.HQLExample;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String[] args) {
		
		System.out.println("Project Started...........");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();  
        Transaction txn = session.beginTransaction();
		
        Query query = session.createQuery("update Product as p set p.productName = :x where p.productQuantity = :y");
        query.setParameter("x", "Vegetables");
        query.setParameter("y", 1);
        
        int result = query.executeUpdate();
        System.out.println("Updated number of rows : " + result);
        
        txn.commit();
        session.close();
		factory.close();
	}

}
