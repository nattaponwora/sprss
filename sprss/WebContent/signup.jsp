<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    	<div class="navbar navbar-inverse" style="position: static;">
            <div class="navbar-inner">
                <div class="container">
                  	<ul class="nav nav-pills">
					  <li><a href="index.jsp">Home</a></li>
					  <li><a href="main.jsp">Selecting</a></li>
					  <li><a href="view.jsp">View</a></li>
					</ul>
                    <span align="right" style="margin-left:65em"><button class="btn btn-mini btn btn-success disabled" type="button">User: Nuttareepan.r</button></span>     
                    <span align="right"><button class="btn btn-mini btn btn-danger" type="button">Log Out</button></span>
                </div>
            <!-- /navbar-inner -->
            </div>
        </div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br>
		<h1><font size="4" face="Tahoma" color="#493D26">Register</font></h1><br></center>
			<div class="container">
				<form class="form-horizontal" style="margin-left:12em">
					<div class="control-group">
				    	<label class="control-label" for="inputPassword">First Name</label>
				    		<div class="controls">
				      			<input type="password" id="inputPassword" placeholder="First Name">
				    		</div>
				 	</div>

				 	<div class="control-group">
				    	<label class="control-label" for="inputPassword">Last Name</label>
				    		<div class="controls">
				      			<input type="password" id="inputPassword" placeholder="Last Name">
				    		</div>
				 	</div>

					<div class="control-group">
				    	<label class="control-label" for="inputPassword">UL number</label>
				    		<div class="controls">
				      			<input type="password" id="inputPassword" placeholder="UL number">
				    		</div>
				 	</div>

				 	<div class="control-group">
				    	<label class="control-label" for="inputPassword">Position</label>
				    		<div class="controls">
				      			<select>
								  <option>Head Office</option>
								  <option>Administrator</option>
								  <option>Employee</option>
								  <option>Staff</option>
								</select>
				    		</div>
				 	</div>

					<div class="control-group">
				    	<label class="control-label" for="inputEmail">Email</label>
				   			<div class="controls">
				      			<input type="text" id="inputEmail" placeholder="Email Lotus note">
				   			</div>
				  	</div>
				  	<div class="control-group">
				    	<label class="control-label" for="inputPassword">Tel.</label>
				    		<div class="controls">
				      			<input type="password" id="inputPassword" placeholder="Telephone number">
				    		</div>
				  	</div>
				  	</form><br>
				  	<div class="control-group" style="margin-left:22em">
				    	<div class="controls">
				      		<a href="regis.jsp" class="btn btn-large btn-primary">Submit</a>
							<a href="#" class="btn btn-large">Clear</a>
				    	</div>
				  	</div>

				
	</div>


</body>
</html>