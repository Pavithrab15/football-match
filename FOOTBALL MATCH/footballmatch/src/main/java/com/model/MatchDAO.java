
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDAO {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        
        public MatchDAO() {
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdata" , "root", "root");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        }
     
        public void StoreData(Match m) {
        	String sql = "insert into matchdetails (title, place, dt) values (?,?,?) ";

        	try {
				pst = con.prepareStatement(sql);
				pst.setString(1,m.getTitle());
				pst.setString(2, m.getPlace());
				pst.setString(3, m.getDt());
				pst.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
        }
        	public ResultSet retrieveMatch(){
        		String sql="select * from matchdetails";
        	try {	
        	pst=con.prepareStatement(sql);
        	rs=pst.executeQuery();
        	}catch(SQLException e)
        	{
        		e.printStackTrace();
        	}
        	return rs;
        	
        }
}