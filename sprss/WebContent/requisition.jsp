<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>The Spare Part Requisition Smart System</title>
<!-- Bootstrap -->
	<img src = "img/cpr_logo.png">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <div class="navbar navbar-inverse" style="position: static;">
              <div class="navbar-inner">
                <div class="container">
                  <ul class="nav nav-pills">
					  <li class="active"><a href="main.jsp">ใบจองอะไหล่</a></li>
					  <li><a href="view.jsp">ใบหยิบอะไหล่</a></li>
					  <li><a href="view.jsp">ข้อมูลใบจองอะไหล่</a></li>
					</ul>
                    <span align="right" style="margin-left:20em"><button class="btn btn-mini btn btn-success disabled" type="button">User: Nuttareepan.r</button></span>     
                    <span align="right"><button class="btn btn-mini btn btn-danger" type="button" onclick = "location.href = 'login.jsp'">Log Out</button></span>
                </div>
              </div><!-- /navbar-inner -->
            </div>
</head>
<body background="img/indexBG.jpg">

	<center><h1 style="margin-top:0.5em"><font size="5" face="Tahoma" color="#493D26">The Spare Part Requisition Smart System</font></h1><br></center>
	<div class="container-fluid">
		  	<div class="row-fluid">
				<div class="span3">
				      <!--Sidebar content-->
				    <font size="4" face="Tahoma" color="#493D26" style="font-weight:bold">Detail</font><br>
					    <div class="container" style="margin-top:2em">
					      	<font size="3" face="Tahoma" color="#493D26">
						      	Name : xxx xxxxxx<br>
						      	Requisition : 5 papers<br>
						     	item : 40 pieces
						     	<hr width="300">
					  		</font>
					  	</div>
				    </div>
				    <!--<div style="width:3px;height:800px;background-color:black;float:left;">-->
				    <div class="span9" style="margin-left:1em">
				      <!--Body content-->
				    	<font size="4" face="Tahoma" color="#493D26" style="font-weight:bold">ผู้หยิบอะไหล่</font><br>
				    	<select>
									  <option>Suntharee</option>
									  <option>Somchai</option>
									  <option>Korkiat</option>
									  <option>Visuth</option>
									</select>
				    	<table class="table table-hover">
	  						<thead>
	    					<tr>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>No.</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>Requisition No.</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>Amount</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>Status</h5></font></th></div>
						      <div><th><font size="5" face="Tahoma" color="#493D26"><h5>Select</h5></font></th></div>
						    </tr>
						  </thead>
						  <tbody>
						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>
						    <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>
						    <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>
						    <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>
						    <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="warning">
							    <td>1</td>
							    <td>0019218163</td>
							    <td>24</td>
							    <td><font color="#FF2400">Pending</font></td>
							    <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
							  </tr>

							  <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						    <tr class="success">
						      <td>1</td>
						      <td>0019218162</td>
						      <td>17</td>
						      <td><font color="#64E986">Available</font></td>
						      <td><label class="checkbox">
	  								<input type="checkbox" name="check1" id="check1" value="check1">
	 								Select this
									</label></td>
						    </tr>

						  </tbody>
						</table>
						<span style="margin-left:28em"><a href="#" class="btn btn-medium btn-primary">Submit</a></span>
						<span style="margin-left:1em"><a href="main.jsp" class="btn btn-medium"> Clear </a></span>			    	
				    </div>
				<!--</div>-->
				</div>
			    
		  	</div>
	</div>

</body>
<footer><br></footer>
</html>

