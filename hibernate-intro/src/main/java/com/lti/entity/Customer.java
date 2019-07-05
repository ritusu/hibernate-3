package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUST")
public class Customer {
	
	@Id 											//primary key 
	@GeneratedValue 					// auto generated value by hibernate
	@Column(name="CUST_ID") 
	private int id;
	
	@Column(name="CUST_NAME") 
	private String name;
	@Column(unique = true) 
	private String email;
	@Column(name="CUST_DOB") 
	private Date dateOfBirth;
	@Column(name="CITY") 
	private String city;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
