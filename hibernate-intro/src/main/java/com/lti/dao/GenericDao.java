package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class GenericDao {        //BaseDao....
	
	public void save(Object obj) {          //Save means insert or update in table
		EntityManagerFactory emf = null;
		EntityManager em=null;
		
		try {
		
				emf=Persistence.createEntityManagerFactory("oracle-pu");	
				em= emf.createEntityManager();
				//Find method generates select query
		
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.merge(obj);        // merge method can be used to insert as well as update
		
				tx.commit();
				}
		
		 
		finally {
					em.close();
					emf.close();
			}
	}
	
	public Object fetchById(Class classname, Object id) {               //here we will take id of any table means it may be a cust_tbl or tbl_order by setting Object
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
				emf=Persistence.createEntityManagerFactory("oracle-pu");
		
				em= emf.createEntityManager();
		
				//Find method generates select query
				Object obj= em.find(classname, id);
				
				return obj;
		}
		
		finally {
				em.close();
				emf.close();
		}
		
		
	}
	
public <E> List<E> fetchAll(Class<E> clazz) {      //TO AVOID TYPECASTING    BY using real generic class <E>
		
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		 em= emf.createEntityManager();
		
		//introducing JP-QL/HQL
		Query q = em.createQuery("select obj from " + clazz.getName() + " as obj");
		
		List<E> list = q.getResultList();	
		return list;
		}
		
		finally {
			em.close();
			emf.close();
		}
	}
}
