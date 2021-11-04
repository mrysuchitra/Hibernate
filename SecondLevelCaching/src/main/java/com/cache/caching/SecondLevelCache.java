package com.cache.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cache.caching.modal.Employee;

public class SecondLevelCache 
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, 101);
        System.out.println(emp);
        session.close();
        
        Session session1 = factory.openSession();
        Employee emp1 = session1.get(Employee.class, 101);
        System.out.println(emp1);
        session1.close();
        
        factory.close();
    }
}
