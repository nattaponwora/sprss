<%@ page import="model.StatementManager" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		PrintWriter o = response.getWriter();
	
		Statement stmt = StatementManager.getSQLStatement();
		String sql = "SELECT * FROM user";
		ResultSet result  = stmt.executeQuery(sql);
		result.next();
		String res = result.getString("firstname")+ " " +result.getString("lastname");
		o.println(res);
		o.close();
	%>
</body>
</html>