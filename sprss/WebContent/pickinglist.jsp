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
	<link rel="stylesheet" type="text/css" href="bootstrap/css/print.css" media="print" />
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
		Integer id = (Integer)request.getAttribute("id");
	%>
	<div id = "divprint">
		<div class="container">
		<font style="font-weight:bold" >หยิบอะไหล่ : <%= picker.getName() %></font><br>
		<font style="font-weight:bold" >หมายเลขใบรวมรายการ : <%= id %></font><br/>
		<font style="font-weight:bold" >ใบเบิกอะไหล่ :</font>
		<tbody>
			  <% 
			  	for ( int i =0; i < selectReq.size() ; i++ ){
			  		Requisition req = selectReq.get(i);
			  %>
			  	<tr>			     
			      <td align="center"><%= req.getReqID() %></td>			      
			    </tr>
			  <%
			  	}
			  %>
			  </tbody>			  
		<center><table width="100%"  border="0"><br>
			<thead>
			    <tr>
			        <th>ใบเบิกอะไหล่</th>
			      	<th>รหัสสินค้า</th>
			     	<th>รายการ</th>
			    	<th>Asset No./Storage bin</th>
			        <th>จำนวน</th>
			        <th>รหัสช่าง</th>
			    </tr>
			  </thead>
			  <tbody>
			  <% 
			  	String s = "";
			  	int temp = 0;
			  	for ( int i =0; i < itemList.size() ; i++ ){
			  		Item item = itemList.getItem(i);				  		
			  		if( !s.equals(item.getStoreType()) ){
			  			s = item.getStoreType();
			  			temp++;
			  		}
			  		if( temp%2 == 0 ){
			  			
			  %>
			  			<tr bgcolor="#E5E4E2">			  	 
			  <%	 
			  		}
			  		else{
			  %>		
			  		<tr>
			  <%
			  		}			  
			  %>			  		
			  			  	
					  	  <td align="center"><%= item.getReqID() %></td>
					      <td align="center"><%= item.getItemnum() %></td>
					      <td align="left"><%= item.getDescription() %></td>
					      <td align="center"><%= item.getAssetNO() %></td>
					      <td align="center"><%= item.getAmount() %></td>
					      <td align="center"><%= item.getAutID() %></td>					      
			  </tr>	  	
			  <%			  	
			  	}
			  %>
			  </tbody>	
		</table>			
	</div></center>
	</div>
	<br>
	<input type="button" class="btn btn-medium btn-primary" style="margin-left:50em" value="พิมพ์" onclick =  "printDiv('divprint')">
	<button type="button" class="btn" style="margin-left:0.5em" onclick = "location.href = 'requisition'">กลับ</button> 
	<br><br><br>
</body>
</html>
