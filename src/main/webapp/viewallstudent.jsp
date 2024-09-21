<%@page import="com.klef.ep.models.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="java.sql.*,java.util.List"  %>
<%@page import="com.klef.ep.services.AdminService"%>
<%@page import="javax.naming.InitialContext"%>

<%@page import="com.klef.ep.models.Admin"%>
<!DOCTYPE html>
<html>
<head>
<title>EP PROJECT</title>
<link type="text/css"  rel="stylesheet"  href="style.css"/>
</head>

<body>

<h2 align="center"><u>View All Studentsss</u></h2>
<table align="center"  border=2>
<tr>
<th>ID</th>
<th>Category</th>
<th>Name</th>
<th>Cost</th>
<th>Description</th>
<th>Image</th>
<th>Action</th>
</tr>
<%
InitialContext context = new InitialContext();
AdminService adminService = (AdminService) context.lookup("java:global/EPPROJECT/AdminServiceImpl!com.klef.ep.services.AdminService");

List<Student> stdlist = adminService.viewallstudents();

for(Student student : stdlist)
{
	  %>
	  
	    <tr>
	    	  <td><%=student.getId()%></td>
	    	  <td><%=student.getName()%></td>
	    	  
	    	  <td><img src="viewstudentsbyid.jsp?pid=<%=student.getId()%>"  width="25%"  height="25%" /></td>   
	    	   <td></td>	
	    </tr>
	  
	  <%
}

%>
</table>


</body>
</html>