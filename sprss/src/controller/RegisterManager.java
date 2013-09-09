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
@WebServlet("/registermanager")
public class RegisterManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterManager() {
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
    	String plant = (String) request.getParameter("plant");    	
    	String storeRoom = (String) request.getParameter("storeRoom");
    	
    	request.setAttribute( "mes",eid + " " + fname + " " + lname + " " + " " +tel + " " + email + " " + position + " " + plant + " "+ storeRoom);
		RequestDispatcher obj = request.getRequestDispatcher("test.jsp");
		obj.forward(request,response);
    }
    
}
