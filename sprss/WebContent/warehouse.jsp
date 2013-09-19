<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="object.Requisition" %>
<%@ page import="object.RequisitionList" %>
<%@ page import="object.User" %>
<%@ page import="object.Warehouse" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

     <%
     	User user = (User) session.getAttribute("userData");
		ArrayList<Warehouse> wh = ( ArrayList<Warehouse> ) request.getAttribute("warehouse");     
     %>
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>	
	<div class="container">
	<center><table width="100%" class="table table-bordered">
			<thead>
			    <tr>
			        <th>หมายเลขอ้างอิง</th>
			      	<th>คำอธิบาย</th>
			     	<th>Plant</th>
			    	<th>Storeroom</th>			        
			    </tr>
			  </thead>
			  <tbody>
		<%
			 for( int i = 0 ; i < wh.size() ; i++ ){
				 Warehouse w = wh.get(i);
		%>
				 <tr>
				 	<td><%= w.getID() %></td>
				 	<td><%= w.getDescription() %></td>
				 	<td><%= w.getPlant() %></td>
				 	<td><%= w.getStoreroom() %></td>
				 </tr>
		<%
			 }
		%>
			  </tbody>
		</table>
		</center>
	</div>
	<center>
		<%
			String mes = request.getAttribute("mes");
		%>
	</center>
	<center><form action="warehouseinsert"><b><font color="#1569C7">Plant: </font></b><input type="text" name="plant" /><b><font color="#1569C7">Storeroom: </font></b><input type = "text" name = "storeroom" /> <input type="submit" value ="เพิ่ม" /></form></center>
	
	

</body>
<footer><br></footer>
</html>