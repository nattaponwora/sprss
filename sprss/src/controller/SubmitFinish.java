package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SubmitFinishModel;

/**
 * Servlet implementation class SubmitFinish
 */
@WebServlet("/submitfinish")
public class SubmitFinish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitFinish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int req_id = Integer.valueOf(request.getParameter("finish"));
		//System.out.println(req_id);
		try{
			SubmitFinishModel.updateStatus( req_id );
			response.sendRedirect("show");
			//System.out.println("update");
		} catch( SQLException e ){
			e.printStackTrace();
		}
		
	}

}
