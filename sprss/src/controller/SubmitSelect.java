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

import object.Item;
import object.ItemList;
import object.Requisition;
import object.RequisitionList;
import object.User;
import model.EnteredRequisitionModel;

/**
 * Servlet implementation class SubmitSelect
 */
@WebServlet("/submitselreq")
public class SubmitSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitSelect() {
        super();
        // TODO Auto-generated constructor stub
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
		
		try {
			boolean dup;
			dup = EnteredRequisitionModel.checkDup(reqList);
			if( dup ){
				response.sendRedirect("requisition?err=dup");
				return;
			}
			/*
			 * หา Object สำหรับผู้หยิบอะไหล่ที่เลือก
			 */
			String pid = request.getParameter("picker");
			ArrayList<User> p = (ArrayList<User>) sess.getAttribute("picker");
			//sess.removeAttribute("picker");
			RequisitionList allReq = (RequisitionList) sess.getAttribute("reqList");
			//sess.removeAttribute("reqList");
			RequisitionList selectReq = new RequisitionList();
			ItemList itemList = new ItemList();
			
			//รับข้อมูลผู้ที่หยิบอะไหล่
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
				ItemList list = selectReq.get(selectOrder).getItemList();
				for ( int i = 0 ; i < list.size() ; i++ ){
					Item item = list.get(i);
					itemList.add( item );
				}
			}
			
			int id;
			id = EnteredRequisitionModel.insertSelectRequisition( u, selectReq,itemList);
			response.sendRedirect("pickinglist?id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
