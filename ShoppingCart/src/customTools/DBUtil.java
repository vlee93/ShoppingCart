package customTools;

import model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Shopuser;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ShoppingCart");

	public static EntityManagerFactory getEmFactory() {
		emf.getCache().evictAll();
		return emf;
	}
		


public static void insert(Payment pay) {
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	EntityTransaction trans = em.getTransaction();
	trans.begin();
	try {
		em.persist(pay);
		trans.commit();
	} catch (Exception e) {
		e.printStackTrace();
		trans.rollback();
	} finally {
		em.close();
	}
}
}
