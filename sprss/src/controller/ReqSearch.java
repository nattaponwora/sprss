package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SearchModel;
import object.PickingRequisition;
import object.Requisition;
import object.RequisitionList;

/**
 * Servlet implementation class ReqSearch
 */
@WebServlet("/reqsearch")
public class ReqSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("page", "reqsearch");
		request.setAttribute("isSearch", false);
		RequestDispatcher obj = request.getRequestDispatcher("search.jsp");
		obj.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("page", "reqsearch");
		String req = request.getParameter("req");
		String plant = request.getParameter("plant");
		String storeroom = request.getParameter("storeroom");
		try {
			Integer.parseInt(req);
			Requisition rl = SearchModel.searchReq(req, plant , storeroom);
			PickingRequisition selReq = SearchModel.getSelReq(req, plant, storeroom);
			request.setAttribute("req", rl );
			request.setAttribute("selReq", selReq );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		}
		request.setAttribute("isSearch", true);
		RequestDispatcher obj = request.getRequestDispatcher("search.jsp");
		obj.forward(request,response);
		
	}

}
