<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>The Spare Part Requisition Smart System</title>
<!-- Bootstrap -->
	<div>
		<div style="float:left"><img src = "img/cpr_logo.png"></div>
		<div align="right"><img src = "img/sprem.png"></div>
	</div>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">                
              </div><!-- /navbar-inner -->
      		</div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">RSSM : Spare Part Requisition Management</font></h1><br>
	<%
		
		if( session.getAttribute("loginFalse") != null ){
			if( ((Boolean)session.getAttribute("loginFalse")) ){
	%>
	<center><h1 style="margin-top:0em"><font size="3" face="Tahoma" color="#FF0000">Incorrect username or password</font></h1><br>
	<%
			}
			session.invalidate();
		}
	%>
	<div class="container">
		<form action = "loginmanager" method = "post">
			<span style="margin-right:0.5em">รหัสพนักงาน  </span>:<input type="text" name="eid"><br>
			<span style="margin-right:2.5em">รหัสผ่าน</span>:<input type="password" name="password"><br>
			<button type="submit" class="btn" style="margin-left:5em">เข้าสู่ระบบ</button>
		</form>		
	</div></center>


</body>
</html>