package com.tec.JPAHibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tec.JPAHibernate.entity.Employee;

public class FindByIdImp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String findById="from Employee whre id =4";
		Query query=entityManager.createQuery(findById);
		Employee employee=(Employee) query.getSingleResult();
		System.out.println(employee);
		
		System.out.println("-----------------");
		
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getDesignation());
		System.out.println(employee.getSalary());
		
	}
	
}
