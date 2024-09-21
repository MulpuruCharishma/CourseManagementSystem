package com.klef.ep.services;

import java.util.List;

import com.klef.ep.models.Instructor;

public interface InstructorService 
{
	public String addinstructor(Instructor instructor);
	public String updateinstructor(Instructor instructor);
	public Instructor checkinslogin(String email, String password);
	public String deleteinstructor(int iid);
	public List<Instructor> viewallinstructors();
	public Instructor viewinsbyid(int iid);
}