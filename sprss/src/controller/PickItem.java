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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		/*
		 * จัดการใบจองอะไหล่ที่ต้องการ
		 */
		String[] reqList = request.getParameterValues("req");
		
		
		/*
		 * หา Object สำหรับผู้หยิบอะไหล่ที่เลือก
		 */
		String pid = request.getParameter("picker");
		//ArrayList<User> p = (ArrayList<User>) request.getAttribute("picker");
		ArrayList<User> p = (ArrayList<User>) sess.getAttribute("picker");
		RequisitionList allReq = (RequisitionList) sess.getAttribute("reqList");
		RequisitionList selectReq = new RequisitionList();
		ItemList itemList = new ItemList();
		
		User u = null;
		for( int i = 0 ; i < p.size() ; i++ ){
			if ( p.get(i).getID() == Integer.parseInt(pid) ){
				u = p.get(i);
				break;
			}
		}	
		request.setAttribute("picker", u );

		int reqOrder = 0; // ลำดับที่ใบใบสั่งอะไหล่ทั้งหมด
		for ( int selectOrder = 0 ; selectOrder < reqList.length ; selectOrder++){
			while( reqOrder < allReq.size() ){
				Requisition r = allReq.get( reqOrder );
				int checkReqID  = Integer.parseInt( reqList[ selectOrder ] );
				if( checkReqID == r.getReqID() ){
					selectReq.add(r);
					break;
				}
				reqOrder++;
			}
			ArrayList<Item> list = selectReq.get(selectOrder).getItemList();
			for ( int i = 0 ; i < list.size() ; i++ ){
				Item item = list.get(i);
				itemList.add( item );
			}
		}
		
		for ( int i=0 ; i < itemList.size() ; i++ ){
			System.out.println(itemList.getItem(i).getItemnum() + "  " + itemList.getItem(i).getReqID() +"   " + itemList.getItem(i).getDescription() + "    " +itemList.getItem(i).getAssetNO());
		}
			
		request.setAttribute("reqList", selectReq);
		request.setAttribute("itemList", itemList);
		
		try {
			int id = EnteredRequisitionModel.insertSelectRequisition( u, selectReq,itemList);
			request.setAttribute("id", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//เปลี่ยนหน้า
		RequestDispatcher obj = request.getRequestDispatcher("pickinglist.jsp");
		obj.forward(request,response);
	}

}
