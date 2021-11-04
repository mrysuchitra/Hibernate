package com.criteria.CriteriaQuery.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@Column(name = "person_id")
	private int id;
	@Column(name = "person_name")
	private String name;
	@Column(name = "person_city")
	private String city;
	@Column(name = "person_phone")
	private String phone;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return id + " : " + name + " : " + city + " : " + phone;
	}
	
}
