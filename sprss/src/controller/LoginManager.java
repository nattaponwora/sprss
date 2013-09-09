package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.User;
import model.AuthenModel;

/**
 * Servlet implementation class Authen
 */
@WebServlet(description = "Login Page", urlPatterns = { "/loginmanager" })
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("logout");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			String eid = (String) request.getParameter("eid");
			String password = (String) request.getParameter("password");
			User u = AuthenModel.checkAuthen( eid , password );
			if( u != null ){
				session.setAttribute("isLogin", true);
				session.setAttribute("userData", u);
				response.sendRedirect("requisition");
			}else{
				session.setAttribute("loginFalse", true);
				response.sendRedirect("login");
			}
		}catch( NoSuchAlgorithmException e ){
			request.setAttribute("header", "Error NoSuchAlgorithmException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
		}catch( UnsupportedEncodingException e ){
			request.setAttribute("header", "Error UnsupportedEncodingException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
		} catch (SQLException e) {
			request.setAttribute("header", "Error SQLException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
		}
	}

}