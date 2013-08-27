package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authen
 */
@WebServlet(description = "Login Page", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String eid = (String) request.getParameter("eid");
		String password = (String) request.getParameter("password");
		if( checkAuthen( eid , password ) ){
			session.setAttribute("isLogin", true);
			response.sendRedirect("requisition");
		}else{
			session.setAttribute("loginFalse", true);
			response.sendRedirect("requisition");
			//request.setAttribute( "mes", "Fail" );
			//RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
			//obj.forward(request,response);
		}
	}
	
	private boolean checkAuthen( String eid , String password){
		if( eid.equals(password) )
			return true;
		else
			return false;
	}

}
