package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.klef.ep.models.StudentMapping;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CourseMappingServiceImpl implements CourseMappingService
{

	@Override
	public void addmapping(StudentMapping studentMapping) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(studentMapping); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	

}
