<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="object.Requisition" %>
<%@ page import="object.RequisitionList" %>
<%@ page import="object.User" %>
<%@ page import="object.Item" %>
<%@ page import="object.ItemList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/button.css">
<link rel="stylesheet" href="bootstrap/Table_zebra/css/style.css" type="text/css">
     <%
     	User user = (User) session.getAttribute("userData");
     	ArrayList<User> picker = (ArrayList<User>)request.getAttribute("picker");
        RequisitionList reqList = (RequisitionList) request.getAttribute("reqList");
     %>
<script type="text/javascript">
function check()
{
	var a=new Array();
	a=document.getElementsByName("req");
	var p=0;
	for(i=0;i<a.length;i++){
		if(a[i].checked){
			p=1;
		}
	}
	if (p==0){
		alert('โปรดเลือก ใบเบิกอะไหล่ที่ต้องการ');
		return false;
	}
			
	return true;
}
</script>

<script type="text/javascript" src="bootstrap/fancyBox/lib/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="bootstrap/fancyBox/source/jquery.fancybox.js?v=2.1.5"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/fancyBox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 *  Simple image gallery. Uses default settings
		 */

		$('.fancybox').fancybox();

		/*
		 *  Different effects
		 */

		// Change title type, overlay closing speed
		$(".fancybox-effects-a").fancybox({
			helpers: {
				title : {
					type : 'outside'
				},
				overlay : {
					speedOut : 0
				}
			}
		});

		// Disable opening and closing animations, change title type
		$(".fancybox-effects-b").fancybox({
			openEffect  : 'none',
			closeEffect	: 'none',

			helpers : {
				title : {
					type : 'over'
				}
			}
		});

		// Set custom style, close if clicked, change title type and overlay color
		$(".fancybox-effects-c").fancybox({
			wrapCSS    : 'fancybox-custom',
			closeClick : true,

			openEffect : 'none',

			helpers : {
				title : {
					type : 'inside'
				},
				overlay : {
					css : {
						'background' : 'rgba(238,238,238,0.85)'
					}
				}
			}
		});

		// Remove padding, set opening and closing animations, close if clicked and disable overlay
		$(".fancybox-effects-d").fancybox({
			padding: 0,

			openEffect : 'elastic',
			openSpeed  : 150,

			closeEffect : 'elastic',
			closeSpeed  : 150,

			closeClick : true,

			helpers : {
				overlay : null
			}
		});

		/*
		 *  Button helper. Disable animations, hide close button, change title type and content
		 */

		$('.fancybox-buttons').fancybox({
			openEffect  : 'none',
			closeEffect : 'none',

			prevEffect : 'none',
			nextEffect : 'none',

			closeBtn  : false,

			helpers : {
				title : {
					type : 'inside'
				},
				buttons	: {}
			},

			afterLoad : function() {
				this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
			}
		});


		/*
		 *  Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
		 */

		$('.fancybox-thumbs').fancybox({
			prevEffect : 'none',
			nextEffect : 'none',

			closeBtn  : false,
			arrows    : false,
			nextClick : true,

			helpers : {
				thumbs : {
					width  : 50,
					height : 50
				}
			}
		});

		/*
		 *  Media helper. Group items, disable animations, hide arrows, enable media and button helpers.
		*/
		$('.fancybox-media')
			.attr('rel', 'media-gallery')
			.fancybox({
				openEffect : 'none',
				closeEffect : 'none',
				prevEffect : 'none',
				nextEffect : 'none',

				arrows : false,
				helpers : {
					media : {},
					buttons : {}
				}
			});

		/*
		 *  Open manually
		 */

		$("#fancybox-manual-a").click(function() {
			$.fancybox.open('1_b.jpg');
		});

		$("#fancybox-manual-b").click(function() {
			$.fancybox.open({
				href : 'iframe.html',
				type : 'iframe',
				padding : 5
			});
		});

		$("#fancybox-manual-c").click(function() {
			$.fancybox.open([
				{
					href : '1_b.jpg',
					title : 'My title'
				}, {
					href : '2_b.jpg',
					title : '2nd title'
				}, {
					href : '3_b.jpg'
				}
			], {
				helpers : {
					thumbs : {
						width: 75,
						height: 50
					}
				}
			});
		});


	});
</script>
<style type="text/css">
	.fancybox-custom .fancybox-skin {
		box-shadow: 0 0 50px #222;
	}

