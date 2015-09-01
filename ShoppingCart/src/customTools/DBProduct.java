package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Product;

public class DBProduct {

	public static List<Product> getProducts()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select b from Product b";
		
		List<Product> products = null;
		try{
			Query q = em.createQuery(qString);
			products = q.getResultList();
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			em.close();
		} return products;
	}
	
	public static Product getDetails (long prodID)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Product details  = em.find(Product.class, prodID);
		return details;
	}
	
}
