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
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br>
	<div class="container">
		<center><h1 style="margin-top:0em"><font size="3" face="Tahoma" color="#008000">Register Successful</font></h1><br>	
		<h>รหัสพนักงาน : <%= request.getAttribute("eid") %> </h> <br>	
		<h>รหัสผ่าน : <%= request.getAttribute("password") %> </h> <br>	
		<h>ชื่อ : <%= request.getAttribute("firstname") %> </h> <br>	
		<h>นามสกุล : <%= request.getAttribute("lastname") %> </h> <br>	
		<h>เบอร์โทรศัพท์ : <%= request.getAttribute("tel") %> </h> <br>	
		<h>email : <%= request.getAttribute("email") %> </h> <br>	
		<h>Plant : <%= request.getAttribute("plant") %> </h> <br>	
		<h>StoreRoom : <%= request.getAttribute("storename") %> </h> <br>	
		<h>กลุ่มผู้ใช้ : <%= request.getAttribute("usergroup") %> </h> <br>	
</div> <br> <a href="login.jsp"><button type="button" class="btn" onclick = "location.href = 'login.jsp'">Back to Login</button></a>
	</div></center>


</body>
</html>