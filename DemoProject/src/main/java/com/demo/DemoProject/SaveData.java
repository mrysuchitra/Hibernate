package com.demo.DemoProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveData 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Project Started........");
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // Creating student object
        Student std = new Student();
        std.setId(102);
        std.setName("Rohit");
        std.setCity("Noida");
        
        // Creating address object
        Address add = new Address();
        add.setStreet("street4");
        add.setCity("Meerut");
        add.setOpen(true);
        add.setX(124.67);
        add.setAddedDate(new Date());
    
        // read image data
        FileInputStream fis = new FileInputStream("src/main/java/pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);  
        add.setImage(data);
        fis.close();
        
        Session session = sessionFactory.openSession();
        
        Transaction txn = session.beginTransaction();
        session.save(std);
        session.save(add);
        txn.commit();
        
        session.close();
        
    }
}
