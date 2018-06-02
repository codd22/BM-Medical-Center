<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%  if(session.getAttribute("UNAME")!=null){

	   session.removeAttribute("UNAME");
	   session.removeAttribute("DESG");
	   if(session.getAttribute("SPEC")!=null)
	   session.removeAttribute("SPEC");
	   session.invalidate();
	   response.sendRedirect("Login.jsp");
%>

<% }else{ 
	
	session.removeAttribute("UNAME");
	session.removeAttribute("DESG");
	if(session.getAttribute("SPEC")!=null)
	session.removeAttribute("SPEC");
	session.invalidate();
	response.sendRedirect("Login.jsp");
	

}%>
