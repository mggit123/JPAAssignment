package com.tec.JPAHibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tec.JPAHibernate.entity.Employee;

public class HibernateImp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee=new Employee("james", 20000,"testing");
		//entityManager.persist(employee);
		Employee employeeFind=entityManager.find(Employee.class, 4);
		entityManager.detach(employeeFind);
		Employee merge = entityManager.merge(employeeFind);
		entityManager.remove(merge);
		System.out.println(employeeFind);
		entityTransaction.commit();
	}
}
