package daoForModel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;

import model.Songs;

public class AlbumDao extends GenericDao{

public List<Songs> fetchSongsByDuration(double duration) {
		
		EntityManagerFactory emf =null;
		EntityManager em=null;
		
		try {
			
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		 em= emf.createEntityManager();
		
		//introducing JP-QL/HQL
		Query q = em.createQuery("select s from Songs as s  where s.duration> :em");
		q.setParameter("em",duration);
		List<Songs> list = q.getResultList();
		
		return list;
		}
		
		finally {
		em.close();
		emf.close();
	
		}
		
	}
	
}
