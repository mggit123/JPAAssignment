package com.tec.JPAHibernate.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class UpdateByDynamicJpql {
	public static void main(String[] args) {


		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your id:");
		int id=scanner.nextInt();
		System.out.println("enter your name:");
		String name=scanner.next();
		System.out.println("enter your designamtion:");
		String desig=scanner.next();

		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
			EntityManager manager=factory.createEntityManager();
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();

			String stringUpdate="update Emmployee set name= :name, designation=:desig where id=:id";
			Query query=manager.createNamedQuery(stringUpdate);
			query.setParameter("name", args[1]);
			query.setParameter("desig", args[2]);
			query.setParameter("id", Integer.parseInt(args[0]));
			int result=query.executeUpdate();
			transaction.commit();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

}
