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
    <link rel="stylesheet" href="bootstrap/Table_zebra/css/blue.css" type="text/css">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
              </div><!-- /navbar-inner -->
            </div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">RSSM : Spare Part Requisition Management</font></h1><br>
	
		<center><h1 style="margin-top:0em"><font size="3" face="Tahoma" color="#008000">Register Successful</font></h1><br>	
		<table width="350px">
		<tr>
			<td><font color = "#1569C7">รหัสพนักงาน : </font><%= request.getAttribute("eid") %><br></td>
		</tr>			
		<tr>
			<td><font color = "#1569C7">รหัสผ่าน : </font><%= request.getAttribute("password") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">ชื่อ : </font><%= request.getAttribute("firstname") %><br>	</td>
		</tr>
		<tr>
			<td><font color = "#1569C7">นามสกุล : </font><%= request.getAttribute("lastname") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">เบอร์โทรศัพท์ : </font><%= request.getAttribute("tel") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">email : </font><%= request.getAttribute("email") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">Plant : </font><%= request.getAttribute("plant") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">Store Room : </font><%= request.getAttribute("storeRoom") %><br></td>
		</tr>
		<tr>
			<td><font color = "#1569C7">กลุ่มผู้ใช้ : </font><%= request.getAttribute("usergroup") %><br></td>
		</tr>
			
		</table>
	 <br> 
	 <a href="register"><button type="button" class="btn" onclick = "location.href = 'register'">Back to Register</button></a>
	</div></center>

</body>
</html>