<%  if(session.getAttribute("UNAME")!=null && session.getAttribute("DESG").equals("Lab Assistant")){ %>
<%@ page import="java.sql.ResultSet,codd.major.dao.*,codd.major.logic.*" %>
<%ResultSet rs=null; %>
<%ResultSet rs1=null; %>
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

<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<style type="text/css">

*{padding:0;margin:0;}

.label-container{
	position:fixed;
	bottom:48px;
	right:105px;
	display:table;
	visibility: hidden;
}

.label-text{
	color:#FFF;
	background:rgba(51,51,51,0.5);
	display:table-cell;
	vertical-align:middle;
	padding:10px;
	border-radius:3px;
}

.label-arrow{
	display:table-cell;
	vertical-align:middle;
	color:#333;
	opacity:0.5;
}

.float{
	position:fixed;
	width:60px;
	height:60px;
	bottom:40px;
	right:40px;
	background-color:#06C;
	color:#FFF;
	border-radius:50px;
	text-align:center;
	box-shadow: 2px 2px 3px #999;
}

.my-float{
	font-size:24px;
	margin-top:18px;
}

a.float + div.label-container {
  visibility: hidden;
  opacity: 0;
  transition: visibility 0s, opacity 0.5s ease;
}

a.float:hover + div.label-container{
  visibility: visible;
  opacity: 1;
}

</style>
</head>
<body>
<!--background-->
<h1> Lab Test Panel</h1>
    <div class="bg-agile">
	<div class="book-appointment">
	<h2>Lab Test</h2>
	<form id="myform" method="post" action="LabTestPanel.jsp">
				<div class="left-agileits-w3layouts same">
				<div class="gaps">
					<p>Patient ID</p>
					<input type="text" name="PatientID" placeholder="PatientID" required=""/>
					</div>
					
					<a onclick="document.getElementById('myform').submit();" class="float">
<i class="fa fa-search my-float"></i>
</a>
<div class="label-container">
<div class="label-text">Search</div>
<i class="fa fa-play label-arrow"></i>
</div>
</form>
<form action="LabTestServlet" method="post">
					<%
						String id=request.getParameter("PatientID");
								System.out.print(id);
									if(id!=null)
									{
									String sql="select First_Name,Gender,PhySpec,LabTest from patientreg,treatment_summary where patientreg.Patient_Id=treatment_summary.PId and treatment_summary.PId=?";
									rs=TreatmentDao.FetchData1(sql, id);							
									if(rs.next())
									{
										session.setAttribute("Pid",id);
					%>
						
					<div class="gaps">
						<p>Patient Name</p>
						<input type="text" name="PName" value="<%=rs.getString(1) %>" placeholder="Patient Name" readonly="readonly" />
					</div>
					<div class="gaps">
						<p>Physician Type</p>
							<input type="text" name="PhyName" value="<%=rs.getString(3) %>" placeholder="Physician Name" readonly="readonly" />
					</div>
					<div class="gaps">
						<p>Gender</p>
						<input type="text" name="Gender" value="<%=rs.getString(2) %>" placeholder="Gender" readonly="readonly" />
					<%} %>
					</div>
					<% }%>
				</div>
				
				<div class="right-agileinfo same">
					<div class="gaps">
						<p>Type Of Test</p>
						<select class="form-control" name="TestName">
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
						<p>Result</p>
						<input type="text" name="Result" placeholder="Result"  />
					</div>
					<div class="gaps">
						<p>Description</p>
						<textarea id="message" name="Description" placeholder="Test Description" title="Lab Assistant Description" ></textarea>
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
				<input type="submit" value="submit">
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
							$( "#datepicker,#datepicker1,#datepicker2,#datepicker3" ).datepicker();
						  });
				  </script>
			<!-- //Calendar -->
<% }else{ response.sendRedirect("Login.jsp");}%>
</body>
</html>