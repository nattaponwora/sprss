<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>The Spare Part Requisition Smart System</title>
<!-- Bootstrap -->
	<img src = "img/cpr_logo.png">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
              </div><!-- /navbar-inner -->
            </div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">RSSM : Spare Part Requisition Management</font></h1><br>
	<div class="container">
		<center><h3><font color="red"><%= (String)request.getAttribute("header") %></font></font></h1></center><br>
		<center><h4><font color="blue"><b>สาเหตุ : <%= (String)request.getAttribute("message") %></b></font></h4></center><br>
		<center><h1 style="margin-top:0em"><font size="3" face="Tahoma" color="#FF0000">โปรดติดต่อเจ้าหน้าที่</font></h1><br>
</div> <br> <a href="login.jsp"><button type="button" class="btn" onclick = "location.href = 'login.jsp'">Back to Login</button></a>
	</div></center>


</body>
</html>