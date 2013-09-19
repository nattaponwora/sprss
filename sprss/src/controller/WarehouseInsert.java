package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.DuplicateDataException;
import model.WarehouseManagerModel;

/**
 * Servlet implementation class WarehouseInsert
 */
@WebServlet("/warehouseinsert")
public class WarehouseInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarehouseInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plant = request.getParameter("plant");
		String storeroom = request.getParameter("storeroom");
		try{
			WarehouseManagerModel.insertWarehouse(plant, storeroom);
			response.sendRedirect("warehouse?mes=0");
		}catch(SQLException e){
			response.sendRedirect("warehouse?mes=1");
		}catch(DuplicateDataException e){
			response.sendRedirect("warehouse?mes=2");
		}
		
		// TODO Auto-generated method stub
	}

}
