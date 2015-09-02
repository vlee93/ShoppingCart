import java.util.List;
import javax.persistence.EntityManager;

import customTools.DBProduct;
import customTools.DBUtil;
import model.Product;
import model.Cart;
import customTools.DBCart;

import java.io.IOException;

import model.Shopuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Confirmation() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		Shopuser me = (Shopuser) session.getAttribute("user");
		List<Cart> shopcart = DBCart.viewMYCart(me);
		
		String message = "";
		double subtotal = 0;
		double tax = 0;
		double total = 0;
		try{
			message += "<div class=\"container\">";
			message += "<table class=\"table table-bordered\"><thead><tr><th>Product</th><th>Price</th><th>Quantity</th><th>Remove?</th></tr></thead><tbody>";
			for (Cart cart : shopcart)
			{
				message += "<tr>";
				message += "<td>";
				message += cart.getProduct().getProdname();
				message += "</td>";
				message += "<td>";
				message += cart.getProduct().getPrice();
				message += "</td>";
				message += "<td>";
				message += cart.getQty();
				message += "</td>";
				message += "<td>";
				message += "<a href=\"removeItem?OrdID=" + cart.getOrderid() + "\">" +"<button type=\"button\" class=\"btn btn-info\">Remove</button>" + "</a>";
				message += "</td>";
				message += "</tr>";
				subtotal += (cart.getQty()*cart.getProduct().getPrice());
			}
			tax = subtotal*.06;
			total = tax + subtotal;
			message += "</tbody></table>";
			message += "</div>";
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
		request.setAttribute("message", message);
		request.setAttribute("subtotal", subtotal);
		request.setAttribute("tax", tax);
		request.setAttribute("total", total);
		getServletContext().getRequestDispatcher("/CheckOut.jsp").forward(request, response);
	}

}
