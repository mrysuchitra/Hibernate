package com.mapping.ManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.ManyToMany.modal.Employee;
import com.mapping.ManyToMany.modal.Project;

public class FetchData {

	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Employee emp = (Employee)session.get(Employee.class, 101);
		System.out.println("Employee id : " + emp.getEmpId());
		System.out.println("Employee Name : " + emp.getEmpName());
		System.out.println("Associated project :: ");
		List<Project> project = emp.getProjects();
		for(Project pro : project) {
		   System.out.println("Employee Associated project : " + pro.getProjectName());	
		}
		session.close();
		factory.close();
		
	}
}
