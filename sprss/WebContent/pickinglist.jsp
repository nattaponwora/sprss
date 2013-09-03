<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>
	<div id = "divprint">
		<div class="container">
		<h4>ผู้หยิบอะไหล่ : <%= request.getAttribute("picker") %></h4> <br>
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
			    <tr>			      
			      <td>30020798</td>
			      <td>RANCILIO 10700228 CONTROL PANEL RED 1GR</td>
			      <td>S30-03-6-3</td>
			      <td>19218162</td>
			      <td>2 pieces</td>
			    </tr>
			    <tr>
			      <td>30017152</td>
			      <td>NEC PW-ZAA06049A GIBMAC PKG ASY SWITCH</td>
			      <td>S26-04-4-2</td>
			      <td>19218162</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30010251</td>
			      <td>380-314-0-30 นกนางนวล ก๊อกคูลเลอร์</td>
			      <td>S26-04-4-2</td>
			      <td>19218162</td>
			      <td>1 pieces</td>
			  	</tr>
			    <tr>
			      <td>30008444</td>
			      <td>คอมเพรสเซอร์ ZR28K3PFJ-SCROLL 24000BTU</td>
			      <td>S05-01-2-4</td>
			      <td>19218162</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30002200</td>
			      <td>คอมเพรสเซอร์ MT56 HK4 MANEROP</td>
			      <td>S01-02-2-4</td>
			      <td>19218162</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30014406</td>
			      <td>R.คอมเพรสเซอร์ MT56 HK4 MANEROP</td>
			      <td></td>
			      <td>19218162</td>
			      <td>1 pieces</td>
			    </tr>
			  </tbody>
		</table>
		<button type="submit" class="btn btn-medium btn-primary" style="margin-left:10em">ยืนยัน</button><dr>
		<button type="reset" class="btn" style="margin-left:0.5em" onclick = "location.href = 'requisition'">ยกเลิก</button>		
	</div></center>
	</div>
	<input type="button" class="btn btn-medium btn-primary" style="margin-left:50em" value="พิมพ์" onclick =  "printDiv('divprint')"> 
</body>
</html>