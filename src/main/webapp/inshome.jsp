<%@page import="com.klef.ep.models.Instructor"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.klef.ep.services.InstructorService"%>
<%@page import="com.klef.ep.models.Instructor"%>
<%
Instructor in = (Instructor) session.getAttribute("in");
if(in==null)
{
  response.sendRedirect("sessionexpiry.html");
}
%>
<html>
<head>
<title>Instructor Home</title>
</head>
<body bgcolor="lightgrey">
<h3 align='center'>Course Management System</h3>
<a href="inshome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="inslogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
<br/><br/>
I am in Instructor Home
</body>
</html>