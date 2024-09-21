package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id // primary key = unique + not null
	private int id;
	@Column(name = "std_name",nullable = false,length = 50)
	private String name;
	@Column(name = "std_gender",nullable = false,length = 10)
	private String gender;
	@Column(name = "std_department",nullable = false,length = 50)
	private String department;
	@Column(name = "std_email",nullable = false,length = 50, unique=true)
	private String email;
	@Column(name = "std_password",nullable = false,length = 50)
	private String password;
	@Column(name = "std_contact",nullable = false,length = 20, unique=true)
	private String contact;

	@Lob
    @Column(nullable = false)
    private String imagedata;   
	
	public String getImagedata() {
		return imagedata;
	}

	public void setImagedata(String imageFileName) {
		this.imagedata = imageFileName;
		
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


}
