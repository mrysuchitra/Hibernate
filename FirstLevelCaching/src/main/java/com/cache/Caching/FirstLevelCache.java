package com.cache.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cache.Caching.modal.Employee;

public class FirstLevelCache 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();      
       Session session = factory.openSession();
       
       // first level cache is by default enabled
       Employee emp = session.get(Employee.class, 101);
       System.out.println(emp);
       
       System.out.println("Working on something.............");
       
       Employee emp1 = session.get(Employee.class, 101);
       System.out.println(emp1);
       
       session.close();
       factory.close();
    }
}
