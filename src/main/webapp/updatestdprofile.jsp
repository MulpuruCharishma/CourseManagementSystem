<%@page import="com.klef.ep.models.Student"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>


<%
Student std = (Student) session.getAttribute("std");
if(std==null)
{
  response.sendRedirect("sessionexpiry.html");
}
%>



<html>
<head>
<title>Student Home</title>
</head>
<body bgcolor="lightgrey">
<h3 align='center'>Student</h3>
<a href="stuhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="stuprofile.jsp">Profile</a>&nbsp;&nbsp;&nbsp;
<a href="updatestdprofile.jsf">Update Profile</a>&nbsp;&nbsp;&nbsp;
<a href="stulogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
<br/><br/>
<h3 align="center"><u>Update Student Profile</u></h3>
<center>
<form method="post"  action="sprofileupdate.jsp">
<table align="center">
<tr>
    <td><b>ID</b></td>
    <td>
        <input type="number" name="id"  value="<%=std.getId()%>" readonly required>
    </td>
</tr>
<tr><td></td></tr>
<tr>
    <td><b>Enter Name</b></td>
    <td>
        <input type="text" name="name" value="<%=std.getName()%>" required>
    </td>
</tr>
<tr><td></td></tr>

<tr>
    <td><b>Enter Password</b></td>
    <td>
        <input type="password" name="password" value="<%=std.getPassword()%>" required>
    </td>
</tr>
<tr><td></td></tr>
<tr>
    <td><b>Enter Contact</b></td>
    <td>
        <input type="number" name="contact" value="<%=std.getContact()%>" required>
    </td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr align="center">
    <td>
        <input type="submit" value="Update" required>
    </td>
    <td>
        <input type="reset" value="Clear" required>
    </td>
</tr>
</table>
</form>

</center>
</body>
</html>