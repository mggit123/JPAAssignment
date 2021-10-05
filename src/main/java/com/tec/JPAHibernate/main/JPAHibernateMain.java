package com.tec.JPAHibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tec.JPAHibernate.entity.Employee;

/**
 * Hello world!
 *
 */
public class JPAHibernateMain {
	
    public static void main( String[] args ){
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
    	EntityManager entityManager = factory.createEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	Employee employee = new Employee("Magee", 1, "Software Dev");
    	entityManager.persist(employee);
    	Employee find = entityManager.find(Employee.class, 1);
    	System.out.println(find);
    	
    	
    	
    	transaction.commit();
    }
}
