
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%  if(session.getAttribute("UNAME")!=null && session.getAttribute("DESG").equals("Admin")){ %>    
<%@ page import="java.sql.ResultSet,codd.major.logic.*" %>
<%ResultSet rs=null; %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Admin Update</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util(table).css">
	<link rel="stylesheet" type="text/css" href="css/main(table).css">
<!--===============================================================================================-->
<style>
#upd {
    width: 10em;  height: 2em;
}
</Style>
<style type="text/css">

*{padding:0;margin:0;}

body{
	font-family:Verdana, Geneva, sans-serif;
	background-color:#CCC;
	font-size:12px;
}

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
<center>						
	<div class="limiter">
						<form action="LoginUpdate.jsp" method="post">
						<h3>SEARCH USER BY EMAIL</h3>
						<input type="text" name="email" /> 
						<input type="submit" value="Search">
						</form>
						
						<form action="UpdateServlet" method="post">
		<div class="container-table100">
						<%
						String email=request.getParameter("email");
						if(email!=null)
						{
						%>
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Employees</th>
								</tr>
							</thead>
							<tbody>
							<%
								String sql="select * from login_table where EmailId=?;";
								rs=LogicCore.FetchRecordByWhere(sql,"majorproject",email);							
								while(rs.next())
								{	
							%>
								<tr class="row100 body">
									<td class="cell100 column1"><input type="text" name="name" value="<%=rs.getString(1)%>" /></td>
								</tr>
								<%
							}
								rs.beforeFirst();
							%>
							</tbody>
						</table>
					</div>

					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column2">EmailID</th>
										<th class="cell100 column3">DeptID</th>
										<th class="cell100 column4">Username</th>
										<th class="cell100 column5">Password</th>
										</tr>
								</thead>
								<tbody>
								<%
								while(rs.next())
								{
								%>
									<tr class="row100 body">
										<td class="cell100 column2"><input type="text" name="email" value="<%=rs.getString(2)%>" readonly="readonly"/></td>
										<td class="cell100 column2"><input type="text" name="designation" value="<%=rs.getString(3)%>" /></td>
										<td class="cell100 column2"><input type="text" name="username" value="<%=rs.getString(4)%>" /></td>
										<td class="cell100 column2"><input type="text" name="password" value="<%=rs.getString(5)%>" /></td>
										<td><input type="submit" id="upd" value="Update" /></td>
									</tr>
								<%} %>
								</tbody>
							</table>
							<% }%>
							</form>	
						</div>
					</div>
				</div>
			</div>		
		</div>
		<a href="adminpanel.jsp" class="float">
<i class="fa fa-mail-reply my-float"></i>
</a>
<div class="label-container">
<div class="label-text">BackTo Admin</div>
<i class="fa fa-play label-arrow"></i>
</div>
	</div>


<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})

			$(this).on('ps-x-reach-start', function(){
				$(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
			});

			$(this).on('ps-scroll-x', function(){
				$(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
			});

		});




	</script>
<!--===============================================================================================-->
	<script src="js/main(table).js"></script>
	<% }else{ response.sendRedirect("Login.jsp");}%>
</center>
</body>
</html>