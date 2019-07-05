package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountDao extends GenericDao {

	public List<Transaction> fetchMiniStatement(long accno){
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			
			String ql="select t from Transaction as t where t.account.acno = :ac order by t.date desc";
			Query q=em.createQuery(ql);
			q.setParameter("ac", accno);
			q.setMaxResults(5);
			List<Transaction> list=q.getResultList();
			return list;
		}finally {
			em.close();
			emf.close();
		}
	}
		public List<Account> fetchAccountsByBalance(double balance){
			EntityManagerFactory emf=null;
			EntityManager em=null;
			try {
				emf=Persistence.createEntityManagerFactory("oracle-pu");
				em=emf.createEntityManager();
				
				String ql="select t from Account as t where t.balance >= :ac ";
				Query q=em.createQuery(ql);
				q.setParameter("ac", balance);
				
				List<Account> list=q.getResultList();
				return list;
			}finally {
				em.close();
				emf.close();
			}
			
	}
		public List<Account> fetchAccountsByActivity(String type,double balance){
			EntityManagerFactory emf=null;
			EntityManager em=null;
			try {
				emf=Persistence.createEntityManagerFactory("oracle-pu");
				em=emf.createEntityManager();
				
				String ql="select a from Account a inner join a.transactions tx where tx.type >= :tp and tx.amount >=:amt";
				//in the above query, a.transactions links the two tables since transactions is the column which is mapped by account object in transaction table
				
				Query q=em.createQuery(ql);
				q.setParameter("tp", type);
				q.setParameter("amt", balance);
							
				List<Account> list=q.getResultList();
				return list;
			}finally {
				em.close();
				emf.close();
			}
			
	}
}
