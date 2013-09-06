<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="object.User" %>
<%@ page import="object.RequisitionList" %>
<%@ page import="object.Requisition" %>
<%@ page import="object.ItemList" %>
<%@ page import="object.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">  
	 function printDiv(divName) {  
     var printContents = document.getElementById(divName).innerHTML;  
     var originalContents = document.body.innerHTML;  
  
     document.body.innerHTML = printContents;  
     window.print();  
  
     document.body.innerHTML = originalContents;  
}  
</script>
</head>
<body background="img/indexBG.jpg">
	<%@ include file = "header.jsp" %>
	<% 
		User picker = (User) request.getAttribute("picker");
		RequisitionList selectReq = ( RequisitionList ) request.getAttribute("reqList"); 
		ItemList itemList = (ItemList) request.getAttribute("itemList");
	%>
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>
	<div id = "divprint">
		<div class="container">
		<h4>ผู้หยิบอะไหล่ : <%= picker.getName() %></h4> <br>
		<h>ใบเบิก : 7910034 , 7910035 </h> <br>
		<center><table class="table table-bordered">
			<thead>
			    <tr>
			      	<th>รหัสสินค้า</th>
			     	<th>รายการ</th>
			    	<th>Asset No./Storage bin</th>
			    	<th>ใบจอง</th>
			        <th>จำนวน</th>
			    </tr>
			  </thead>
			  <tbody>
			  <% 
			  	for ( int i =0; i < itemList.size() ; i++ ){
			  		Item item = itemList.getItem(i);
			  %>
			  	<tr>			      
			      <td><%= item.getCode() %></td>
			      <td><%= item.getDescription() %></td>
			      <td><%= item.getAssetNO() %></td>
			      <td><%= item.getReqID() %></td>
			      <td><%= item.getAmount() %></td>
			    </tr>
			  <%
			  	}
			  %>
			  </tbody>
		</table>
		<button type="submit" class="btn btn-medium btn-primary" style="margin-left:10em">ยืนยัน</button><dr>
		<button type="reset" class="btn" style="margin-left:0.5em" onclick = "location.href = 'requisition'">ยกเลิก</button>		
	</div></center>
	</div>
	<input type="button" class="btn btn-medium btn-primary" style="margin-left:50em" value="พิมพ์" onclick =  "printDiv('divprint')"> 
</body>
</html>