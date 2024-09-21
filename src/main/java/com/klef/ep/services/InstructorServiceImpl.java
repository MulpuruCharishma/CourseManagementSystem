package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Instructor;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class InstructorServiceImpl implements InstructorService
{

	@Override
	public String addinstructor(Instructor instructor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(instructor); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Instructor Registered Successfully";
	
	}

	@Override
	public String updateinstructor(Instructor instructor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Instructor i = em.find(Instructor.class, instructor.getId());
		i.setContact(instructor.getContact());
		i.setName(instructor.getName());
		i.setPassword(instructor.getPassword());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Instructor Updated Successfully";
	}

	@Override
	public Instructor checkinslogin(String email, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select i from Instructor i where i.email=? and i.password=?");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		
		Instructor in = null;
		if(qry.getResultList().size()>0)
		{
			in = (Instructor)qry.getSingleResult();
		}
		em.close();
		emf.close();
		
		return in;
	}
	@Override
	public String deleteinstructor(int iid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Instructor i = em.find(Instructor.class, iid);
		em.remove(i);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Instructor Deleted Successfully";
	}

	@Override
	public List<Instructor> viewallinstructors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select i from Instructor i");
		// e is an alias of Employee Class
		List<Instructor> inslist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return inslist;
	}

	@Override
	public Instructor viewinsbyid(int iid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Instructor i = em.find(Instructor.class, iid);
		
		if(i==null)
		{
			em.close();
			emf.close();
			
			return null;
		}
		
		em.close();
		emf.close();
		
		return i;
	}
}