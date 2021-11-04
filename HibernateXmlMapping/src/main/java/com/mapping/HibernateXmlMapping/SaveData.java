package com.mapping.HibernateXmlMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.HibernateXmlMapping.modal.Person;

public class SaveData 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();   
       
       Person p1 = new Person(101, "Suchitra", "Delhi", "8447930289");
       Person p2 = new Person(102, "Micheal", "Edinburg", "8987930289");
       Person p3 = new Person(103, "Jessica", "New York", "847980289");
       Person p4 = new Person(104, "Olivia", "Los Anglos", "8447934343");
       Person p5 = new Person(105, "Ivanka", "Florida", "9999930289");
       Person p6 = new Person(106, "Justin", "Dublin", "9997930989");
       
       Session session = factory.openSession();       
       Transaction txn = session.beginTransaction();
       
       session.save(p1);
       session.save(p2);
       session.save(p3);
       session.save(p4);
       session.save(p5);
       session.save(p6);
       
       txn.commit();
       session.close();
       factory.close();     
    }
}
