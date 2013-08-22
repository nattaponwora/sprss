package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String username = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		if( checkAuthen( username , password ) ){
			request.setAttribute( "mes", "Success" );
			RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
			obj.forward(request,response);
		}else{
			request.setAttribute( "mes", "Fail" );
			RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
			obj.forward(request,response);
		}
	}
	
	public boolean checkAuthen( String username , String password){
		return true;
	}

}
