package com.cont;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddPlayerController
 */
@WebServlet("/AddPlayerCont")
@MultipartConfig(maxFileSize=999999999)
public class AddPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vsbdata";
	String unm="root";
	String pswd="YES";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String a=request.getParameter("age");
		int age =Integer.parseInt(a);
		InputStream istrm =null;
		Part fp=request.getPart("profile");
		if(fp!=null) {
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm=fp.getInputStream();
		}
		Connection con=null;
		String msg=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(url,unm, pswd);
		     String sql="insert into playerdata(name, age, profile) values(?, ?, ?)";
		     PreparedStatement pst =con.prepareStatement(sql);
		     pst.setString(1,name);
		     pst.setInt(2, age);
		     if(istrm!=null) {
		    	 pst.setBlob(3,istrm);
		     }
		     int res=pst.executeUpdate();
		     if(res>0) {
		    	 msg="Player data Uploaded successfully";
		     }
		     con.close();
		     }
		catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Message.html").forward(request,response);
	}

}