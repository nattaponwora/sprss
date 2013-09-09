package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import model.AuthenModel;
import model.StatementManager;

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
    	try{
    		request.setCharacterEncoding("UTF-8");
    		Statement stm =  StatementManager.getSQLStatement();
    		String fname = (String) request.getParameter("firstname");
        	String lname = (String) request.getParameter("lastname");
        	String eid = (String) request.getParameter("empID");
        	String tel = (String) request.getParameter("tel");
        	String email = (String) request.getParameter("email");
        	String usergroup = (String) request.getParameter("usergroup");
        	String plant = (String) request.getParameter("plant");    	
        	String storeRoom = (String) request.getParameter("storeRoom");
        	String password = "1234";
        	String hpass = AuthenModel.hashPassword(password);
        	
    		String query = "INSERT INTO user (password, firstname, lastname, eid , email, tel, usergroup, plant, storeroom) "
    				+ "VALUE ('"+ hpass +"' ,'"+ fname +"' , '"+ lname +"' ,'"+ eid +"' ,'"+ email +"' ,'"+ tel +"' ,"
    				+ "'"+ usergroup +"' ,'"+ plant +"' ,'"+ storeRoom +"')";
    		
    		System.out.println("RegisterManager:doRegister = " + query);
    		
    		int r = stm.executeUpdate( query);
    		if( r > 0){
    			request.setAttribute("firstname", fname);
    			request.setAttribute("lastname", lname);
    			request.setAttribute("eid", eid);
    			request.setAttribute("tel", tel);
    			request.setAttribute("email", email);
    			request.setAttribute("usergroup", usergroup);
    			request.setAttribute("plant", plant);
    			request.setAttribute("storeRoom", storeRoom);
    			request.setAttribute("password", password);
    			
    			RequestDispatcher obj = request.getRequestDispatcher("registersuccess.jsp");
    			obj.forward(request,response);
    		}
    	}catch ( SQLException e ){
    		System.out.println("SQLException");
    		request.setAttribute("header", "Error SQLException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
    	}catch (NoSuchAlgorithmException e){
    		System.out.println("NoSuchAlgorithmException");
    		request.setAttribute("header", "Error NoSuchAlgorithmException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
    	}
    }
    
}
