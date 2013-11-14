<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="object.Warehouse" %>
<%@ page import="object.User" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="bootstrap/form/style.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/myStyle.css">
	<link rel="stylesheet" href="bootstrap/popup/jquery-ui.css" />
    <script src="bootstrap/popup/jquery-1.9.1.js"></script>
    <script src="bootstrap/popup/jquery-ui.js"></script>
    <script>
  	$(function() {
	    $( "#dialog" ).dialog();
	  });
  </script>
  <script type="text/javascript">
  	function disableWarehouse(){
  		var group = document.getElementById("usergroup").value;
  		if( group == 1 ){
  			document.getElementById("warehouse").disabled=true;
  		}else{
  			document.getElementById("warehouse").disabled=false;
  		}
  	}
  </script>
	<%
		ArrayList<Warehouse> wh = ( ArrayList<Warehouse> ) request.getAttribute("warehouse");
		User u = ( User ) session.getAttribute("userData");
	%>
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
	                	<label for="inputEmpID" ><b>รหัสพนักงาน <font color="red" size=4em>*</font></b></label>
	               		<input type="text" id="inputEmpID" name="empID" required>
	                	</td>
	                </tr>
	                
	                <tr>
	                	<td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputFirstname"><b>ชื่อ <font color="red" size=4em>*</font></b></label>						    		
						<input type="text" id="firstname" name="firstname" placeholder="ไม่ต้องมีคำนำหน้า" required>
	                	</td>
						<td width="50%" style="padding-left: 40px">
						<label class="control-label" for="inputLastname"><b>นามสกุล <font color="red" size=4em>*</font></b></label>					    		
						<input type="text" id="lastname" name="lastname" required>
						</td>
	                </tr>
	                <tr>
	                <td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputTelNum"><b>เบอร์โทรศัพท์</b></label>
	                	<input type="text" id="tel" name="tel" placeholder="ตัวเลขไม่มีเครื่องหมายคั่น " >
	                </td>
	                <td width="50%" style="padding-left: 40px">
						<label class="control-label" for="inputEmail"><b>email</b></label>
						<input type="text" id="email" name="email">
	                </td>
	                </tr>
	                <tr>
	                <td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputWarehouse"><b>คลัง <font color="red" size=4em>*</font></b></label>
	                	<select id="warehouse" name="ware_id">
	                		<%
	                		for(int i =0 ; i < wh.size() ; i++){
	                			Warehouse w = wh.get(i);
	                		%>
	                		<option value="<%= w.getID() %>"><%= w.getPlant()+"-"+w.getStoreroom()+" "+w.getDescription() %></option>
	                		<%
	                		}
	                		%>
	                	</select>
	                </td>
	                <td>&nbsp;</td>
	                </tr>
	                <tr>
					</tr>
					<tr>
					<td width="50%" style="padding-left: 20px">
	                	<label class="control-label" for="inputPassword"><b>กลุ่มผู้ใช้ <font color="red" size=4em>*</font></b></label>				    		
					      <select id="usergroup" name="usergroup" onchange="disableWarehouse()">
					      <% if( u.getUsergroup() == 1 ){
					      %>
					      		<option value="1">Administrator</option>
					      <%
					      }
					      %>
								<option value="2">Manager</option>
								<option value="3" selected="selected">Picker</option>
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
		<%
			Integer err = (Integer) request.getAttribute("err");
			if(err != null){
				int errNum = err.intValue(); 
				if( errNum == 1 ){
		%>
		<div id="dialog" title="Error">
  			<p><br/><b><center><%
  					out.println("<font color='red'>ไม่สามารถเพิ่มผู้ใช้งานได้<br />โปรดลองอีกครั้ง</font>");
  			%></center></b></p>
		</div>
		<%
				}
			}
		%>
</body>
</html>