package com.klef.ep.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_table")
public class Course implements Serializable{
	@Id
	private int id;
	@Column(name="course_code",nullable=false,length=10)
	private String coursecode;
	@Column(name = "course_name",nullable = false,length = 50)
private String name;
	@Column(name = "course_department",nullable = false,length = 50)
private String department;
	
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
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

}