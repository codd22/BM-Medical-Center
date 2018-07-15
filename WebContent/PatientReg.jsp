<%  if(session.getAttribute("UNAME")!=null && session.getAttribute("DESG").equals("Front Office Assistant")){ %>
<%@page import="codd.major.dao.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Medical Emergency Form</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style(Pat).css" rel="stylesheet" type="text/css" />
<script src="js/countries.js"></script>
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
<!--//fonts-->

</head>
<body>
<!--background-->
<h1> Patient Registration Form</h1>
    <div class="bg-agile">
	<div class="book-appointment">
	<h2>Patient Information</h2>
			<form action="PatientRegServlet" method="post">
				<div class="left-agileits-w3layouts same">
					<div class="gaps">
						<p>First Name</p>
						<input type="text" name="FName" placeholder="" required=""/>
					</div>
					<div class="gaps">
						<p>Last Name</p>
							<input type="text" name="LName" placeholder="" />
					</div>
					<div class="gaps">
						<p>Gender</p>
							<select class="form-control" name="Gender">
								<option></option>
								<option>Male</option>
								<option>Female</option>
							</select>
					</div>
					<div class="gaps">
						<p>Date of Birth</p>
						<input  id="datepicker1" name="Dob" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'dd/mm/yyyy';}" required="">
					</div>
					<div class="gaps">
						<p>Is the Patient have any Physical Injury?</p>
						<input type="text" name="PhyInjury" placeholder="" />
					</div>
					<div class="gaps">
						<p>Any kind of internal injury diagnosed in the Past Record?</p>
						<input type="text" name="IInjury" placeholder="" />
					</div>

					<div class="gaps">
						<p>Is the patient behaving Physchologically Normal?</p>
						<input type="text" name="BInjury" placeholder="" required=""/>
					</div>
					<div class="gaps">
					<p>please mention the exact problem of patient</p>
					<input type="text" name="Problem" placeholder="" required=""/>
					 </div>
						<div class="gaps">
						<p>Phone Number</p>
						<input type="text" name="PNumber" placeholder="" required=""/>
					</div>
					<div class="gaps">
						<p>Primary Physician</p>
						<select class="form-control" name="PPhysician">
						<option value="generalmedicine"> General Medicine</option>
						<option value="cardiology"> Cardiology </option>
						<option value="oncology"> Oncology </option>
						<option value="dentistry"> Dentistry </option>
						<option value="ent"> ENT </option>
						<option value="cosmetology"> Cosmetology </option>
						<option value="cosmetology"> Radiology </option>
						<option value="cosmetology"> Rheumatology </option>
						</select > 
					</div>
					
					<div class="gaps">
						<p>Referring Physician</p>
						<select class="form-control" name="RPhysician">
						<option value="generalmedicine"> General Medicine</option>
						<option value="cardiology"> Cardiology </option>
						<option value="oncology"> Oncology </option>
						<option value="dentistry"> Dentistry </option>
						<option value="ent"> ENT </option>
						<option value="cosmetology"> Cosmetology </option>
						<option value="cosmetology"> Radiology </option>
						<option value="cosmetology"> Rheumatology </option>
						</select > 
					</div>
				</div>
				<div class="right-agileinfo same">
					<div class="gaps">
						<p>Parent/Guardian Name</p>
						<input type="text" name="PName" placeholder="" required=""/>
					</div>
					<div class="gaps">
						<p>Relationship</p>
						<input type="text" name="Relation" placeholder="" required=""/>
					</div>
					<div class="gaps">
						<p>EmailId</p>
						<input type="email" name="EmailID" placeholder="" required=""/>
					</div>
					<div class="gaps">
						<p>Address</p>
						<textarea id="message" name="Address" placeholder="" title="Please enter Your Comments"></textarea>
						</div>

					<div class="gaps">
						<p>Country</p>	
						<select class="form-control" id="country" name ="Country">
						
						</select>
					</div>
					<div class="gaps">
						<p>State</p>	
						<select class="form-control" id ="state" name ="State" >
							
						</select>
					</div>
					<div class="gaps">
						<p>City</p>
				      <input type="text" name="City" placeholder="" required=""/>
					</div>
					
					<div class="gaps">
						<p>Pin Code</p>
						<input type="text" name="PinCode" placeholder="" required=""/>
					</div>
				   <div class="gaps">

					<p>Date: <span id="date"></span></p>
					
					<script>
					var dt = new Date();
					document.getElementById("date").innerHTML = dt.toLocaleDateString();
</script>
				</div>
</div>
				<div class="clear"></div>
				<input type="submit" value="Submit">
			</form>
		</div>
   </div>

		<!--//copyright-->
		<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
		<!-- Calendar -->
				<link rel="stylesheet" href="css/jquery-ui(PatReg.).css" />
				<script src="js/jquery-ui.js"></script>
				  <script>
						  $(function() {
							$( "#datepicker,#datepicker1,#datepicker2,#datepicker3" ).datepicker({ dateFormat: 'dd/mm/yy' });
						  });
				  </script>
			<!-- //Calendar -->
			<script language="javascript">
	populateCountries("country", "state"); // first parameter is id of country drop-down and second parameter is id of state drop-down
	populateCountries("country2");
	populateCountries("country2");
</script>
<% }else{ response.sendRedirect("Login.jsp");}%>
</body>
</html>