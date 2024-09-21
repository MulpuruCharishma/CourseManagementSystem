package com.klef.ep.beans;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klef.ep.models.Course;
import com.klef.ep.services.CourseService;

@ManagedBean(name="coursebean",eager=true)
public class CourseBean {
	@EJB(lookup = "java:global/EPProject/CourseServiceImpl!com.klef.ep.services.CourseService")
	CourseService service;
	private int id;
	private String coursecode;
	private String name;
	private String department;
	private List<Course> courselist;
	
	
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public List<Course> getCourselist() {
		return service.viewallcourses();
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String add()
	{
		Course c = new Course();
		c.setId(id);
		c.setName(name);
		c.setDepartment(department);
		c.setCoursecode(coursecode);
		
		
		service.addcourse(c);
		
		// It will reset the form after redirection
		return "coursereg.jsf?faces-redirect=true";
	}
	
	public String delete(int cid)
	{
		service.deletecourse(cid);
		
		return "viewallcourses.jsf";
	}
}
