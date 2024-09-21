 <%@page import="com.klef.ep.models.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.klef.ep.services.AdminService"%>
<%@page import="javax.naming.InitialContext"%>
<%

// JSP with JPA Integration, you can do like in Servlet service() method as well

InitialContext context = new InitialContext();
AdminService adminService = (AdminService)context.lookup("java:global/EPProject/AdminServiceImpl!com.klef.ep.services.AdminService");

List<Course> courselist = adminService.viewallcourses();

%>

<h3 align="center">View All Courses</h3>
<table align="center" border="2">
<tr>
<th>ID</th>
<th>Name</th>

<th>Department</th>

</tr>

<%

    for(Course course : courselist)
    {
      %>
          <tr>
          <td><%=course.getId()%></td>
           <td><%=course.getName()%></td>
           
             <td><%=course.getDepartment()%></td>
             
          </tr>
      <%       
    }

%>


</table>