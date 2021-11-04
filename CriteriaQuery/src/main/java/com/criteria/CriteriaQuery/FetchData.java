package com.criteria.CriteriaQuery;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.criteria.CriteriaQuery.modal.Person;

public class FetchData 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Criteria ct = session.createCriteria(Person.class);
        ct.add(Restrictions.eq("name", "Jessica"));
        List<Person> lp = ct.list();
        
        for(Person p : lp) {
        	System.out.println(p);
        }
        
        session.close();
        factory.close();
    }
}
