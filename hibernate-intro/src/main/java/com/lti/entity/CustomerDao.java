package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.event.spi.MergeEvent;
import org.hibernate.internal.EntityManagerMessageLogger;

public class CustomerDao {

/*	public void databaseMeAddKaro(Customer customer) {
		//Step 1. Load/Create EntityManagerFactory object
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
		//Step 2. Load/Create EntityManager object
		em= emf.createEntityManager();
		
		//Step3. Start/Participate in a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		em.persist(customer); // persist method generates insert query
       
		tx.commit();
		}
		
		finally {
		//below code should be in finally block 	
		em.close();
		emf.close();
		}
		
	}*/
	public Customer fetchDatabase(int custId) {
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
				emf=Persistence.createEntityManagerFactory("oracle-pu");
		
				em= emf.createEntityManager();
		
				//Find method generates select query
				Customer c= em.find(Customer.class, custId);
				
				return c;
		}
		
		finally {
				em.close();
				emf.close();
		}
		
	}
	
public List<Customer> fetchCustomerByEmail(String email) {
		
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		 em= emf.createEntityManager();
		
		//introducing JP-QL/HQL
		Query q = em.createQuery("select c from Customer as c  where c.email like :em");
		q.setParameter("em","%"+ email+"%");
		List<Customer> list = q.getResultList();
		
		return list;
		}
		
		finally {
		em.close();
		emf.close();
	
		}
		
	}

public void insertOrUpdate(Customer customer) {
		EntityManagerFactory emf = null;
		EntityManager em=null;
		
		try {
		
				emf=Persistence.createEntityManagerFactory("oracle-pu");	
				em= emf.createEntityManager();
		//Find method generates select query
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(customer);        // merge method can be used to insert as well as update
		
		tx.commit();
		}
		 
		finally {
		em.close();
		emf.close();
		}
	}
}

