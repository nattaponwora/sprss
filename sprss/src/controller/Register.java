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
    	String fname = (String) request.getAttribute("firstname");
    	String lname = (String) request.getAttribute("lastname");
    	String eid = (String) request.getAttribute("empID");
    	String tel = (String) request.getAttribute("tel");
    	String email = (String) request.getAttribute("email");
    	String position = (String) request.getAttribute("position");
    	String storeRoom = (String) request.getAttribute("storeRoom");
    	String site = (String) request.getAttribute("site");
    	
    	request.setAttribute( "mes", fname + " " + lname + " " + eid + " " + tel + " " + email + " " + position + " " + storeRoom + " " + site);
		RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
		obj.forward(request,response);
    }
    
}
