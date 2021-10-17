package com.hql.HQLExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hql.HQLExample.modal.Product;

public class SaveData 
{
    public static void main( String[] args )
    {
        System.out.println("Project Started.....................");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Creating Product Object
        Product p1 = new Product();
        p1.setProductId(1658);
        p1.setProductName("Fruits");
        p1.setProductPrice(80.00);
        p1.setProductQuantity(1);
        p1.setTotalAmount(p1.getProductQuantity() * p1.getProductPrice());
        
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        
        session.save(p1);
        
        txn.commit();
        session.close();
        factory.close();
    }
}
