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

import object.Warehouse;
import model.WarehouseManagerModel;

/**
 * Servlet implementation class WarehouseManager
 */
@WebServlet("/warehouse")
public class WarehouseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarehouseManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			ArrayList<Warehouse> wh = WarehouseManagerModel.getWarehouse();
			request.setAttribute("warehouse", wh);
			String mes = (String) request.getParameter("mes");
			if( mes != null  ){
				request.setAttribute("mes", mes );
			}
			session.setAttribute("page", "warehouse");
			RequestDispatcher obj = request.getRequestDispatcher("warehouse.jsp");
			obj.forward(request,response);
		}catch(SQLException e){
			request.setAttribute("header", "Error SQLException");
			request.setAttribute("message", e.getMessage());
			RequestDispatcher obj = request.getRequestDispatcher("error");
			obj.forward(request,response);
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
