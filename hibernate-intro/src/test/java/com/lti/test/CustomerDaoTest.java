package com.lti.test;


import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void test() {
		
		Customer c= new Customer();
		c.setName("sriya");
		c.setEmail("suma@gmail.com");
		c.setCity("kerala");
		CustomerDao dao= new CustomerDao();
		dao.insertOrUpdate(c);
		
	}  

	@Test
	public void testFetch() {
		CustomerDao dao= new CustomerDao();
		Customer cust = dao.fetchDatabase(1);
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
	}
	
	@Test
	public void testUpdate() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.fetchDatabase(21);
		cust.setCity("Pune");
		dao.insertOrUpdate(cust);
	}
	
	/*
	@Test
	public void testFetchAll() {
		CustomerDao dao= new CustomerDao();
		List<Customer> list= dao.fetchDatabaseAll();
		for (Customer l : list) {
				System.out.println(l.getName());
				System.out.println(l.getEmail());
				System.out.println(l.getDateOfBirth());
				System.out.println(l.getCity());
			}
	}*/
	
	@Test
	public void testFetchAll() {
		CustomerDao dao= new CustomerDao();
		List<Customer> list= dao.fetchCustomerByEmail("gmail.com");
		for (Customer l : list) {
				System.out.println(l.getName());
				System.out.println(l.getEmail());
				System.out.println(l.getDateOfBirth());
				System.out.println(l.getCity());
			}
	
	}
}
