package com.tec.JPAHibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

public class UpdateUsingJpql {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		String updateString="update Employee set name='mag' whre id =1";
		Query query=entityManager.createQuery(updateString);
		
		int result=query.executeUpdate();
		
		entityTransaction.commit();
		
	}

}
