<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="object.Requisition" %>
<%@ page import="object.RequisitionList" %>
<%@ page import="object.User" %>
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
                <div class="container">
                  <ul class="nav nav-pills">
					  <li class="active"><a href="requisition">ใบจองอะไหล่</a></li>
					  <li><a href="pickinglist">ใบหยิบอะไหล่</a></li>
					  <li><a href="pickinglist">ข้อมูลใบจองอะไหล่</a></li>
					</ul>
                    <span align="right" style="margin-left:20em"><button class="btn btn-mini btn btn-success disabled" type="button">User: Nuttareepan.r</button></span>     
                    <span align="right"><button class="btn btn-mini btn btn-danger" type="button" onclick = "location.href = 'logout'">Log Out</button></span>
                </div>
              </div><!-- /navbar-inner -->
            </div>
     <%
     	User user = (User) session.getAttribute("userData");
        RequisitionList reqList = (RequisitionList) request.getAttribute("reqList");
     %>
</head>
<body background="img/indexBG.jpg">

	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>
	<div class="container-fluid">
		  	<div class="row-fluid">
				<div class="span3">
				      <!--Sidebar content-->
				    <font size="4" face="Tahoma" color="#493D26" style="font-weight:bold">Detail</font><br>
					    <div class="container" style="margin-top:2em">
					      	<font size="3" face="Tahoma" color="#493D26">
						      	ชื่อผู้ใช้ : <%= user.getFirstname() %><br>
						      	จำนวนใบจอง : <%= reqList.size() %> ใบ<br>
						     	จำนวน : <%= reqList.getItemNum() %> ชิ้น
						     	<hr width="300">
					  		</font>
					  	</div>
				    </div>
				    <!--<div style="width:3px;height:800px;background-color:black;float:left;">-->
				    <form action="pickinglist" method="post" >
				    <div class="span9" style="margin-left:1em">
				      <!--Body content-->
				    	<font size="4" face="Tahoma" color="#493D26" style="font-weight:bold">ผู้หยิบอะไหล่</font><br>
				    	<select name="picker">
				    		<% 
				    			ArrayList<String> picker = (ArrayList<String>)request.getAttribute("picker");
				    			for ( int i = 0 ; i < picker.size(); i++){
				    				out.println( "<option value='"+picker.get(i)+"'>"+picker.get(i)+"</option>");
				    			}
				    		
				    		%>
						</select>
				    	<table class="table table-hover">
	  						<thead>
	    					<tr>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>ลำดับ</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>เลขที่ใบจอง</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>จำนวนใบจอง</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>สถานะ</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>เลือก</h5></font></th></div>
						    </tr>
						  </thead>
						  <tbody>
						  <%
						  	for (int i = 0 ; i < reqList.size() ; i ++ ){
						  		Requisition r = reqList.get(i);
						  %>
						  	<tr class=<%= i%2 == 0 ? "success" : "warning"  %>>
						  	  <td><%= i+1 %></td>
						      <td><%= r.getReqID() %></td>
						      <td><%= r.size() %></td>
						      <td><font color="#64E986">Available</font></td>
						      <td>
						      	<label class="checkbox">
	  						  		<input type="checkbox" name="check1" id="check1" value="check1">
								</label>
							  </td>
						    </tr>
						  <%
						  	}
						  %>
						  </tbody>
						</table>
						<input style="margin-left:20em" type="submit" class="btn btn-medium btn-primary" value = "ยืนยัน">
						<input type="reset" class="btn btn-medium">
						</form>		    	
				    </div>
				<!--</div>-->
				</div>
			    
		  	</div>
	</div>

</body>
<footer><br></footer>
</html>