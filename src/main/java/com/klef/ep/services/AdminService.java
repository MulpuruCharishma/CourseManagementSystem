package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Course;
import com.klef.ep.models.Instructor;
import com.klef.ep.models.Student;


@Remote
public interface AdminService 
{
  public Admin checkadminlogin(String username,String password);
  public List<Student> viewallstudents();
  public long studentcount();
  
  
  public List<Instructor> viewallinstructors();
  public long inscount();
  
  public List<Course> viewallcourses();
  
  public String addstudent(Student student);
  public Student viewstudentbyid(int id); 
 
}