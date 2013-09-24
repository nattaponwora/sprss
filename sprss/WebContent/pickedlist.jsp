<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="object.Requisition" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="object.RequisitionList" %>
<%@ page import="object.PickingRequisition" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>	
	<%
			ArrayList<PickingRequisition> pReq = (ArrayList<PickingRequisition>) request.getAttribute("pickReq");
		%>
	<div class="container">		
		<center><table class="table table-bordered">
			<thead>
			    <tr>
			    	<th>เลขที่ใบหยิบ</th>
			   		<th>รหัสพนักงาน</th>
			   		<th>ชื่อพนักงาน</th>
			      	<th>จำนวนใบเบิก</th>
			     	<th>จำนวนอะไหล่ (ชิ้น)</th>
			     	<th>เวลาเริ่มหยิบ</th>
			     	<th>ยืนยัน</th>			    	
			    </tr>
			  </thead>
			  <tbody>
			  <%			  	
			  	for ( int i =0; i < pReq.size() ; i++ ){
			  		PickingRequisition req = pReq.get(i);
			  %>
			  	<tr>
			  	  <td align="center"><%= req.getID() %></td>
			      <td align="center"><%= req.getEid() %></td>
			      <td align="center"><%= req.getName() %></td>
			      <td align="center"><%= req.size() %></td>
			      <td align="center"><%= req.getItemNum() %></td>
			      <td align="center"><%= req.getBegin() %></td>
			      <td><form action="submitfinish" method="post"><input type="hidden" name="finish" value="<%= req.getID() %>"/><input type="submit" class="btn btn-small btn-primary" value="เสร็จสิ้น"></input></form></td>
			    </tr>
			  <%
			  	}
			  %>
			  </tbody>			  
		</table>		
	</div></center>
</body>
</html>