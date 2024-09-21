<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Management System</title>
    <link type="text/css" rel="stylesheet" href="style.css"/>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
            background-image: url('https://i.pinimg.com/564x/0f/5f/ab/0f5faba150f95cebb2e538c33368a7e1.jpg');
            background-size: cover;
            background-position: center;
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
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 24px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 10px;
        }
        table {
            width: 100%;
        }
        td {
            padding: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        

        <h2 align="center">Course Management System</h2>
        <br/>
        <h2 align="center"><u>Add Student</u></h2>
        <form method="post" action="insertstudent" enctype="multipart/form-data">
            <table align="center">
                <tr>
                    <td><b>Name</b></td>
                    <td><input type="text" name="sname" required></td>
                </tr>
                <tr>
                    <td><b>Contact</b></td>
                    <td><input type="text" name="scontact" required></td>
                </tr>
                <tr>
                    <td><b>Password</b></td>
                    <td><input type="text" name="spassword" required></td>
                </tr>
                <tr>
                    <td><b>Department</b></td>
                    <td>
                        <select name="sdepartment" required>
                            <option value="">---Select---</option>
                            <option value="CSEH">CSEH</option>
                            <option value="CSE">CSE</option>
                            <option value="ECE">ECE</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><b>Email</b></td>
                    <td><input type="text" name="semail" required></td>
                </tr>
                <tr>
                    <td><b>ID</b></td>
                    <td><input type="number" name="sid" required></td>
                </tr>
                <tr>
                    <td><b>Gender</b></td>
                    <td><input type="text" name="sgender" required></td>
                </tr>
                <tr>
                    <td><b>Image</b></td>
                    <td><input type="file" name="simage" accept="image/*" required></td>
                </tr>
                <tr align="center">
                    <td><input type="submit" class="button" value="Add" required></td>
                    <td><input type="reset" class="button" value="Clear" required></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
