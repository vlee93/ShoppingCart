import javax.persistence.EntityManager;

import customTools.DBProduct;
import customTools.DBUtil;
import customTools.DBCart;
import model.Product;
import model.Cart;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;


@WebServlet("/removeItem")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveItem() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String ordIDstr = request.getParameter("OrdID");
		System.out.println("OrderID: " + ordIDstr);
		long ordID = Long.parseLong(ordIDstr);
		Cart delitem = DBCart.getCartItem(ordID);
		DBCart.removeFromCart(delitem);
		getServletContext().getRequestDispatcher("/Deleted.jsp").forward(request, response);
	}

}
