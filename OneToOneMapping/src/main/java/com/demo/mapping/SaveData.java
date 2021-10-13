package com.demo.mapping;

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
       
       // Creating answer object
       Answers ans = new Answers();
       ans.setAnswerId(111);
       ans.setAnswer("Java is a programming language.");
      
       // Creating question object
       Questions ques = new Questions();
       ques.setQuestionId(101);
       ques.setQuestion("What is Java ?");
       ques.setAns(ans);
       
       ans.setQues(ques);
       
       // Creating answer object
       Answers ans1 = new Answers();
       ans1.setAnswerId(222);
       ans1.setAnswer("API stands for Application Programming Interface");     
       
       // Creating question object
       Questions ques1 = new Questions();
       ques1.setQuestionId(102);
       ques1.setQuestion("What is an API ?");
       ques1.setAns(ans1);
       
       ans1.setQues(ques1);
       
       // Creating answer object
       Answers ans2 = new Answers();
       ans2.setAnswerId(333);
       ans2.setAnswer("Hibernate is an ORM tool.");
       
       // Creating question object
       Questions ques2 = new Questions();
       ques2.setQuestionId(103);
       ques2.setQuestion("What is hibernate?");
       ques2.setAns(ans2);
       
       ans2.setQues(ques2);
       
       Session session = factory.openSession();
       Transaction txn = session.beginTransaction();  
       session.save(ans);
       session.save(ans1);
       session.save(ans2);
       session.save(ques);
       session.save(ques1);
       session.save(ques2);
       
       txn.commit();
       session.close();
       factory.close();
    }
}
