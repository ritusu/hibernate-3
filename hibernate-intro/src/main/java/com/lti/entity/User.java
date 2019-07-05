package com.lti.entity;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_USER")
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	
	//for many ended---lazy
	//one to many -----lazy
	//many to many---lazy
	
	//default for all is always eager
	
	
	
	//for one ended----eager
	//one to one-------eager
	//many to one------eager
	
	
	//for one to one lazy loading does not work directly
	
	
	@OneToOne(mappedBy= "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)//ownership is managed by the address and hence the object created by the owner is kept here in the mapped by
	//used for specifying to the hibernate that it is bidirectional
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
