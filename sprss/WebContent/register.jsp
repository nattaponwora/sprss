<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="bootstrap/form/style.css">
</head>
<body background="img/indexBG.jpg">
<%@ include file = "header.jsp" %>				
			
			<div id="signup-form">
	        
	        <!--BEGIN #subscribe-inner -->
	        
	        
	        	<div class="clearfix" id="header">       		
	        
	                <center><h1><font size="4" face="Tahoma" color="#493D26">ลงทะเบียน</font></h1><br></center>
	            
	            </div>
	            
	            <form id="send" action = "registermanager" method = "post">
	            	
	                
	                <label for="inputEmpID"><b>รหัสพนักงาน</b></label>
	               	<input type="text" id="inputEmpID" name="empID">
	                
	                
	                
	                <label class="control-label" for="inputFirstname"><b>ชื่อ</b></label>						    		
					<input type="text" id="inputFirstname" name="firstname">
	                
	                
	                
					<label class="control-label" for="inputLastname"><b>นามสกุล</b></label>					    		
					<input type="text" id="LastName" name="lastname">

	                
	                
	                <label class="control-label" for="inputTelNum"><b>เบอร์โทรศัพท์</b></label>
	                <input type="text" id="inputTelNum" name="tel">
	                
					<label class="control-label" for="inputEmail"><b>email</b></label>
					<input type="text" id="inputEmail" name="email">
	                
	                <label class="control-label" for="inputPlant"><b>Plant</b></label>
	                <input type="text" id="inputPlant" name="plant">
	                
	                <label class="control-label" for="inputStoreRoom"><b>StoreRoom</b></label>
	                <input type="text" id="inputStoreRoom" name="storeRoom">

	                <label class="control-label" for="inputPassword"><b>กลุ่มผู้ใช้</b></label>				    		
					      <select name="usergroup">
								<option value="1">Administrator</option>
								<option value="2">Manager</option>
								<option value="3">Picker</option>
						  </select>
								
								<br><br>

					<input type="submit" class="btn btn-medium btn-primary" style="margin-left:14em" value="ลงทะเบียน" >
				  	<input type="reset" class="btn" style="margin-left:0.5em"  value = "reset" >
				  	<button type="reset" class="btn" style="margin-left:0.5em" onclick = "location.href = 'login.jsp'">ยกเลิก</button>

	                
	            </form>
	            </div>
	        
	        <!--END #signup-inner -->
	        
	        
	    <!--END #signup-form -->   
	    </div>


</body>
</html>