package com.klef.ep.beans;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.FacesComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Instructor;
import com.klef.ep.services.InstructorService;

// this bean will be acted as controller
@ManagedBean(name="insbean",eager=true)
public class InstructorBean 
{
	@EJB(lookup = "java:global/EPProject/InstructorServiceImpl!com.klef.ep.services.InstructorService")
	InstructorService service;
	private int id;
	private String name;
	private String gender;
	private String department;
	private String email;
	private String password;
	private String contact;
	private List<Instructor> inslist;
	
	public List<Instructor> getInslist() {
		return service.viewallinstructors();
	}
	public void setInslist(List<Instructor> inslist) {
		this.inslist = inslist;
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
	public String add()
	{
		Instructor i = new Instructor();
		i.setId(id);
		i.setName(name);
		i.setGender(gender);
		i.setDepartment(department);
		i.setEmail(email);
		i.setPassword(password);
		i.setContact(contact);
		
		service.addinstructor(i);
		
		// It will reset the form after redirection
		return "insreg.jsf?faces-redirect=true";
	}
	
	
	public String delete(int iid)
	{
		service.deleteinstructor(iid);
		
		return "viewallinstructors.jsf";
	}
	
	public String update()
	{
		Instructor ins = service.viewinsbyid(id);
		if(ins!=null)
		{
			Instructor i = new Instructor();
			i.setId(id);
			i.setName(name);
			
			i.setPassword(password);
			i.setContact(contact);
			
			service.updateinstructor(i);
			
			return "updatesuccess.jsf";
					
		}
		else
		{
			//System.out.println("ID Not Found");
			return "updatefail.jsf";
		}
		
		
	}
	
	
	public void validatelogin() throws IOException
	{
		FacesContext facescontext = FacesContext.getCurrentInstance();
		ExternalContext externalcontext = facescontext.getExternalContext();
		HttpServletRequest request= (HttpServletRequest)externalcontext.getRequest();
		HttpServletResponse response = (HttpServletResponse)externalcontext.getResponse();
		
		Instructor i = service.checkinslogin(email, password);
		if(i!=null)
		{
			//System.out.println("Login Success");
			//return "emphome.jsf";
			
			// explicit object
			HttpSession session = request.getSession();
			session.setAttribute("in", i); // emp is a session variable of type Employee
			
			response.sendRedirect("inshome.jsp");
			
		}
		else
		{
			//System.out.println("Login Fail");
			//return "loginfail.jsf";
			response.sendRedirect("insloginfail.jsf");
		}
	}
	
}