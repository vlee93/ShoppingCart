import javax.persistence.EntityManager;
import javax.persistence.metamodel.SetAttribute;

import customTools.DBShopUser;
import customTools.DBUtil;
import model.Shopuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Logout() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		String LogOut = "<div class=\"alert alert-info\"><strong>Logged Out</strong> You have successfully logged out.</div>";
		request.setAttribute("loggedout", LogOut);
		getServletContext().getRequestDispatcher("/ShopLogin.jsp").forward(request, response);
	}

}
