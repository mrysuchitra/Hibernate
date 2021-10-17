package com.hql.HQLQueries;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JoinData 
{
    public static void main( String[] args )
    {
        System.out.println("Project Started.................");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Query query = session.createQuery("select q.questionId, q.question, a.answer from Questions as q INNER JOIN q.ans as a");
        List<Object[]> list = query.getResultList();
        for(Object[] arr : list) {
        	System.out.println(Arrays.toString(arr));
        }
        
        session.close();
        factory.close();
    }
}
