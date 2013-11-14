<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="object.Requisition" %>
<%@ page import="object.ItemList" %>
<%@ page import="object.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="object.RequisitionList" %>
<%@ page import="object.PickingRequisition" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>RSSM : SPRM</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="bootstrap/Table_zebra/css/blue.css" type="text/css">
	<link rel="stylesheet" href="bootstrap/Table_zebra/css/style.css" type="text/css">
	<%
		User user = (User) session.getAttribute("userData");
	%>
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>
	<center><b><font color="#1569C7">ค้นหาข้อมูลการเบิกอะไหล่ </font></b></center>
	<div align="center">
		<form action="reqsearch" method="post">
			<input type = "text" name="req" /> <input type="submit" class="btn btn-medium btn-primary" value = "ค้นหา"/>
			<input type = "hidden" name = "plant" value ="<%= user.getPlant() %>" />
			<input type = "hidden" name = "storeroom" value ="<%= user.getStoreroom() %>" />
		</form>
	</div>	
	<%
		Boolean isSearch = (Boolean) request.getAttribute("isSearch");
		Requisition r = (Requisition) request.getAttribute("req");
		PickingRequisition selReq = ( PickingRequisition ) request.getAttribute("selReq");
		
		if( ! isSearch.booleanValue() ){
			//don't do anything
		} else if( r == null ){
	%>
		<font color='red'><b><center><h4>ไม่พบรายการที่ต้องการ</h4></center></b></font>
	<%
		} else {
	%>
		<center><div style="width:800px;" align="left">
		<div>
		<table width = 100% border=0>
			<tr>
			<td colspan="2"><b>เลขที่ใบเบิกอะไหล่ : <%= r.getReqID() %></b></td>
				<td>
					สถานะใบเบิกอะไหล่ : 
					<%
						String status = r.getStatus();
						int sid = -1;
						if( status.equals("entered") ){
							out.print("ENTERED");
							sid = 1;
						}else if( status.equals("pick") ){
							out.print("กำลังดำเนินการหยิบ");
							sid = 2;
						}else if( status.equals("finished") ){
							out.print("เสร็จสิ้น");
							sid = 3;
						}
					%>
				</td>
			</tr>
			<tr>
				<td>
					ผู้เบิก : <%= r.getAuthorID() + " " + r.getAuthorName() %>
				</td>
				<td>
					ทีม : <%= r.getAuthorTeam() %>
				</td>
				<td>
					StoreRoom : <%= r.getPlant()+"-"+r.getStoreroom() %>
				</td>
			</tr>
			<tr>
				<td colspan = 3>เวลาขอเบิก : <%= r.getEnteredDate().toString().replace(".0", " น.") %></td>
			</tr>
			<%
				if ( ! r.getStatus().equals("entered") ){
			%>
				<tr>
					<td><b>หมายเลขใบหยิบ : <%= selReq.getID() %></b></td>
					<td colspan=2>ผู้หยิบ : <%= selReq.getEid()+ " " + selReq.getName()  %></td>
				</tr>
				<tr>
					<td>เวลาเริ่มหยิบ : <%= selReq.getBegin().toString().replace(".0", " น.") %></td>
					<%
					if ( r.getStatus().equals("finished")  ){
						out.print("<td colspan=2>เวลาหยิบเสร็จ : " + selReq.getFinish().toString().replace(".0", " น.") + "</td>");
					}else{
						out.print("<td colspan=2>&nbsp;</td>");
					}
					%>
				</tr>
			<%
				}
			%>
		</table>
		<table width="100%" class="zebra">
			<thead>
			    <tr>
			      	<th>รหัสสินค้า</th>
			     	<th>รายการ</th>
			    	<th>Asset No./Storage bin</th>
			        <th>จำนวน</th>
			        <th>หน่วย</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%
			  	ItemList il = r.getItemList();
			  	for( int j=0; j< il.size() ; j++  ){
			  		Item item = il.get(j);
			  %>
			  	<tr>
			  		<td height="30" align="center"><%= item.getItemnum() %></td>
					<td height="30" align="left"><%= item.getDescription() %></td>
					<td height="30" align="center"><%= item.getAssetNO() %></td>
					<td height="30" align="center"><%= item.getAmount() %></td>
					<td height="30" align="center"><%= item.getUnit() %></td>
			  	</tr>
			  <%
				}
			  %>
			  </tbody>
		</table>
		</div></center>
	<%
		}
	%>
	</div>
</body>
</html>