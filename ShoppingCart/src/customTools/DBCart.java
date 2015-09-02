package customTools;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Shopuser;
import model.Cart;
import model.Product;

public class DBCart {

	public static void addToCart(Cart item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(item);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static Cart getCartItem (long orderid)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Cart item  = em.find(Cart.class, orderid);
		return item;
	}
	
	public static void removeFromCart(Cart item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(item));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Cart> viewALLCart (){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select c from Cart c";
		
		List<Cart> orders = null;
		try{
			Query query = em.createQuery(qString);
			orders = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return orders;
	}
	
	public static List<Cart> viewMYCart (Shopuser user){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select c from Cart c where c.shopuser.userid = :userid";
		
		List<Cart> orders = null;
		try{
			Query query = em.createQuery(qString);
			query.setParameter("userid", user.getUserid());
			orders = query.getResultList();
			System.out.println("Orders =" + orders);

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return orders;
	}
	
}
