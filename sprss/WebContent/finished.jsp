<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="object.PickingRequisition" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="bootstrap/Table_zebra/css/blue.css" type="text/css">
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>
	<center><h1><font size="5" face="Tahoma" color="#0000FF">ข้อมูลการหยิบอะไหล่</font></h1><br></center>
	<%
			ArrayList<PickingRequisition> pReq = (ArrayList<PickingRequisition>) request.getAttribute("pickReq");
		%>	
	<center><table class="zebra">
			<thead>
			    <tr>
			    	<th>เลขที่ใบหยิบ</th>
			   		<th>รหัสพนักงาน</th>
			   		<th>ชื่อพนักงาน</th>
			      	<th>จำนวนใบเบิก</th>
			     	<th>จำนวนอะไหล่(ชิ้น)</th>
			     	<th>เวลาเริ่มหยิบ</th>
					<th>เวลาหยิบเสร็จ</th>
			     	<th>รายละเอียด</th>			    	
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
			      <td align="center"><%= req.getBegin().toString().replace(".0", " น.") %></td>
			      <td align="center"><%= req.getFinish().toString().replace(".0", " น.") %></td>
			      <td><center><a href="pickinglist?id=<%= req.getID() %>"><img src="img/magnifying.png" width="30" height="10"></a></center></td>			      
			    </tr>
			  <%
			  	}
			  %>			    
			  </tbody>
		</table>		
	</center>
	<br><br><br>
</body>
</html>