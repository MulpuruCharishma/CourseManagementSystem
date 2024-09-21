<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Admin admin = (Admin) session.getAttribute("admin");
%>
<html>
<head>
<title>Admin Home</title>
<style>
    body {
        background: url('https://i.pinimg.com/564x/b4/4f/c3/b44fc3bb645dbbadc2809d504209a543.jpg') no-repeat center center fixed; 
        background-size: cover;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        color: #333;
    }

    .navbar {
        overflow: hidden;
        background-color: #333;
        position: fixed;
        top: 0;
        width: 100%;
        z-index: 1000;
    }

    .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
        font-size: 17px;
        transition: background-color 0.3s;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }

    h3 {
        color: #fff;
        padding-top: 80px; /* Ensure the heading is not hidden behind the navbar */
        text-align: center;
    }

    .content {
        padding: 20px;
        background-color: rgba(255, 255, 255, 0.9);
        border-radius: 10px;
        margin: 100px auto;
        width: 80%;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    .welcome {
        text-align: center;
        font-size: 24px;
        color: black ;
        margin-top: 150px; /* Adjust margin to prevent overlap with navbar */
    }
</style>
</head>
<body>

<div class="navbar">
    <a href="adminhome.jsp">Home</a>
    <a href="addstudent.jsp">Add Student</a>
    <a href="stulogin.jsf">Student Login</a>
    <a href="viewallstudents.jsf">View All Students</a>
    <a href="updatestd.jsf">Update Student</a>
    <a href="coursereg.jsf">Add Courses</a>
    <a href="viewallcourses.jsf">View All Courses</a>
    <a href="insreg.jsf">Instructor Registration</a>
    <a href="inslogin.jsf">Instructor Login</a>
    <a href="viewallinstructors.jsf">View All Instructors</a>
    <a href="updateinstructors.jsf">Update Instructors</a>
    <a href="adminlogin.jsf">Logout</a>
</div>

<div class="welcome">
    Welcome <%=admin.getUsername()%> !!
</div>

</body>
</html>
