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
  <link rel="stylesheet" href="bootstrap/Table_zebra/css/blue.css" type="text/css">
  <link rel="stylesheet" href="bootstrap/popup/jquery-ui.css" />
  <script src="bootstrap/popup/jquery-1.9.1.js"></script>
  <script src="bootstrap/popup/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  	$(function() {
	    $( "#dialog" ).dialog();
	  });
  </script>
     <%
     	User user = (User) session.getAttribute("userData");
		ArrayList<Warehouse> wh = ( ArrayList<Warehouse> ) request.getAttribute("warehouse");     
     %>
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>	
	<center><h1><font size="5" face="Tahoma" color="#0000FF"> คลังสินค้า </font></h1></center>
	<div class="container">
	<center><table class="zebra">
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
		
			String mes = (String) request.getAttribute("mes");
			if(mes != null){
		%>
		<div id="dialog" title="SPRSS">
  			<p><br/><b><center><%
  				if( mes.equals("1") ){
  					out.println("<font color='red'>ไม่สามารถเพิ่มได้</font>");
  				}else if( mes.equals("0") ){
  					out.println("<font color='green'>บันทึกสำเร็จ</font>");
  				}else if( mes.equals("2") ){
  					out.println("<font color='orange'>คลังที่บันทึกมีอยู่ในระบบแล้ว</font>");
  				}
  			%></center></b></p>
		</div>
		<%	
			}
		%>
	</center>
	<br />
	<center><form action="warehouseinsert" method="post"><b><font color="#1569C7">Plant: </font></b><input type="text" name="plant" /><b><font color="#1569C7">Storeroom: </font></b><input type = "text" name = "storeroom" /> <input type="submit" class="btn btn-medium btn-primary" value ="เพิ่ม" /></form></center>
	<br><br><br>
	
</body>
<footer><br></footer>
</html>