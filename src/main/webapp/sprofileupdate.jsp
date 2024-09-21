
<%@page import="com.klef.ep.models.Student"%>
<%@page import="com.klef.ep.services.StudentService"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String password = request.getParameter("password");
String contact = request.getParameter("contact");


InitialContext context = new InitialContext();

StudentService studentService = (StudentService) context.lookup("java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService");

Student s = studentService.viewstudentbyid(id);

if(s!=null)
{
    //System.out.println("ID Found");
    Student std = new Student();
    std.setId(id);
    std.setName(name);
    std.setContact(contact);
    std.setPassword(password);
    
    studentService.updatestudent(std);
    
    Student student = studentService.viewstudentbyid(id);
    
    session.setAttribute("std", student);
    
    out.println("Student Profile Updated Successfully");
}
else
{
  out.println("Student ID Not Found");
}


%>