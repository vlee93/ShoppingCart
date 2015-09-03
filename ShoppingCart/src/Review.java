import javax.persistence.EntityManager;

import java.util.Date;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBShopUser;
import customTools.DBProduct;
import customTools.DBUtil;
import customTools.DBReview;
import model.Shopuser;
import model.Comment;
import model.Product;
import java.util.List;
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Review() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		HttpSession session = request.getSession();
//		String prodidstr = (String) session.getAttribute("prodId");
//		long prodid = Long.parseLong(prodidstr);
//		Product myprod = DBProduct.getDetails(prodid);
//		List<Comment> comments= DBReview.getComments(myprod);
//		request.setAttribute("comments", comments);
//		getServletContext().getRequestDispatcher("/details").forward(request, response);
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		Date date = new Date();
		
		//getting the user
		Shopuser user = (Shopuser) session.getAttribute("user");
		long userid = user.getUserid();
		
		//getting the product of interest
		String prodidstr = (String) session.getAttribute("prodId");
		long prodid = Long.parseLong(prodidstr);
		Product myprod = DBProduct.getDetails(prodid);
		
		//requesting rating and review from form
		String ratingstr = request.getParameter("Rating");
		long rating = Long.parseLong(ratingstr);
		String review = request.getParameter("review");
		
		//inserting comment
		try{
			Comment comm = new Comment();
			comm.setCommentdate(date);
			comm.setItemcomment(review);
			comm.setRating(rating);
			comm.setShopuser(user);
			comm.setProduct(myprod);
			DBReview.insert(comm);
		}catch (Exception e){
			e.printStackTrace();;
		} finally {
			em.close();
		}
		getServletContext().getRequestDispatcher("/ProdList").forward(request, response);
	}

}
