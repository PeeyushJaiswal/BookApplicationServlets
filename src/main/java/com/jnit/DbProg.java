package com.jnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbProg {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db1";
		String username = "root";
		String  password = "rootpassword";
		
		try {
			con=DriverManager.getConnection(url, username, password);
		}catch (Exception e){
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.println("Connection Established");
		}
//		Statement st = con.createStatement();
//		
//		int x = st.executeUpdate("insert into Students values(1,'John',78)");
//		if(x!=0)System.out.println("Record inserted");
//		
//		ResultSet rs = st.executeQuery("select * from Students");
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("marks"));
//		}
	}
 
}
