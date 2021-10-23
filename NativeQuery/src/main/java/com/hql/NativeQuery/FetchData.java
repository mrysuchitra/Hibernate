package com.hql.NativeQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class FetchData 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       Session session = factory.openSession();
       
       String query = "Select * from product";
       NativeQuery nq = session.createSQLQuery(query);
       List<Object[]> list = nq.list();
       
       for(Object[] product : list) {
    	   System.out.println(product[0] + " : " + product[1] + " : " + product[2]);
       }
       
       session.close();
       factory.close();
    }
}
