package com.klef.ep.servletdemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.klef.ep.models.Student;
import com.klef.ep.services.AdminService;


@WebServlet("/insertstudent")
@MultipartConfig
public class Insertstudentservlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String sgender = request.getParameter("sgender");
			String sdepartment = request.getParameter("sdepartment");
			String semail = request.getParameter("semail");
			String spassword = request.getParameter("spassword");
			String scontact = request.getParameter("scontact");

			
			//Part file = request.getPart("bimage");
			String imageFileName = "";
			
			//System.out.println(file);
			String savePath = getServletContext().getRealPath("/images");
	        File fileSaveDir = new File(savePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	        }

	        for (Part part : request.getParts()) {
	            String fileName = extractFileName(part);
	            if (fileName != null && !fileName.equals("")) {
	                part.write(savePath + File.separator + fileName);
	                imageFileName = fileName;
	            }
	        }
			
			InitialContext context = new InitialContext();
			AdminService adminService = (AdminService) context.lookup("java:global/EPProject/AdminServiceImpl!com.klef.ep.services.AdminService");
			
			/*InputStream inputStream = file.getInputStream();
	        Blob blob = new javax.sql.rowset.serial.SerialBlob(getBytesFromInputStream(inputStream));*/
			
			Student student = new Student();
			student.setId(sid);
			student.setName(sname);
			student.setGender(sgender);
			student.setDepartment(sdepartment);
			student.setEmail(semail);
			student.setPassword(spassword);
			student.setContact(scontact);
			student.setImagedata(imageFileName);
			
			System.out.print(student);
			
			adminService.addstudent(student);
			response.sendRedirect("addstudentsuccess.jsp");
			
		}
		catch (Exception e) 
		{
			out.print(e);
		}
	}
	
	/*private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }*/
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return null;
    }

}