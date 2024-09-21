package com.klef.ep.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klef.ep.models.StudentMapping;
import com.klef.ep.services.CourseMappingService;

@ManagedBean(name = "mappingbean",eager = true)
public class StudentMappingBean
{
@EJB(lookup="java:global/EPProject/CourseMappingServiceImpl!com.klef.ep.services.CourseMappingService")
CourseMappingService service;

	private int id;
	private String name;
	private String coursecode;
	private String coursename;
	private String department;
	
	
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
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void cmapping(int id,String name,String coursecode,String coursename,String department)
	{
		StudentMapping sm= new StudentMapping();
		sm.setName(name);
		sm.setCoursecode(coursecode);
		sm.setCoursename(coursename);
		sm.setDepartment(department);
		service.addmapping(sm);
	}
	

}
