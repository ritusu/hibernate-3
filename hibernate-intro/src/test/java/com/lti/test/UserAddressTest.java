package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Address;
import com.lti.entity.User;

public class UserAddressTest {

	@Test
	public void addNewUser() {
	
		User user=new User();
		GenericDao dao= new GenericDao();
		user.setName("Sriya");
		user.setEmail("sriya@gmail.com");
		dao.save(user);
	}

	@Test
	public void addAddressForAnExistingUser() {
		
		Address add = new Address();
		GenericDao dao = new GenericDao();
		User user= (User)dao.fetchById(User.class, 281);
		add.setCity("Shimla");
		add.setPincode(956755);
		add.setState("HimachalP");
		add.setUser(user);
		dao.save(add);
	}
	
	@Test
	public void addUserAndAddressTogether() {
		
		User user=new User();
		user.setName("akasnha");
		user.setEmail("akasnha@gmail.com");
		
		Address add = new Address();
		add.setCity("kolkata");
		add.setPincode(956545);
		add.setState("WestBengal");
		
		user.setAddress(add);
		add.setUser(user);
	
		GenericDao dao= new GenericDao();
		//dao.save(add);
		dao.save(user);
	}
	
	@Test
	public void fetchUserAndAddressBoth() {
		GenericDao dao = new GenericDao();
		User user= (User)dao.fetchById(User.class, 301);
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		
		Address addr= user.getAddress();
		System.out.println(addr.getCity());
		System.out.println(addr.getPincode());
		System.out.println(addr.getState());
	}
}
