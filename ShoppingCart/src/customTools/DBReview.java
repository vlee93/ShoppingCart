package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Product;
import model.Shopuser;
import model.Comment;

public class DBReview {
	
	public static void insert(Comment review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(review);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static List<Comment> getComments(Product prod)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select c from Comment c where c.product.prodid = :prodid";
		
		List<Comment> reviews = null;
		try{
			Query q = em.createQuery(qString);
			q.setParameter("prodid", prod.getProdid());
			reviews = q.getResultList();
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			em.close();
		} return reviews;
	}
	
}
