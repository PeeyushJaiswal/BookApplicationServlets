package com.jnit;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
	Connection con = null;
	PreparedStatement ps = null;
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db1";
			String username = "root";
			String  password = "rootpassword";
			con=DriverManager.getConnection(url, username, password);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int mobile = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		try {
			ps = con.prepareStatement("insert into login (username,password,phone,email,address) values (?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setInt(3,mobile);
			ps.setString(4,email);
			ps.setString(5,address);
			int x = ps.executeUpdate();
			PrintWriter pw = response.getWriter();
			if(x!=0) {
//				pw.println("<h1 align='center'>Registered Successfully</h1>");
				// can also use request dispatcher to redirect (search on Google)
				response.sendRedirect("./login.html?msg=success");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
