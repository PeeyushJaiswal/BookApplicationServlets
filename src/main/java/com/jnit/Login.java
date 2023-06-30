package com.jnit;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
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

		try {
			ps = con.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			HttpSession hs = request.getSession();

			PrintWriter pw = response.getWriter();
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
//				pw.println("<h1 align='center'>Login Successfully</h1>");
				hs.setAttribute("username", username);
				hs.setAttribute("id", rs.getInt(1));
				response.sendRedirect("./home.html?msg=success");
			}else {
				response.sendRedirect("./login.html?msg=failed");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
