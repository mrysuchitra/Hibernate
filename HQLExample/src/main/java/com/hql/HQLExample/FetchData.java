package com.hql.HQLExample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.HQLExample.modal.Product;

public class FetchData {

	public static void main(String[] args) {
		
		System.out.println("Project Started.................");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		String query = "from Product where productQuantity = :x and productName = :y";
		Query q = session.createQuery(query);
		q.setParameter("x", 2);
		q.setParameter("y", "Juice");
		
		List<Product> proList = q.list();
		
		for(Product product : proList) {
		    System.out.println("Product Id : " + product.getProductId());
		    System.out.println("Product Name : " + product.getProductName());
		    System.out.println("Product Price : " + product.getProductPrice());
		}
		
		session.close();
		factory.close();
	}

}
