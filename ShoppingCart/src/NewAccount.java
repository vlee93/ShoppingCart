import javax.persistence.EntityManager;

import customTools.DBShopUser;
import customTools.DBUtil;
import model.Shopuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NewAccount")
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewAccount() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		
		try{
			Shopuser u = new Shopuser();
			u.setFullname(name);
			u.setEmail(email);
			u.setUsername(username);
			u.setUserpass(userpass);
			u.setUsertype("regular");
			DBShopUser.insert(u);
			getServletContext().getRequestDispatcher("/ProdList").forward(request, response);
		}catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
	}

}
