package com.hql.HQLExample;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {
		
		System.out.println("Project Started...............");
		Configuration cfg =  new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery("delete from Product as p where p.productName = :x");
		query.setParameter("x", "Oats");
		int result = query.executeUpdate();
		System.out.println("Number of deleted rows : " + result);
		
		txn.commit();
		session.close();
		factory.close();
	}

}
