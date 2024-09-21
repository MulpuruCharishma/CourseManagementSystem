package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Course;
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CourseServiceImpl implements CourseService{

	@Override
	public String addcourse(Course course) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(course); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Course Registered Successfully";
	}

	@Override
	public String updatecourse(Course course) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Course c = em.find(Course.class, course.getId());
		
		c.setName(course.getName());
		c.setDepartment(course.getDepartment());
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Course Updated Successfully";
	}

	@Override
	public List<Course> viewallcourses() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select c from Course c");
		// e is an alias of Employee Class
		List<Course> courselist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return courselist;
	}

	@Override
	public String deletecourse(int cid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Course c = em.find(Course.class, cid);
		em.remove(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Course Deleted Successfully";
	}

}