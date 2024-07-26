package com.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Match;
import com.model.MatchDAO;

/**
 * Servlet implementation class AddMatchController
 */
@WebServlet("/AddMatchCont")
public class AddMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title =request.getParameter("title").trim();
		String place=request.getParameter("place").trim();
		String date=request.getParameter("date").trim();
		ArrayList<String> list=new ArrayList<String>();
		
		if(title.length()==0)
		  list.add("Enter title field");
		if(place.length()==0)
			list.add("Enter place field");
		if(date.length()==0) {
			list.add("Enter date");
		}
		if(!list.isEmpty()) {
			request.setAttribute("errors", list);
			RequestDispatcher rd=request.getRequestDispatcher("AddMatchForm");
			rd.forward(request, response);
		//	return ;
		}
	
	Match m = new Match(title, place, date);
	MatchDAO md=new MatchDAO();
	md.StoreData(m);
	RequestDispatcher rd1=request.getRequestDispatcher("Acknowledge.html");
	rd1.forward(request, response);
	}
}