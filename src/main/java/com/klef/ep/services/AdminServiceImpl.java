package com.klef.ep.services;

import java.util.List;



import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Course;
import com.klef.ep.models.Instructor;
import com.klef.ep.models.Student;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{

  @Override
  public Admin checkadminlogin(String username, String password) 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    // a is an alias of Admin Class
    Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?  ");
    qry.setParameter(1, username);
    qry.setParameter(2, password);
    
        Admin admin = null;
        
        if(qry.getResultList().size()>0)
        {
          admin = (Admin) qry.getSingleResult();
        }
    em.close();
    emf.close();
    
    return admin;
  }
  public List<Student> viewallstudents() 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    Query qry = em.createQuery("select s from Student s");
    List<Student> stdlist = qry.getResultList();
    
      em.close();
      emf.close();
      
      return stdlist;
  }
  
  @Override
  public long studentcount()
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    Query qry = em.createQuery("select count(*) from Student");
    List list = qry.getResultList();
    
    long count = (long) list.get(0);
    
    return count;
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


public String addstudent(Student student) 
{
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
   	  EntityManager em = emf.createEntityManager();
   	  
   	  em.getTransaction().begin();
   	  em.persist(student);     // insert product
   	  em.getTransaction().commit();
   	  
   	  em.close();
   	  emf.close();
   	  
   	  return "Product Inserted Successfully";
}



public Student viewstudentbyid(int id) 
{
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
  	 EntityManager em = emf.createEntityManager();
  	  
     em.getTransaction().begin();
     
     Query qry = em.createQuery("  select s from Student s where id=?  "); // atmost one object (0 or 1)
     qry.setParameter(1, id);
     
     Student s = null;
     
     if(qry.getResultList().size() > 0) 
     {
    	    s = (Student) qry.getSingleResult();
     }
     
     em.close();
     emf.close();
   
     return s;
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
public long inscount() {
	// TODO Auto-generated method stub
	return 0;
}
 
 

}