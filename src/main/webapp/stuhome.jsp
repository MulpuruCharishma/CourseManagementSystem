<%@page import="com.klef.ep.models.Student"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Student student = (Student) session.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Home</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
            background-image: url('https://i.pinimg.com/564x/fb/90/15/fb9015a2a4fefd3d3af46649d7692434.jpg');
            background-size: cover;
            background-position: center;
            background-color: lightgrey; /* This will be used if the image fails to load */
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            margin: 20px auto;
            width: 50%;
        }
        .navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            border-radius: 10px;
            margin-bottom: 20px;
        }
        .navbar li {
            float: left;
        }
        .navbar li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar li a:hover {
            background-color: #111;
        }
        h3 {
            text-align: center;
            color: #333;
        }
        .links {
            text-align: center;
            margin: 20px;
        }
        .links a {
            margin: 0 10px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }
        .links a:hover {
            color: #111;
        }
        .welcome {
            text-align: right;
            margin: 20px;
            font-size: 18px;
            color: #333;
            font-weight: bold;
            position: absolute;
            top: 20px;
            right: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>Course Management System</h3>
        <ul class="navbar">
            <li><a href="stuhome.jsp">Home</a></li>
             <li><a href="stuprofile.jsp">Profile</a></li>
            <li><a href="viewallcourse.jsf">View all Courses</a></li>
            <li><a href="updatestd.jsf">Update Student</a></li>
            <li><a href="mycourses.jsf">My Courses</a></li>
            <li><a href="stulogout.jsp">Logout</a></li>
        </ul>
    </div>
    <div class="welcome">
        Welcome <%=student.getName()%> !!
    </div>
</body>
</html>
