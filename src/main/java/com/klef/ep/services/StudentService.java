package com.klef.ep.services;

import java.util.List;

import com.klef.ep.models.Student;
import com.klef.ep.models.StudentMapping;

public interface StudentService
{
		public String addstudent(Student student);
		public String updatestudent(Student student);
		public Student checkstulogin(String email, String password);
	    public String deletestudent(int sid);
	    public List<Student> viewallstudents();
	    public Student viewstudentbyid(int sid);
	    public List<StudentMapping> mycourses(String name);
	    
	    

}
