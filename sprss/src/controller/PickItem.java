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

import object.User;

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
		String pid = request.getParameter("picker");
		HttpSession sess = request.getSession();
		ArrayList<User> p = (ArrayList<User>) sess.getAttribute("picker");
		User u = null;
		for( int i= 0 ; i < p.size() ; i++ ){
			if ( p.get(i).getID() == Integer.parseInt(pid) ){
				u = p.get(i);
				break;
			}
		}
		request.setAttribute("picker", u );
		RequestDispatcher obj = request.getRequestDispatcher("pickinglist.jsp");
		obj.forward(request,response);
	}

}
