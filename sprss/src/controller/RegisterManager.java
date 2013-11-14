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










import object.Warehouse;
import model.AuthenModel;
import model.StatementManager;
import model.WarehouseManagerModel;

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
    		String warehouse = request.getParameter("ware_id");
    		String plant = null;
    		String storeroom = null;
    		if( warehouse != null ){
    			int wid = Integer.parseInt( warehouse );
    			Warehouse w = WarehouseManagerModel.getWarehouseByID(wid);
    			plant = w.getPlant();
    			storeroom = w.getStoreroom();
    		}
    		String fname = (String) request.getParameter("firstname");
        	String lname = (String) request.getParameter("lastname");
        	int eid = Integer.parseInt(request.getParameter("empID"));
        	String tel = (String) request.getParameter("tel");
        	if( tel.equals("")){
        		tel = "-";
        	}
        	String email = (String) request.getParameter("email");
        	if( email.equals("") ){
        		email = "-";
        	}
        	int usergroup = Integer.parseInt(request.getParameter("usergroup"));
        	String password = "1234";
        	String hpass = AuthenModel.hashPassword(password);
        	boolean registerResult = AuthenModel.register(fname, lname, eid,tel,email,usergroup,plant,storeroom,hpass);
    		if( registerResult == true ){
    			request.setAttribute("firstname", fname);
    			request.setAttribute("lastname", lname);
    			request.setAttribute("eid", eid);
    			request.setAttribute("tel", tel);
    			request.setAttribute("email", email);
    			request.setAttribute("usergroup", usergroup);
    			if( usergroup != 1 ){
    				request.setAttribute("plant", plant);
    				request.setAttribute("storeRoom", storeroom);
    			}
    			request.setAttribute("password", password);
    			
    			RequestDispatcher obj = request.getRequestDispatcher("registersuccess.jsp");
    			obj.forward(request,response);
    		}else{
    			response.sendRedirect("register?err=1");
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
