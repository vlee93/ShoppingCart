package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Shopuser;

public class DBShopUser {
	
	public static long isValidUser(Shopuser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select b.userid from Shopuser b where b.username = :username and b.userpass = :userpass";
		Query q = em.createQuery(qString);
		q.setParameter("username", user.getUsername());
		q.setParameter("userpass", user.getUserpass());

		try{
			long userId = (long) q.getSingleResult();
			System.out.println("userId =" + userId);
			if (userId > 0)
			{
				return userId;
			}
			else
			{
				return 0;
			}
			
		}catch (Exception e){
			
			return 0;
		}
		finally{
				em.close();		
		}		
	}
	
	public static void insert(Shopuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static Shopuser getUser (long userID)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Shopuser user  = em.find(Shopuser.class, userID);
		return user;
	}
}
