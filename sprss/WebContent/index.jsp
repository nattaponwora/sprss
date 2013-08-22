<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Spare Part Requisition Smart System</title>
<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
                <div class="container">
                  <ul class="nav nav-pills">
					  <li class="active">
					    <a href="index.jsp">Home</a>
					  </li>
					  <li><a href="main.jsp">Selecting</a></li>
					  <li><a href="view.jsp">View</a></li>
					</ul>
                    <!-- vertical line -->  
                    <li class="divider-vertical" style="margin-left:80em"></li>             
                </div>
              </div><!-- /navbar-inner -->
      		</div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br>
	<div class="container">
		<form>
			<span style="margin-right:1em">User ID  </span>:<input type="text" name="id"><br>
			<span style="margin-right:0.6em">Password</span>:<input type="text" name="password">
		</form>
		<button type="submit" class="btn" style="margin-left:5em">Sign in</button><a href="signup.jsp" style="margin-left:0.5em"><font size="3" face="Tahoma">Sign up</font></a>
	</div></center>


</body>
</html>