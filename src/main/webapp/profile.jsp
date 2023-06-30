<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Application</title>
</head>
<body bgcolor="wheat">
	<br><br>
	<h1 align="center">Welcome to Book Application</h1>
	<br><br>
	
	<h1 align="center">
		<a href="profile.jsp">Profile</a> |
		<a href="add_book.jsp">Add Book</a> |
		<a href="view_book.jsp">View Book</a> |
		<a href="index.html">Logout</a>
	</h1>
	<br><br>
	<%@page import="java.sql.*" %>
	<table border="2" width="90%" height="200" cellpading="20" align="center">
		<tr>
			<td>Id</td>
			<td>Username</td>
			<td>Phone</td>
			<td>Email</td>
			<td>Address</td>
			
		</tr>
			<%
				Connection con = null;
				PreparedStatement ps = null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/db1";
				String username = "root";
				String  password = "rootpassword";
				con=DriverManager.getConnection(url, username, password);
				int id = (Integer)session.getAttribute("id");
				ps = con.prepareStatement("select * from login where id=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
			%>
		
			<% while(rs.next()){ %>
				<tr>
					<td><%=rs.getInt(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getInt(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
				</tr>
			<% } %>
		
	</table>
</body>
</html>