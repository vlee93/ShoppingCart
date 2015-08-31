import java.util.List;

import javax.persistence.EntityManager;

import customTools.DBProduct;
import customTools.DBUtil;
import model.Product;
import model.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProdList")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProdList() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try{
			List<Product> products = DBProduct.getProducts();
			message += "<div class=\"container\">";
			message += "<table class=\"table table-bordered\"><thead><tr><th>Product Name</th></tr></thead><tbody>";
			for (Product prod : products)
			{
				message += "<tr>";
				message += "<td>" + prod.getProdname() + "</td>";
				message += "</tr>";
			}
			message += "</tbody></table>";
			message += "</div>";
			
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/OurProducts.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

}
