package com.cascade.Cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cascade.Cascading.modal.Answers;
import com.cascade.Cascading.modal.Questions;

public class SaveData 
{
    public static void main( String[] args )
    {
       Configuration cfg =  new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       // Creating an object of Questions
       Questions q = new Questions();
       q.setQuestionId(10);
       q.setQuestion("What is Docker ?");
       
       // Creating an object of Answers
       Answers a = new Answers();
       a.setAnswerId(888);
       a.setAnswer("Docker is a tool.");
       a.setQues(q);
       
       // Creating an object of Answers
       Answers a1 = new Answers();
       a1.setAnswerId(999);
       a1.setAnswer("It is designed to create, deploy and run app.");
       a1.setQues(q);
       
       List<Answers> list = new ArrayList<Answers>();
       list.add(a);
       list.add(a1);
       
       q.setAns(list);
       
       SessionFactory factory = cfg.buildSessionFactory();
       Session session = factory.openSession();
       
       Transaction txn = session.beginTransaction();     
       session.save(q);      
       txn.commit();
       
       session.close();
       factory.close();
    }
}
