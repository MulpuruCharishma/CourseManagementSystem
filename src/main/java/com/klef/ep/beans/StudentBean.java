package com.klef.ep.beans;

import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Student;
import com.klef.ep.models.StudentMapping;
import com.klef.ep.services.StudentService;
@SessionScoped
@ManagedBean(name = "stdbean",eager = true)
public class StudentBean
{
	@EJB(lookup= "java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService")
	StudentService sservice;
	
	private int id;
	private Student student;
	
	private String name;
	private String gender;
	private String department;
	private String email;
	private String password;
	private String contact;
	private List<Student> stdlist;
	private List<StudentMapping> sm;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStdlist() {
		return sservice.viewallstudents();
	}
	public void setStdlist(List<Student> stdlist) {
		this.stdlist = stdlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public List<StudentMapping> getSm() {
		return sservice.mycourses(student.getName());
	}
	public void setSm(List<StudentMapping> sm) {
		this.sm = sm;
	}
	public String add()
	  {
	    Student s = new Student();
	    s.setId(id);
	    s.setName(name);
	    s.setGender(gender);
	    s.setDepartment(department);
	    s.setEmail(email);
	    s.setPassword(password);
	    s.setContact(contact);
	    
	    
	    sservice.addstudent(s);
	    
	    // This will reset the form submission
	    return "stureg.jsf?faces-redirect=true";    
	  }
	public void validatelogin() throws IOException
	  {
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 ExternalContext externalContext = facesContext.getExternalContext();
		 HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		 HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		  
		 Student s = sservice.checkstulogin(email, password);
		 
		 if(s!=null)
		 {

			 HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);		
			 session.setAttribute("student",s); 
			 this.student=s;
			
			 FacesContext.getCurrentInstance().getExternalContext().redirect("stuhome.jsp");
			 
		 }
		 else
		 {
			 //return "loginfail.jsf";
			 FacesContext.getCurrentInstance().getExternalContext().redirect("stuloginfail.jsf");		
			 }
	  }
	public String delete(int sid)
	{
		sservice.deletestudent(sid);
		return "viewallstudents.jsf";
	}

	public String update()
	{
		Student stu = sservice.viewstudentbyid(id);
		if(stu!=null) 
		{
			Student s = new Student();
		    s.setId(id);
		    s.setName(name);
		    s.setDepartment(department);
		    s.setPassword(password);
		    s.setContact(contact);
			
			sservice.updatestudent(s);
			
			return "supdatesuccess.jsf";
		}
		else
		{
			//System.out.println("ID Not Found");
			return "supdatefail.jsf";
		}
	}

}
