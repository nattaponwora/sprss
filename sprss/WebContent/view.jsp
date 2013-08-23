<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>The Spare Part Requisition Smart System</title>
<!-- Bootstrap -->
	<img src = "img/cpr_logo.png">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
                <div class="container">
                  <ul class="nav nav-pills">
					  <li class="active"><a href="main.jsp">Selecting</a></li>
					  <li><a href="view.jsp">View</a></li>
					</ul>
                    <span align="right" style="margin-left:65em"><button class="btn btn-mini btn btn-success disabled" type="button">User: Nuttareepan.r</button></span>     
                    <span align="right"><button class="btn btn-mini btn btn-danger" type="button">Log Out</button></span>
                </div>
              </div><!-- /navbar-inner -->
            </div>
</head>
<body background="img/indexBG.jpg">
	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>
	<div class="container">
		<h4>Name : xxx xxxx</h4> <br>
		<center><table class="table table-bordered">
			<thead>
			    <tr>
			   		<th>Requisition No.</th>
			      	<th>Item Code</th>
			     	<th>Item Description</th>
			    	<th>Asset No.</th>
			        <th>Amount</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td rowspan="6">19218162</td>
			      <td>30020798</td>
			      <td>RANCILIO 10700228 CONTROL PANEL RED 1GR</td>
			      <td>S30-03-6-3</td>
			      <td>2 pieces</td>
			    </tr>
			    <tr>
			      <td>30017152</td>
			      <td>NEC PW-ZAA06049A GIBMAC PKG ASY SWITCH</td>
			      <td>S26-04-4-2</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30010251</td>
			      <td>380-314-0-30 นกนางนวล ก๊อกคูลเลอร์</td>
			      <td>S26-04-4-2</td>
			      <td>1 pieces</td>
			  	</tr>
			    <tr>
			      <td>30008444</td>
			      <td>คอมเพรสเซอร์ ZR28K3PFJ-SCROLL 24000BTU</td>
			      <td>S05-01-2-4</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30002200</td>
			      <td>คอมเพรสเซอร์ MT56 HK4 MANEROP</td>
			      <td>S01-02-2-4</td>
			      <td>1 pieces</td>
			    </tr>
			    <tr>
			      <td>30014406</td>
			      <td>R.คอมเพรสเซอร์ MT56 HK4 MANEROP</td>
			      <td></td>
			      <td>1 pieces</td>
			    </tr>
			  </tbody>
		</table>
		<button type="submit" class="btn btn-medium btn-primary" style="margin-left:14em">Complete</button><dr>
	</div></center>
</body>
</html>