package com.klef.ep.services;

import java.util.List;


import javax.ejb.Stateless;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Student;
import com.klef.ep.models.StudentMapping;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentServiceImpl implements StudentService
{

	@Override
	public String addstudent(Student student) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(student); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Student Registered Successfully";
	
	}
@Override
	public String updatestudent(Student student) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Student s = em.find(Student.class, student.getId());
		s.setContact(student.getContact());
		s.setName(student.getName());
		s.setPassword(student.getPassword());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Student Updated Successfully";
	}
@Override
	public Student checkstulogin(String email, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select s from Student s where s.email=? and s.password=?");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		Student std = null;
		if(qry.getResultList().size()>0)
		{
			std = (Student)qry.getSingleResult();
		}
		em.close();
		emf.close();
		
		return std;
	}
@Override
public String deletestudent(int sid)
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin(); //transaction begin 
	Student s = em.find(Student.class, sid);
	
	em.remove(s);
    em.getTransaction().commit();
	
	em.close();
	emf.close();
	
	return "Student Deleted Successfully";
	
}
@Override
public List<Student> viewallstudents() 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	Query qry = em.createQuery("select s from Student s");
	// s is an alias of student class
	List<Student> stdlist = qry.getResultList();
	
	em.close();
	emf.close();
	return stdlist;
}
@Override
public Student viewstudentbyid(int sid) 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	Student s = em.find(Student.class, sid);
	
	em.close(); 
	emf.close();
	
	return s;
}
@Override
public List<StudentMapping> mycourses(String name) 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	Query qry = em.createQuery("select mc from StudentMapping mc where mc.name=?");
	qry.setParameter(1, name);
	// e is an alias of Employee Class
	List<StudentMapping> sm = qry.getResultList();
	
	if(sm==null) {
		em.close();
	    emf.close();
		return null;
	}
	else {
    em.close();
    emf.close();
    
    return sm;
	}
}

}