package com.mapping.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.ManyToMany.modal.Employee;
import com.mapping.ManyToMany.modal.Project;

public class SaveData 
{
    public static void main( String[] args )
    {
       System.out.println("Project Started..............");
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       
       // Create an Employee objects
       Employee emp1 = new Employee();
       Employee emp2 = new Employee();
       
       emp1.setEmpId(101);
       emp1.setEmpName("John");
       
       emp2.setEmpId(102);
       emp2.setEmpName("Michael");
       
       // Create a Project objects
       Project pro1 = new Project();
       Project pro2 = new Project();
       
       pro1.setProjectId(111);
       pro1.setProjectName("CARDBYTE");
       
       pro2.setProjectId(222);
       pro2.setProjectName("FCI-SCALAR");
       
       List<Employee> empList = new ArrayList<Employee>();
       List<Project> proList = new ArrayList<Project>();
       
       empList.add(emp1);
       empList.add(emp2);
       
       proList.add(pro1);
       proList.add(pro2);
       
       emp1.setProjects(proList);
       emp2.setProjects(proList);
       
       pro1.setEmployees(empList);
       pro2.setEmployees(empList);
       
       SessionFactory factory = cfg.buildSessionFactory(); 
       Session session = factory.openSession();      
       Transaction txn = session.beginTransaction();
       
       session.save(emp1);
       session.save(emp2);
       session.save(pro1);
       session.save(pro2);
       
       txn.commit();
       session.close();
       factory.close();
    }
}
