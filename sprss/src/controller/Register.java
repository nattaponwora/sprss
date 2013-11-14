package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.User;
import object.Warehouse;
import model.WarehouseManagerModel;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("page", "register");
		String errString = request.getParameter("err");
		int err = 0;
		if( errString != null ){
			err = Integer.parseInt( request.getParameter("err") );
		}
		if( err == 1 ){
			request.setAttribute("err", err);
		}
		try {
			User u = (User)session.getAttribute("userData");
			ArrayList<Warehouse> wh;
			if(u.getUsergroup() == 1 ){
				 wh = WarehouseManagerModel.getWarehouse();
			}else{
				 wh = WarehouseManagerModel.getWarehouse( u.getPlant() , u.getStoreroom() );
			}
			request.setAttribute("warehouse", wh);
			RequestDispatcher obj = request.getRequestDispatcher("register.jsp");
			obj.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
