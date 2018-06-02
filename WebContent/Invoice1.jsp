<%  if(session.getAttribute("UNAME")!=null && session.getAttribute("DESG").equals("Front Office Assistant")){ %>
<%@ page import="java.sql.ResultSet,codd.major.logic.*,java.time.LocalDate,java.time.format.DateTimeFormatter" %>
<%ResultSet rs=null; %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Invoice</title>
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="css/style(invoice1).css">
		<link rel="license" href="https://www.opensource.org/licenses/mit-license/">
		<script src="script.js"></script>
	</head>
	<body>
	<%
						
						String Pid=(String)session.getAttribute("PId");
						System.out.print(Pid);
						if(Pid!=null)
						{
		%>
		<header>
			<h1>Invoice</h1>	
			<span><img alt="" src="images/3(invoice).png"></span>
		</header>
		<article>
			<table class="meta">
				<tr>
					<th><span>Date</span></th>
					<%DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.now();
					System.out.println(dtf.format(localDate)); %>
					<td><span><%=dtf.format(localDate) %></span></td>
				</tr>
				<tr>
					<th><span >Patient ID</span></th>
					<td><span><%=Pid %></span></td>
				</tr>
				<tr>
					<th><span >Amount</span></th>
					<td><span id="prefix">$</span><span>600.00</span></td>
				</tr>
			</table>
			<table class="inventory">
				<thead>
					<tr>
						<th><span>Id</span></th>
						<th><span>Services</span></th>
						<th><span>Charges</span></th>
						<th><span>Appointment</span></th>
						<th><span>Price</span></th>
					</tr>
				</thead>
				<tbody>
							<%
								String sql="select * from patientcharges where PatientId=?;";
								rs=LogicCore.FetchRecordByWhere(sql,"majorproject",Pid);							
								while(rs.next())
								{	
							%>
					<tr>
						<td><span><%=rs.getString(1)%></span></td>
						<td><span></span><%=rs.getString(3)%></td>
						<td><span data-prefix>$</span><span><%=rs.getString(4)%>.00</span></td>
						<td><span contenteditable>1</span></td>
						<td><span data-prefix>$</span><span>0.00</span></td>
					</tr>
				<%} %>	
				</tbody>
			</table>
			<table class="balance">
				<tr>
					<th><span>Total</span></th>
					<td><span data-prefix>$</span><span>0.00</span></td>
				</tr>
				<tr>
					<th><span>Amount Paid</span></th>
					<td><span data-prefix>$</span><span contenteditable>0.00</span></td>
				</tr>
			</table>
		</article>
		<aside>
			<h1><span>Thanks for Giving us a Chance to Serve you.</span></h1>
		</aside>
<!--  -->			
	<% } %>
	
		<script  src="js/index(invoice1).js"></script>
	<% }else{ response.sendRedirect("Login.jsp");}%>
	</body>
</html>
