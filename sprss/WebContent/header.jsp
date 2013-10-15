<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="object.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>RSSM : SPRM</title>
<!-- Bootstrap -->
	<% 
		User hUser = (User) session.getAttribute("userData"); 
		String this_page = (String) session.getAttribute("page");
	%>	
	<img src = "img/cpr_logo.png">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
                <div class="container">
                  <ul class="nav nav-pills">
					  <li<%= this_page.equals("requisition") ? " class=\"active\"" : ""  %>><a href="requisition">ใบเบิกอะไหล่</a></li>					  
					  <li<%= this_page.equals("show") ? " class=\"active\"" : ""  %>><a href="show">ใบหยิบที่กำลังดำเนินการ</a></li>
					  <li<%= this_page.equals("finish") ? " class=\"active\"" : ""  %>><a href="finish">ข้อมูลการหยิบอะไหล่</a></li>
					  <li<%= this_page.equals("warehouse") ? " class=\"active\"" : ""  %>><a href="warehouse">คลังสินค้า</a></li>
					  <li<%= this_page.equals("register") ? " class=\"active\"" : ""  %>><a href="register">ลงทะเบียนสมาชิก</a></li>
					</ul>
					<span><button style="float: right;" class="btn btn-mini btn btn-danger" type="button" onclick = "location.href = 'logout'">Log Out</button></span>
					<span style="float: right;" >&nbsp;</span>
                 	<span><button style="float: right;" class="btn btn-mini btn btn-success disabled" type="button">User: <%= hUser.getName() %></button></span>    
                 	
                </div>
              </div><!-- /navbar-inner -->
            </div>
            <center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26"> RSSM : Spare Part Requisition Management <font color="blue" size="3"><i>(1.0 alpha)</i></font> </font></h1><br></center>
</head>
<body>
	
</body>
</html>