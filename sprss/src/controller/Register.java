package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doRegister( request , response );
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRegister( request , response );
	}
    
    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String fname = (String) request.getParameter("firstname");
    	String lname = (String) request.getParameter("lastname");
    	String eid = (String) request.getParameter("empID");
    	String tel = (String) request.getParameter("tel");
    	String email = (String) request.getParameter("email");
    	String position = (String) request.getParameter("position");
    	String storeRoom = (String) request.getParameter("storeRoom");
    	String site = (String) request.getParameter("site");
    	
    	String password = (String) request.getParameter("password");
    	
    	request.setAttribute( "mes", fname + " " + lname + " " + eid + " " + tel + " " + email + " " + position + " " + storeRoom + " " + site);
		RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
		obj.forward(request,response);
    }
    
}