</style>
</head>
<body background="img/indexBG.jpg">
	<%
		String err = request.getParameter("err");
		if( err != null && err.equals("dup") ){
	%>
			<script type="text/javascript">
				alert("มีใบเบิกอะไหล่ที่ถูกเลือกไปแล้วอยู่ในรายการ โปรดเลือกใหม่อีกครั้ง");
			</script>
	<%
		}
	%>
	<%@ include file = "header.jsp" %>	
	<div class="container-fluid">
		  	<div class="row-fluid">
				<div class="span3">
				      <!--Sidebar content-->
				    <font size="4" face="Tahoma" color="#0000A0" style="font-weight:bold">Detail</font><br>
				    	<hr width = "200">
					    <div class="container" style="margin-top:1em">
					      	<font size="3" face="Tahoma" color="#493D26">
					      		<font color = "#1569C7">User Name : </font><%= user.getName() %><br>
					      		<font color = "#1569C7">รหัสพนักงาน : </font><%= user.getEID() %><br>
						      	<font color = "#1569C7">Plant : </font><%= user.getPlant() %><br>
						      	<font color = "#1569C7">Store Room : </font><%= user.getStoreroom() %><br>
						      	<font color = "#1569C7">จำนวนใบเบิกอะไหล่ : </font> <%= reqList.size() %> ใบ<br>						   
					  		</font>
					  	</div>
					  	<div align = "center">
					  		<br /><br />
					  		<!-- <b><font color = "#13A600">Last Update</font> : </b> -->
					  		<br /> 
					  		<button class="refresh" onclick ="window.location='mxmsync'">Refresh</button>
					  	</div>
				    </div>
				    <!--<div style="width:3px;height:800px;background-color:black;float:left;">-->
				    <form action="submitselreq" method="post" onsubmit="return check();" >
				    <div class="span9" style="margin-left:1em">
				      <!--Body content-->
				    	<font size="4" face="Tahoma" color="#493D26" style="font-weight:bold">ผู้หยิบอะไหล่</font><br>
				    	<select name="picker">
				    		<% 
				    			for ( int i = 0 ; i < picker.size(); i++){
				    				out.println( "<option value='"+picker.get(i).getID()+"'>"+ picker.get(i).getName() +"</option>");
				    			}
				    		
				    		%>
						</select>
				    	<table class="table table-hover">
	  						<thead>
	    					<tr>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5>ลำดับ</h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5><a href="requisition?sort=reqID">เลขที่ใบจอง</a></h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5>วันที่เบิก</h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5><a href="requisition?sort=item">จำนวนรายการ</a></h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5><a href="requisition?sort=eid">รหัสช่าง</a></h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5><a href="requisition?sort=team">ทีม</a></h5></font></th>
						      <th><font size="5" face="Tahoma" color="#493D26"><h5>เลือก</h5></font></th>
						    </tr>
						  </thead>
						  <tbody>
						  <%
						  	for (int i = 0 ; i < reqList.size() ; i ++ ){
						  		Requisition r = reqList.get(i);
						  %>
						  	<tr class=<%= i%2 == 0 ? "success" : "warning"  %>>
						  	  <td><%= i+1 %></td>
						      <td><%= r.getReqID() %></td>
						      <td><%= r.getEnteredDate().toString().replace(".0", " น.") %></td>
						      <td><%= r.size() %></td>
						      <td><%= r.getAuthorID() %></td>
						      <td><%= r.getAuthorTeam() %></td>
						      <td>
						      	<label class="checkbox">
	  						  		<input type="checkbox" name="req" id="req<%= i %>" value="<%= r.getReqID() %>">
								</label>
							  </td>
							  <td><a class="fancybox" href="#reqid<%= r.getReqID() %>" title="ใบเบิกอะไหล่"><img src="img/magnifying.png" /></a></td>
						    </tr>
						  <%
						  	}
						  %>
						  </tbody>
						</table>
						<input style="margin-left:30em" type="submit" class="btn btn-medium btn-primary" value = "ยืนยัน">
						<input type="reset" class="btn btn-medium" value = "Reset">
						</form>		    	
				    </div>
				<!--</div>-->
				</div>
			    
		  	</div>
	</div>
	
	<%
		for (int i = 0 ; i < reqList.size() ; i ++ ){
			Requisition r = reqList.get(i);
	%>
	<div id="reqid<%= r.getReqID() %>" style="width:800px;display: none;">
		<h5>เลขที่ใบเบิก <%= r.getReqID() %></h5>
		<h6>ผู้ขอเบิก <%= r.getAuthorID() + " " + r.getAuthorName() %></h6>
		<h6>ทีม <%= r.getAuthorTeam() %></h6>
		<h6>เวลาทำรายการ <%= r.getEnteredDate().toString().replace(".0", " น.") %></h6>
		<%
			ItemList il = r.getItemList();
		%>
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
	</div>
	<% 
		}
	%>
</body>
<footer><br></footer>
</html>