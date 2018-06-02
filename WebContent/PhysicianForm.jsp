<%  if(session.getAttribute("UNAME")!=null && session.getAttribute("DESG").equals("Physician")){ %>
<%@ page import="java.sql.ResultSet,codd.major.dao.*,codd.major.logic.*" %>
<%ResultSet rs=null; %>
<%ResultSet rs1=null; %>
<%System.out.println(session.getAttribute("SPEC")+" page open"); %>
<!DOCTYPE HTML>
<html>
<head>
<title>Medical Emergency Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style(Pat).css" rel='stylesheet' type='text/css' />
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
<!--//fonts-->
</head>
<body>
<!--background-->
<h1> Physician Panel</h1>
    <div class="bg-agile">
	<div class="book-appointment">
	<h2>Patient Information</h2>
			<form action="PhysicianForm.jsp" method="post">
				<div class="gaps">
					<p>Patient ID</p>
					<input type="text" name="Pid" placeholder="PatientID" required=""/>
					</div>
					</form>
					<form action="TreatmentServlet" method="post">
			<%
				String id=request.getParameter("Pid");
						System.out.println("Patient Id "+id);
							if(id!=null)
							{
							String sql="select Patient_Id,First_Name,Gender,`Physical_Injury`,`Internal_Injury`,`Biological_Injury` from patientreg where Patient_Id=?;";
							rs=TreatmentDao.FetchData1(sql, id);							
							if(rs.next())
							{
								session.setAttribute("Pid",id);
			%>
					<div class="left-agileits-w3layouts same">
					<div class="gaps">
					<p>Patient ID</p>
					<input type="text" name="PatientID" placeholder="PatientID" value="<%=id %>" required=""/>
					</div>
					<div class="gaps">
						<p>Patient Name</p>
						<input type="text" name="PName" placeholder="Patient Name" value="<%=rs.getString(2) %>" readonly="readonly" />
					</div>
					<div class="gaps">
						<p>Gender</p>
						<input type="text" name="Gender" placeholder="Gender" value="<%=rs.getString(3) %>" readonly="readonly" />
					</div>
					<div class="gaps">
					<p>Any physical Injury?</p>
					<input type="text" name="PhyInjury" placeholder="Physical Injury" value="<%=rs.getString(4) %>" readonly="readonly" />
					</div>
					<div class="gaps">
					<p>Any Internal Injury?</p>
					<input type="text" name="PhyInjury" placeholder="Internal Injury" value="<%=rs.getString(5) %>" readonly="readonly" />
					</div>
					<div class="gaps">
					<p>Is Patient Physchologically normal?</p>
					<input type="text" name="BioInjury" placeholder="Mentally Normal" value="<%=rs.getString(6) %>" readonly="readonly" />
					</div>
				</div>
				<div class="right-agileinfo same">
					<div class="gaps">
						<p>Lab Test</p>
						<select class="form-control" name="LabTest">
						<%
								String sql1="select * from lab_test;";
								rs1=LogicCore.LoginDetails(sql1,"majorproject");							
								while(rs1.next())
								{	
							%>
						<option value="<%=rs1.getString(2) %>"><%=rs1.getString(2) %></option>
						<%} %>
						</select >
					</div>
					<div class="gaps">
					<p>Next Appointment</p>
					<input  id="datepicker1" name="Appointment" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'dd/mm/yyyy';}" required="">
					</div>
					<div class="gaps">
						<p>Description</p>
						<textarea id="message" name="Description" placeholder="Test Description" title="Lab Assistant Description"></textarea>
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
				<input type="submit" value="submit" />
				<%} }%>
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
							  var date = new Date();
							  date.setDate(date.getDate()+1);
							$( "#datepicker,#datepicker1,#datepicker2,#datepicker3" ).datepicker({ dateFormat: 'dd/mm/yy' ,minDate:date });
						  });
				  </script>
			<!-- //Calendar -->
<% }else{ response.sendRedirect("Login.jsp");}%>
</body>
</html>