package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPlayerFormServlet
 */
@WebServlet("/AddPlayerForm")
public class AddPlayerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> list=(ArrayList<String>)request.getAttribute("errors");
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		if(list!=null) {
			Iterator <String> itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext()) {
				out.println("<li>"+itr.next()+"</li>");
			}
			out.println("</ul>");
		}
		out.println("<h2> Add Player Details</h2>");
		out.println("<form action='AddPlayerCont' method='post' enctype='multipart/form-data'>");
		out.println("Name<input type='text' name='name'> <br/><br/>");
		out.println("Age<input type='integer' name='age' value='0'> <br><br>");
		out.println("Profile<input type='file' name='profile'> <br><br>");
		out.println("<input type='submit' value='Submit'> <br><br>");
		out.println("</form> </center> </body> </html>");
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	

	}
	}
