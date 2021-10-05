package com.tec.JPAHibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tec.JPAHibernate.entity.Employee;

public class FindByUsingDynamicJpql {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String stringFindById="from Employee where id =:id";
		Query query=entityManager.createQuery(stringFindById);
		query.setParameter("id", Integer.parseInt(args[0]));
		Employee employee= (Employee) query.getSingleResult();
		System.out.println(employee);
	}
}
