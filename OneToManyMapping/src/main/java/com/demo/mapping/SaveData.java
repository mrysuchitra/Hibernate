package com.demo.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.mapping.modal.Answers;
import com.demo.mapping.modal.Questions;

public class SaveData 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory factory = cfg.buildSessionFactory();
       
       // Creating Question object
       Questions ques = new Questions();
       ques.setQuestionId(101);
       ques.setQuestion("What is Java ?");
       
       // Creating Answers object
       Answers ans = new Answers();
       ans.setAnswerId(111);
       ans.setAnswer("Java is a programming languauge.");
       ans.setQues(ques);
       
       // Creating Answers object 
       Answers ans1 = new Answers();
       ans1.setAnswerId(222);
       ans1.setAnswer("Java is platform independent.");
       ans1.setQues(ques);
       
       List<Answers> list = new ArrayList<Answers>();
       list.add(ans);
       list.add(ans1);
       
       ques.setAns(list);
       
       // Creating Question object
       Questions ques1 = new Questions();
       ques1.setQuestionId(102);
       ques1.setQuestion("What is Hibernate ?");
       
       // Creating Answers object
       Answers ans2 = new Answers();
       ans2.setAnswerId(333);
       ans2.setAnswer("Hibernate is open source, lightweight.");
       ans2.setQues(ques1);
       
       // Creating Answers object 
       Answers ans3 = new Answers();
       ans3.setAnswerId(444);
       ans3.setAnswer("Hibernate is ORM tool.");
       ans3.setQues(ques1);
       
       List<Answers> list1 = new ArrayList<Answers>();
       list1.add(ans2);
       list1.add(ans3);
       
       ques1.setAns(list1);
       
       Session session = factory.openSession();       
       Transaction txn = session.beginTransaction();
       
       session.save(ans);
       session.save(ans1);
       session.save(ans2);
       session.save(ans3);
       
       session.save(ques);
       session.save(ques1);
       
       txn.commit();
       session.close();
       
       factory.close();
    }
}
