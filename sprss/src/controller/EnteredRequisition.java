package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EnteredRequisitionModel;
import object.Requisition;
import object.RequisitionList;
import object.User;

/**
 * Servlet implementation class EnteredRequisition
 */
@WebServlet("/requisition")
public class EnteredRequisition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnteredRequisition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequisitionList(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequisitionList(request, response);
	}
	
	/**
	 * จัดการเรียกข้อมูลต่างๆส่งไปให้หน้า requisition.jsp แสดงผลรายการใบหยิบอะไหล่ที่ยังไม่ได้หยิบ
	 * 
	 * <b>Request Attribute</b>
	 * user Class User ข้อมูลผู้ที่ทำการ Login
	 * picker ArrayList ผู้ที่มีสิทธิ์หยิบอะไหล่ใน Plant ของผู้ที่ทำการ Login 
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequisitionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plant = (String) request.getAttribute("plant");
		
		ArrayList<String> picker = EnteredRequisitionModel.getPicker(plant);
		request.setAttribute("picker", picker);
		
		RequisitionList req = EnteredRequisitionModel.getEnterReqList(plant);
		request.setAttribute("reqList", req);
		
		RequestDispatcher obj = request.getRequestDispatcher("requisition.jsp");
		obj.forward(request,response);
	}
	
}
