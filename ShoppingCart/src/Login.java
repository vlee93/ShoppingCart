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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		Shopuser u = new Shopuser();
		u.setUsername(username);
		u.setUserpass(userpass);
		long userid = DBShopUser.isValidUser(u);
		Shopuser user = DBShopUser.getUser(userid);
		HttpSession session = request.getSession();
		
		try{
			if ((userid) > 0)
			{
				session.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/ProdList").forward(request, response);
			}
			else
			{
				String error = "<div class=\"alert alert-danger\"><strong>Error!</strong> You entered the wrong username or password.</div>";
				request.setAttribute("error", error);
				getServletContext().getRequestDispatcher("/ShopLogin.jsp").forward(request, response);
			}
		}catch (Exception e)
		{
			System.out.println(e);
		} finally{
			em.close();
		}
	}

}
