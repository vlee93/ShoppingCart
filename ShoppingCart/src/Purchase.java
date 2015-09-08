import javax.persistence.EntityManager;

import customTools.*;
import model.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Past
 */
@WebServlet("/Past")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		Date date = new Date();
		Shopuser me = (Shopuser) session.getAttribute("user");
		List<Cart> shopcart = DBCart.viewMYCart(me);
		String ship = request.getParameter("shipping");
		String bill = request.getParameter("billing");
		String cnu = request.getParameter("creditcard");
		String total = (String) session.getAttribute("total");
		String message = "";
		
		Payment pay = new Payment();
		pay.setBilladd(bill);
		pay.setCnumber(cnu);
		pay.setShopuser(me);
		pay.setPdate(date);
		pay.setTotal(total);
		pay.setShipadd(ship);
		DBUtil.insert(pay);
		
		getServletContext().getRequestDispatcher("/Done.jsp").forward(request, response);

	}

}
