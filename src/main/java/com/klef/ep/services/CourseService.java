package com.klef.ep.services;

import java.util.List;

import com.klef.ep.models.Course;

public interface CourseService {
	public String addcourse(Course course);
	public String updatecourse(Course course);
	public List<Course> viewallcourses();
	public String deletecourse(int cid);
}