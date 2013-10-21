<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="object.Requisition" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="object.RequisitionList" %>
    <%@ page import="object.PickingRequisition" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="bootstrap/Table_zebra/css/blue.css" type="text/css">
	<title>Insert title here</title>
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>
	<center><b><font color="#1569C7">ใส่หมายเลขใบเลิกอะไหล่ : </font></b><input type="text" name="search" /><b></center>
	<%
			ArrayList<PickingRequisition> pReq = (ArrayList<PickingRequisition>) request.getAttribute("pickReq");
			PickingRequisition req;
			for( int i = 0 ; i < pReq.size() ; i++ ){
				if( true ){ // id = ทำให้ดึงข้อมูลจากเลขใบเบิกที่ input เข้ามา
					req = pReq.get(i);
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
					  		    
					  </tbody>
				</table>		
			</center>
	<%
				break;
				}
				else{
					if( i == pReq.size()-1 ){
	%>
				<center><h1><font size="3" face="Tahoma" color="#FF0000"> ไม่พบใบเบิกอะไหล่ที่ทำการค้นหา </font></h1><br></center>
	<%
					}
				}
			}
	%>

</body>
</html>