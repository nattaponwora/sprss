<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body background="img/indexBG.jpg">
<%@ include file = "header.jsp" %>	
			<center><h1><font size="4" face="Tahoma" color="#493D26">ลงทะเบียน</font></h1><br></center>
			<div class="container">
				<form class="form-horizontal" action = "registermanager" method = "post">
				
				<table>
				<tr>
					<td>
						<div class="control-group">
					    	<label class="control-label" for="inputEmpID"><b>รหัสพนักงาน</b></label>
					    		<div class="controls">
					      			<input type="text" id="inputEmpID" name="empID">
					    		</div>
					 	</div>
					 </td>
				</tr>
				<tr>
					<td>
						 <div class="control-group">
						    	<label class="control-label" for="inputFirstname"><b>ชื่อ</b></label>
						    		<div class="controls">
						      			<input type="text" id="inputFirstname" name="firstname">
						    		</div>
						 </div>
					 </td>
					 <td>
					 	<div class="control-group">
					    	<label class="control-label" for="inputLastname"><b>นามสกุล</b></label>
					    		<div class="controls">
					      			<input type="text" id="LastName" name="lastname">
					    		</div>
					 	</div>	
					 </td>
				</tr>
				<tr>
					<td>
						<div class="control-group">
						    	<label class="control-label" for="inputTelNum"><b>เบอร์โทรศัพท์</b></label>
						    		<div class="controls">
						      			<input type="text" id="inputTelNum" name="tel">
						    		</div>
					  	</div>
					</td>
					<td>
						<div class="control-group">
					    	<label class="control-label" for="inputEmail"><b>email</b></label>
					   			<div class="controls">
					      			<input type="text" id="inputEmail" name="email">
					   			</div>
				  		</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="control-group">
					    	<label class="control-label" for="inputPlant"><b>Plant</b></label>
					    		<div class="controls">
					      			<input type="text" id="inputPlant" name="plant">
					    		</div>
				  		</div>
					</td>
					<td>
						<div class="control-group">
					    	<label class="control-label" for="inputStoreRoom"><b>StoreRoom</b></label>
					    		<div class="controls">
					      			<input type="text" id="inputStoreRoom" name="storeRoom">
					    		</div>
					  	</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="control-group">
				    	<label class="control-label" for="inputPassword"><b>กลุ่มผู้ใช่</b></label>
				    		<div class="controls">
				      			<select name="usergroup">
								  <option value="1">Administrator</option>
								  <option value="2">Manager</option>
								  <option value="3">Picker</option>
								</select>
				    		</div>
				 		</div>
					</td>
				</tr>
				<tr>
				<td>&nbsp;</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-medium btn-primary" style="margin-left:14em" value="ลงทะเบียน" >
			  		<input type="reset" class="btn" style="margin-left:0.5em"  value = "reset" >
			  		<button type="reset" class="btn" style="margin-left:0.5em" onclick = "location.href = 'login.jsp'">ยกเลิก</button>
				</td>
				</tr>
				</table>
			 	</form><br> 	

				
	</div>


</body>
</html>