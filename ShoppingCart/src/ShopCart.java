import java.util.List;

import javax.persistence.EntityManager;

import customTools.DBProduct;
import customTools.DBUtil;
import model.Product;
import model.Cart;
import customTools.DBCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShopCart")
public class ShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShopCart() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Cart> shopcart = DBCart.viewCart();
		String message = "";
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
				total += (cart.getQty()*cart.getProduct().getPrice());
			}
			message += "</tbody></table>";
			message += "</div>";
		}catch (Exception e){
			e.printStackTrace();;
		} finally {
			em.close();
		}
		request.setAttribute("message", message);
		request.setAttribute("total", total);
		getServletContext().getRequestDispatcher("/mycart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String QTYstr = request.getParameter("QTY");
		long QTY = Long.parseLong(QTYstr);
		HttpSession session = request.getSession();
		String prodIDstr = (String) session.getAttribute("prodId");
		long prodID = Long.parseLong(prodIDstr);

		try{
			Cart mycart = new Cart();
			mycart.setQty(QTY);
			Product myprod = DBProduct.getDetails(prodID);
			mycart.setProduct(myprod);
			DBCart.addToCart(mycart);

		}catch (Exception e){
			e.printStackTrace();;
		} finally {
			em.close();
		}

		response.sendRedirect(response.encodeRedirectURL("/ShoppingCart/ShopCart"));
	}

}
