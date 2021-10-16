package com.mapping.ManyToMany.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name = "project_name")
	private String projectName;
	
	@ManyToMany
	@JoinTable(
			  name="employee_reference", 
			  joinColumns = {@JoinColumn(name="emp_id")},
			  inverseJoinColumns = {@JoinColumn(name="project_id")}
			)
	private List<Employee> employees;
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
