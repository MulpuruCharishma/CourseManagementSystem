<%@page import="com.klef.ep.models.Student"%>

<%
Student student = (Student) session.getAttribute("student");
%>

<html>
<head>
<title>Student Profile</title>
<style>
    body {
        background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20190223/ourmid/pngtree-gold-gold-low-profile-background-material-low-profilebackground-materialconference-image_69763.jpg');
        background-size: cover;
        background-position: center;
        background-color: lightcyan; /* Fallback color */
        font-family: Arial, sans-serif;
        color: #333;
    }

    h3 {
        color: #444;
        margin-top: 20px;
    }

    a {
        text-decoration: none;
        color: #0066cc;
        font-weight: bold;
    }

    a:hover {
        color: #0044aa;
    }

    center {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 10px;
        width: 50%;
        margin: 0 auto;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    h4 {
        color: #333;
        font-size: 22px;
    }

    br {
        margin-bottom: 10px;
    }
</style>
</head>
<body>
<h3 align="center">PROFILE</h3>
<a href="stuhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="stuprofile.jsp">Profile</a>&nbsp;&nbsp;&nbsp;
<a href="stulogout.jsf">Logout</a>&nbsp;&nbsp;&nbsp;
<br/><br/>
<center>
<h4><u>Student Profile</u></h4>
ID : <%=student.getId() %><br/>
Name : <%=student.getName() %><br/>
Gender : <%=student.getGender() %><br/>
Department : <%=student.getDepartment() %><br/>
Email : <%=student.getEmail() %><br/>
Contact No : <%=student.getContact() %><br/>
</center>

</body>
</html>
