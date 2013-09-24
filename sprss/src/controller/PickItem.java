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

import model.EnteredRequisitionModel;
import object.Item;
import object.Requisition;
import object.RequisitionList;
import object.User;
import object.ItemList;

/**
 * Servlet implementation class PickItem
 */
@WebServlet("/pickinglist")
public class PickItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PickItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id = Integer.parseInt( request.getParameter("id") );
			RequisitionList selectReq = EnteredRequisitionModel.getSelectRequisition( id );
			ItemList itemList = EnteredRequisitionModel.getItemListBySelID(id);
			User u = EnteredRequisitionModel.getSelPicker(id);
			request.setAttribute("picker", u );
			request.setAttribute("reqList", selectReq);
			request.setAttribute("itemList", itemList);
			request.setAttribute("id", id);
			RequestDispatcher obj = request.getRequestDispatcher("pickinglist.jsp");
			obj.forward(request,response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
