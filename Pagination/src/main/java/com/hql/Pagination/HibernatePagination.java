package com.hql.Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.Pagination.modal.Product;

public class HibernatePagination 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
    	
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	// implementing pagination
    	Query<Product> query = session.createQuery("from Product");
    	query.setFirstResult(0);
    	query.setMaxResults(4);
    	
    	List<Product> list = query.list();
    	for(Product product : list) {
    		System.out.println(product.getProductId() + " : " + product.getProductName() + " : " + product.getProductPrice());
    	}
    	
    	session.close();
    	factory.close();      
    }
}
