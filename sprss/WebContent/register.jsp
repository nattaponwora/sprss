<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="bootstrap/form/style.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/myStyle.css">
</head>
<body background="img/indexBG.jpg">
<%@ include file = "header.jsp" %>				
			
			<div id="signup-form">
	        	<div class="clearfix" id="header">       		
	        
	                <center><h1><font size="4" face="Tahoma" color="#493D26">ลงทะเบียน</font></h1><br></center>
	            
	            </div>
	            
	            <form id="send" action = "registermanager" method = "post">
	            	<table align = "center">
	                <tr>
	                	<td width="50%" style="padding-left: 20px">
	                	<label for="inputEmpID" ><b>รหัสพนักงาน</b></label>
	               		<input type="text" id="inputEmpID" name="empID">
	                	</td>
	                </tr>
	                
	                <tr>
	                	<td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputFirstname"><b>ชื่อ</b></label>						    		
						<input type="text" id="inputFirstname" name="firstname">
	                	</td>
						<td width="50%" style="padding-left: 40px">
						<label class="control-label" for="inputLastname"><b>นามสกุล</b></label>					    		
						<input type="text" id="LastName" name="lastname">
						</td>
	                </tr>
	                <tr>
	                <td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputTelNum"><b>เบอร์โทรศัพท์</b></label>
	                	<input type="text" id="inputTelNum" name="tel">
	                </td>
	                <td width="50%" style="padding-left: 40px">
						<label class="control-label" for="inputEmail"><b>email</b></label>
						<input type="text" id="inputEmail" name="email">
	                </td>
	                </tr>
	                <tr>
	                <td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputPlant"><b>Plant</b></label>
	                	<input type="text" id="inputPlant" name="plant">
	                </td>
	                <td width="50%" style="padding-left: 40px">
	                	<label class="control-label" for="inputStoreRoom"><b>StoreRoom</b></label>
	                	<input type="text" id="inputStoreRoom" name="storeRoom">
					</td>
					</tr>
					<tr>
					<td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputPassword"><b>กลุ่มผู้ใช้</b></label>				    		
					      <select name="usergroup">
								<option value="1">Administrator</option>
								<option value="2">Manager</option>
								<option value="3">Picker</option>
						  </select>
					</td>
					</tr>		
					<tr><td>&nbsp;</td></tr>
					<tr>
					<td><input type="submit" class="btn btn-medium btn-primary" style="margin-left:14em" value="ลงทะเบียน" ></td>
				  	<td><input type="reset" class="btn" style="margin-left:0.5em"  value = "reset" ></td>	                
	            	</tr>
	            	</table>
	            </form>
	            
	            </div>
	        
	        <!--END #signup-inner -->
	        
	        
	    <!--END #signup-form -->   
	    </div>


</body>
</html>