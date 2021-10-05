package com.tec.JPAHibernate.main;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tec.JPAHibernate.entity.Employee;

public class FindAllJpqlImp {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String findAll="from Employee";
		Query query=entityManager.createQuery(findAll);
		List<Employee> list =query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}
