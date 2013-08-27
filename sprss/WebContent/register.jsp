<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
	<!-- Bootstrap -->
	<img src = "img/cpr_logo.png">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    	<div class="navbar navbar-inverse" style="position: static;">
            <div class="navbar-inner">
                <div class="container">
                  	<ul class="nav nav-pills">
					  <li><a href="login.jsp">Login</a></li>					 
					</ul>                    
                </div>
            <!-- /navbar-inner -->
            </div>
        </div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br>
		<h1><font size="4" face="Tahoma" color="#493D26">ลงทะเบียน</font></h1><br></center>
			<div class="container">
				<form class="form-horizontal" style="margin-left:12em" action = "register" method = "post">
				
				
					<div class="control-group">
				    	<label class="control-label" for="inputEmpID">รหัสพนักงาน</label>
				    		<div class="controls">
				      			<input type="text" id="inputEmpID" name="empID">
				    		</div>
				 	</div>
				 	
				 	<div class="control-group">
				    	<label class="control-label" for="inputPassword">รหัสผ่าน</label>
				    		<div class="controls">
				      			<input type="password" id="inputPassword" name="password">
				    		</div>
				 	</div>
				 	
					<div class="control-group">
				    	<label class="control-label" for="inputFirstname">ชื่อ</label>
				    		<div class="controls">
				      			<input type="text" id="inputFirstname" name="firstname">
				    		</div>
				 	</div>

				 	<div class="control-group">
				    	<label class="control-label" for="inputLastname">นามสกุล</label>
				    		<div class="controls">
				      			<input type="text" id="LastName" name="lastname">
				    		</div>
				 	</div>					

				 	<div class="control-group">
				    	<label class="control-label" for="inputPassword">ตำแหน่ง</label>
				    		<div class="controls">
				      			<select name="position">
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
				      			<input type="text" id="inputEmail" name="email">
				   			</div>
				  	</div>
				  	<div class="control-group">
				    	<label class="control-label" for="inputTelNum">เบอร์โทรศัพท์</label>
				    		<div class="controls">
				      			<input type="text" id="inputTelNum" name="tel">
				    		</div>
				  	</div>
				  	
				  	<div class="control-group">
				    	<label class="control-label" for="inputPlant">Plant</label>
				    		<div class="controls">
				      			<input type="text" id="inputPlant" name="plant">
				    		</div>
				  	</div>
				  	<button type="submit" class="btn btn-medium btn-primary" style="margin-left:14em">ลงทะเบียน</button>
				  	<button type="reset" class="btn" style="margin-left:0.5em" onclick = "location.href = 'login.jsp'">ยกเลิก</button>
				  	</form><br> 	

				
	</div>


</body>
</html>