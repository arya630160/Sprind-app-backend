package com.web.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String designation;
	private String name;
	private String email;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String designation, String name, String email) {
		super();
		this.id = id;
		this.designation=designation;
		this.name = name;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", Designation =" + designation + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
